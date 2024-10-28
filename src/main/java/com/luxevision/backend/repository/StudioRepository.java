package com.luxevision.backend.repository;
import com.luxevision.backend.entity.Studio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudioRepository extends JpaRepository<Studio, Integer> {

    @Query("SELECT s FROM Studio s ORDER BY FUNCTION('RAND')")
    List<Studio> findRandomStudios(org.springframework.data.domain.Pageable pageable);
}