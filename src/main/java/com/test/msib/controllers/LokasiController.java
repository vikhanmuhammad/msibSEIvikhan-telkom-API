package com.test.msib.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

import com.test.msib.services.LokasiService;
import com.test.msib.models.entities.Lokasi;
import com.test.msib.helpers.LokasiDto;



@RestController
@RequestMapping("/lokasi")
public class LokasiController {

    @Autowired
    private LokasiService lokasiService;

    @PostMapping
    public Lokasi addLokasi(@RequestBody Lokasi lokasi) {
        return lokasiService.addLokasi(lokasi);
    }

    @GetMapping
    public List<LokasiDto> getAllLokasi() {
    List<Lokasi> lokasiList = lokasiService.getAllLokasi();
    return lokasiList.stream()
            .map(lokasi -> new LokasiDto(lokasi.getId(), lokasi.getNamaLokasi(), lokasi.getNegara(), lokasi.getProvinsi(), lokasi.getKota()))
            .toList();
    }

    @GetMapping("/{id}")
    public LokasiDto getLokasiById(@PathVariable Integer id) {
        Optional<Lokasi> lokasi = lokasiService.getLokasiById(id);
        return lokasi.map(l -> new LokasiDto(l.getId(), l.getNamaLokasi(), l.getNegara(), l.getProvinsi(), l.getKota()))
                     .orElse(null);
    }

    @PutMapping("/{id}")
    public Lokasi updateLokasi(@PathVariable Integer id, @RequestBody Lokasi lokasi) {
        return lokasiService.updateLokasi(id, lokasi);
    }

    @DeleteMapping("/{id}")
    public void deleteLokasi(@PathVariable Integer id) {
        lokasiService.deleteLokasi(id);
    }
}