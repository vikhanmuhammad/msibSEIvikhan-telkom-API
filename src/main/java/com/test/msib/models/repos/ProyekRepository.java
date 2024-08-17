package com.test.msib.models.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.test.msib.models.entities.Proyek;

public interface ProyekRepository extends JpaRepository<Proyek, Integer> {
}