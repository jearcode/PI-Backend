package com.luxevision.backend.service;

import com.luxevision.backend.dto.*;
import com.luxevision.backend.entity.*;
import com.luxevision.backend.entity.util.Status;
import com.luxevision.backend.exception.*;
import com.luxevision.backend.repository.BookingRepository;
import com.luxevision.backend.repository.StudioPriceRepository;
import com.luxevision.backend.repository.StudioSpecialtyRepository;
import com.luxevision.backend.repository.StudioWorkingHoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private StudioService studioService;

    @Autowired
    private StudioWorkingHoursRepository studioWorkingHoursRepository;

    @Autowired
    private StudioSpecialtyRepository studioSpecialtyRepository;

    @Autowired
    private StudioPriceRepository studioPriceRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private SpecialtyService specialtyService;

    private boolean isMultipleOfThirtyMinutes(LocalTime time) {
        int minutes = time.getMinute();
        return minutes % 30 == 0;
    }

    private BookingResponse bookingToBookingResponse (Booking booking) {

        return BookingResponse.builder()
                .id(booking.getId())
                .date(booking.getDate())
                .startTime(booking.getStartTime())
                .endTime(booking.getEndTime())
                .totalPrice(booking.getTotalPrice())
                .status(booking.getStatus())
                .studioID(booking.getStudio().getId())
                .specialtyID(booking.getSpecialty().getId())
                .user(booking.getUser().getFirstName() + " " + booking.getUser().getLastName())
                .build();

    }

    public BookingResponse saveBooking (SaveBooking booking) {

        Integer studioID = booking.getStudioID();
        Integer specialtyID = booking.getSpecialtyID();
        LocalDate date = booking.getDate();
        LocalTime startTime = booking.getStartTime();
        LocalTime endTime = booking.getEndTime();
        DayOfWeek dayOfWeek = date.getDayOfWeek();


        Studio studioFromDB = studioService.findStudioById(studioID)
                .orElseThrow(() -> new ObjectNotFoundException("Studio with id " + studioID + " not found"));

        Specialty specialtyFromDB = specialtyService.findSpecialtyById(specialtyID)
                .orElseThrow(() -> new ObjectNotFoundException("Specialty with id " + specialtyID + " not found"));


        if (!studioSpecialtyRepository.existsStudioSpecialtiesByStudioIdAndSpecialtyId(studioID, specialtyID)) {
            throw new StudioSpecialtyNotFoundException(
                    "The study with ID " + studioID + " is not linked to the specialty " + specialtyID + ".");
        }

        if (startTime.isAfter(endTime)) {
            throw new InvalidScheduleException("The start time cannot be after the end time.");
        }

        if (date.isBefore(LocalDate.now())) {
            throw new InvalidScheduleException("The date must be today or a future date; it cannot be a past date.");
        }

        if (!isMultipleOfThirtyMinutes(startTime) || !isMultipleOfThirtyMinutes(endTime)) {
            throw new InvalidScheduleException("The start and end times must be in increments of 30 minutes.");
        }

        Optional<StudioWorkingHours> studioWorkingHours =
                studioWorkingHoursRepository.findByStudioAndDayOfWeek(studioFromDB, dayOfWeek);

        if (studioWorkingHours.isEmpty()) {
            throw new StudioHoursViolationException("The studio does not operate on " + dayOfWeek + ". Please check the studio's schedule for available days.");
        }

        StudioWorkingHours workingHours = studioWorkingHours.get();
        if (startTime.isBefore(workingHours.getOpeningTime()) || endTime.isAfter(workingHours.getClosingTime())) {
            throw new StudioHoursViolationException("The requested time falls outside the studio's operating hours. Please ensure that your selected time is within the studio's opening and closing times.");
        }

        if (bookingRepository.existsByDateAndTimeOverlap(date, startTime, endTime, studioID)) {
            throw new BookingConflictException("The selected time slot is already booked. Please choose a different time or date for your reservation.");
        }

        Duration duration = Duration.between(startTime, endTime);
        long totalMinutes = duration.toMinutes();

        if (totalMinutes < 30) {
            throw new BookingConflictException("Bookings must have a minimum duration of 30 minutes. Please adjust your reservation time accordingly.");
        }

        long thirtyMinuteBlocks = (totalMinutes + 29) / 30;

        StudioPrice studioPrice = studioPriceRepository.findStudioPriceByStudioIdAndSpecialtyId(studioID, specialtyID);
        if (studioPrice == null) {
            throw new InvalidPriceException("No price was found for the provided studio and specialty.");
        }

        Double pricePerHalfHour = studioPrice.getPrice();
        if (pricePerHalfHour == null || pricePerHalfHour <= 0) {
            throw new InvalidPriceException("The price per half hour is invalid.");
        }


        Double totalPrice = pricePerHalfHour * thirtyMinuteBlocks;

        User user = userService.findLoggedInUser();

        Booking bookingToSave = Booking.builder()
                .date(date)
                .startTime(startTime)
                .endTime(endTime)
                .totalPrice(totalPrice)
                .status(Status.CONFIRMED)
                .studio(studioFromDB)
                .specialty(specialtyFromDB)
                .user(user)
                .build();

        Booking savedBooking = bookingRepository.save(bookingToSave);

        return bookingToBookingResponse(savedBooking);

    }

    public QuotationResponse quoteBooking (QuotationRequest quotation) {

        Integer studioID = quotation.getStudioID();
        Integer specialtyID = quotation.getSpecialtyID();
        LocalDate date = quotation.getDate();
        LocalTime startTime = quotation.getStartTime();
        LocalTime endTime = quotation.getEndTime();
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        Studio studioFromDB = studioService.findStudioById(studioID)
                .orElseThrow(() -> new ObjectNotFoundException("Studio with id " + studioID + " not found"));

        Specialty specialtyFromDB = specialtyService.findSpecialtyById(specialtyID)
                .orElseThrow(() -> new ObjectNotFoundException("Specialty with id " + specialtyID + " not found"));

        if (!studioSpecialtyRepository.existsStudioSpecialtiesByStudioIdAndSpecialtyId(studioID, specialtyID)) {
            throw new StudioSpecialtyNotFoundException(
                    "The study with ID " + studioID + " is not linked to the specialty " + specialtyID + ".");
        }

        if (startTime.isAfter(endTime)) {
            throw new InvalidScheduleException("The start time cannot be after the end time.");
        }

        if (date.isBefore(LocalDate.now())) {
            throw new InvalidScheduleException("The date must be today or a future date; it cannot be a past date.");
        }

        if (!isMultipleOfThirtyMinutes(startTime) || !isMultipleOfThirtyMinutes(endTime)) {
            throw new InvalidScheduleException("The start and end times must be in increments of 30 minutes.");
        }

        Optional<StudioWorkingHours> studioWorkingHours =
                studioWorkingHoursRepository.findByStudioAndDayOfWeek(studioFromDB, dayOfWeek);

        if (studioWorkingHours.isEmpty()) {
            throw new StudioHoursViolationException("The studio does not operate on " + dayOfWeek + ". Please check the studio's schedule for available days.");
        }

        StudioWorkingHours workingHours = studioWorkingHours.get();
        if (startTime.isBefore(workingHours.getOpeningTime()) || endTime.isAfter(workingHours.getClosingTime())) {
            throw new StudioHoursViolationException("The requested time falls outside the studio's operating hours. Please ensure that your selected time is within the studio's opening and closing times.");
        }

        if (bookingRepository.existsByDateAndTimeOverlap(date, startTime, endTime, studioID)) {
            throw new BookingConflictException("The selected time slot is already booked. Please choose a different time or date for your reservation.");
        }

        Duration duration = Duration.between(startTime, endTime);
        long totalMinutes = duration.toMinutes();
        Double totalHours = totalMinutes / 60.0;

        if (totalMinutes < 30) {
            throw new BookingConflictException("Bookings must have a minimum duration of 30 minutes. Please adjust your reservation time accordingly.");
        }

        long thirtyMinuteBlocks = (totalMinutes + 29) / 30;

        StudioPrice studioPrice = studioPriceRepository.findStudioPriceByStudioIdAndSpecialtyId(studioID, specialtyID);
        if (studioPrice == null) {
            throw new InvalidPriceException("No price was found for the provided studio and specialty.");
        }

        Double pricePerHalfHour = studioPrice.getPrice();
        if (pricePerHalfHour == null || pricePerHalfHour <= 0) {
            throw new InvalidPriceException("The price per half hour is invalid.");
        }

        Double totalPrice = pricePerHalfHour * thirtyMinuteBlocks;

        QuotationResponse quotationResponse = new QuotationResponse();
        quotationResponse.setSpecialtyID(specialtyFromDB.getId());
        quotationResponse.setStudioID(studioFromDB.getId());
        quotationResponse.setDate(date);
        quotationResponse.setStartTime(startTime);
        quotationResponse.setEndTime(endTime);
        quotationResponse.setHours("From " + startTime + " to " + endTime);
        quotationResponse.setTotalHours(String.format("%.2f hours", totalHours));
        quotationResponse.setPricePerHalfHour(pricePerHalfHour);
        quotationResponse.setTotalPrice(totalPrice);

        return quotationResponse;

    }

    public List<BookingResponse> findAllBookings () {

        List<Booking> bookings = bookingRepository.findAll();

        List<BookingResponse> bookingResponses = bookings.stream()
                .map( (booking -> bookingToBookingResponse(booking)) ).collect(Collectors.toList());

        return bookingResponses;

    }

    public List<BookingResponse> findAllBookingsFromTodayOnwards () {

        List<Booking> bookings = bookingRepository.findAllByDateIsAfter(LocalDate.now());

        List<BookingResponse> bookingResponses = bookings.stream()
                .map( (booking) -> bookingToBookingResponse(booking) ).collect(Collectors.toList());

        return bookingResponses;

    }

    public List<BookingResponse> findAllBookingsByStudioId (Integer id) {

        List<Booking> bookings = bookingRepository.findAllByStudioId(id);

        List<BookingResponse> bookingResponses = bookings.stream()
                .map( (booking) -> bookingToBookingResponse(booking) ).collect(Collectors.toList());

        return bookingResponses;

    }

    public List<BookingResponse> findAllBookingsByStudioFromTodayOnwards (Integer id) {

        List<Booking> bookings = bookingRepository.findAllByDateIsAfterAndStudioId(LocalDate.now(), id);

        List<BookingResponse> bookingResponses = bookings.stream()
                .map( (booking) -> bookingToBookingResponse(booking) ).collect(Collectors.toList());

        return bookingResponses;

    }

    public BookingResponse findOneBookingById (Long id) {

        return bookingToBookingResponse(bookingRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Booking with id " + id + " not found.")
        ));

    }




}
