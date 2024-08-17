package com.test.msib.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.msib.models.entities.Lokasi;
import com.test.msib.models.repos.LokasiRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LokasiService {

    @Autowired
    private LokasiRepository lokasiRepository;

    public Lokasi addLokasi(Lokasi lokasi) {
        return lokasiRepository.save(lokasi);
    }

    public List<Lokasi> getAllLokasi() {
        return lokasiRepository.findAll();
    }

    public Optional<Lokasi> getLokasiById(Integer id) {
        return lokasiRepository.findById(id);
    }

    public Lokasi updateLokasi(Integer id, Lokasi lokasi) {
        Optional<Lokasi> existingLokasi = lokasiRepository.findById(id);
        if (existingLokasi.isPresent()) {
            Lokasi lokasiToUpdate = existingLokasi.get();
            lokasiToUpdate.setNamaLokasi(lokasi.getNamaLokasi());
            lokasiToUpdate.setNegara(lokasi.getNegara());
            lokasiToUpdate.setProvinsi(lokasi.getProvinsi());
            lokasiToUpdate.setKota(lokasi.getKota());
            return lokasiRepository.save(lokasiToUpdate);
        } else {
            return null;
        }
    }

    public void deleteLokasi(Integer id) {
        lokasiRepository.deleteById(id);
    }
}
