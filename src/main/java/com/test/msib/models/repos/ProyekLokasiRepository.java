package com.test.msib.models.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.test.msib.models.entities.Proyek;
import com.test.msib.models.entities.ProyekLokasi;

import java.util.List;

public interface ProyekLokasiRepository extends JpaRepository<ProyekLokasi, Integer> {
    
    @Query("SELECT pl FROM ProyekLokasi pl JOIN pl.proyekList p WHERE p = :proyek")
    ProyekLokasi findByProyek(@Param("proyek") Proyek proyek);
}
