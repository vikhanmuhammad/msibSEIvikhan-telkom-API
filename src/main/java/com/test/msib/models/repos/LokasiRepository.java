package com.test.msib.models.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.test.msib.models.entities.Lokasi;

public interface LokasiRepository extends JpaRepository<Lokasi, Integer> {
}