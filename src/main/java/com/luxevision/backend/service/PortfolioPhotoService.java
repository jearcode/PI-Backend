package com.luxevision.backend.service;

import com.luxevision.backend.entity.PortfolioPhoto;
import com.luxevision.backend.repository.PortfolioPhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PortfolioPhotoService {

    @Autowired
    private PortfolioPhotoRepository portfolioPhotoRepository;

    public PortfolioPhoto savePortfolioPhoto (PortfolioPhoto portfolioPhoto) {
        return portfolioPhotoRepository.save(portfolioPhoto);
    }

    public Optional<PortfolioPhoto> findPortfolioPhotoById (Integer id) {
        return portfolioPhotoRepository.findById(id);
    }

    public PortfolioPhoto updatePortfolioPhoto (PortfolioPhoto portfolioPhoto) {
        return portfolioPhotoRepository.save(portfolioPhoto);
    }

    public void deletePortfolioPhotoById (Integer id) {
        portfolioPhotoRepository.deleteById(id);
    }

    public List<PortfolioPhoto> findAllPortfolioPhotos() {
        return portfolioPhotoRepository.findAll();
    }


}
