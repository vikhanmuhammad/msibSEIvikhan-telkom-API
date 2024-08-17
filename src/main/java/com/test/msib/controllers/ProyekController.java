package com.test.msib.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

import com.test.msib.services.ProyekService;
import com.test.msib.helpers.ProyekWithLokasiDto;

import com.test.msib.models.entities.Proyek;

@RestController
@RequestMapping("/proyek")
public class ProyekController {

    @Autowired
    private ProyekService proyekService;

    @PostMapping
    public Proyek addProyek(@RequestBody ProyekWithLokasiDto proyekWithLokasiDto) {
        return proyekService.addProyek(proyekWithLokasiDto);
    }

    @GetMapping
    public List<ProyekWithLokasiDto> getAllProyek() {
        return proyekService.getAllProyek();
    }

    @GetMapping("/{id}")
    public ProyekWithLokasiDto getProyekById(@PathVariable Integer id) {
        Optional<Proyek> proyek = proyekService.getProyekById(id);
        return proyek.map(p -> new ProyekWithLokasiDto(
                        p.getId(),
                        p.getNamaProyek(),
                        p.getClient(),
                        p.getTglMulai(),
                        p.getTglSelesai(),
                        p.getPimpinanProyek(),
                        p.getKeterangan(),
                        p.getProyekLokasi() != null ? p.getProyekLokasi().getLokasi().getId() : null))
                     .orElse(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proyek> updateProyek(@PathVariable Integer id, @RequestBody ProyekWithLokasiDto proyekWithLokasiDto) {
        Proyek updatedProyek = proyekService.updateProyek(id, proyekWithLokasiDto);
        return ResponseEntity.ok(updatedProyek);
    }

    @DeleteMapping("/{id}")
    public void deleteProyek(@PathVariable Integer id) {
        proyekService.deleteProyek(id);
    }
}