package com.test.msib.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.test.msib.models.repos.ProyekLokasiRepository;
import com.test.msib.models.repos.ProyekRepository;
import com.test.msib.models.repos.LokasiRepository;
import com.test.msib.models.entities.Proyek;
import com.test.msib.models.entities.Lokasi;
import com.test.msib.models.entities.ProyekLokasi;
import com.test.msib.helpers.ProyekWithLokasiDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProyekService {

    @Autowired
    private ProyekRepository proyekRepository;

    @Autowired
    private ProyekLokasiRepository proyekLokasiRepository;

    @Autowired
    private LokasiRepository lokasiRepository;

    public Proyek addProyek(ProyekWithLokasiDto proyekWithLokasiDto) {
        Lokasi lokasi = lokasiRepository.findById(proyekWithLokasiDto.getLokasiId())
                .orElseThrow(() -> new RuntimeException("Lokasi tidak ditemukan"));
        
        Proyek proyek = new Proyek(
                proyekWithLokasiDto.getNamaProyek(),
                proyekWithLokasiDto.getClient(),
                proyekWithLokasiDto.getTglMulai(),
                proyekWithLokasiDto.getTglSelesai(),
                proyekWithLokasiDto.getPimpinanProyek(),
                proyekWithLokasiDto.getKeterangan()
        );
    
        ProyekLokasi proyekLokasi = new ProyekLokasi();
        proyekLokasi.setLokasi(lokasi);
        proyekLokasi.getProyekList().add(proyek);
        
        proyek.setProyekLokasi(proyekLokasi);
        
        ProyekLokasi savedProyekLokasi = proyekLokasiRepository.save(proyekLokasi);
        
        Proyek savedProyek = proyekRepository.save(proyek);
        
        return savedProyek;
    }
    
    public List<ProyekWithLokasiDto> getAllProyek() {
        List<Proyek> proyekList = proyekRepository.findAll();
        List<ProyekWithLokasiDto> proyekWithLokasiDtoList = new ArrayList<>();
    
        for (Proyek proyek : proyekList) {
            ProyekLokasi proyekLokasi = proyekLokasiRepository.findByProyek(proyek);
    
            Integer lokasiId = (proyekLokasi != null && proyekLokasi.getLokasi() != null) ? 
                proyekLokasi.getLokasi().getId() : null;
    
            ProyekWithLokasiDto dto = new ProyekWithLokasiDto(
                    proyek.getId(),
                    proyek.getNamaProyek(),
                    proyek.getClient(),
                    proyek.getTglMulai(),
                    proyek.getTglSelesai(),
                    proyek.getPimpinanProyek(),
                    proyek.getKeterangan(),
                    lokasiId
            );
            proyekWithLokasiDtoList.add(dto);
        }
    
        return proyekWithLokasiDtoList;
    }

    public Optional<Proyek> getProyekById(Integer id) {
        return proyekRepository.findById(id);
    }

    public Proyek updateProyek(Integer id, ProyekWithLokasiDto proyekWithLokasiDto) {
        Proyek proyek = proyekRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proyek tidak ditemukan"));

        proyek.setNamaProyek(proyekWithLokasiDto.getNamaProyek());
        proyek.setClient(proyekWithLokasiDto.getClient());
        proyek.setTglMulai(proyekWithLokasiDto.getTglMulai());
        proyek.setTglSelesai(proyekWithLokasiDto.getTglSelesai());
        proyek.setPimpinanProyek(proyekWithLokasiDto.getPimpinanProyek());
        proyek.setKeterangan(proyekWithLokasiDto.getKeterangan());

        if (proyekWithLokasiDto.getLokasiId() != null) {
            Lokasi lokasi = lokasiRepository.findById(proyekWithLokasiDto.getLokasiId())
                    .orElseThrow(() -> new RuntimeException("Lokasi tidak ditemukan"));

            ProyekLokasi proyekLokasi = proyekLokasiRepository.findByProyek(proyek);
            if (proyekLokasi != null) {
                proyekLokasi.setLokasi(lokasi);
                proyekLokasiRepository.save(proyekLokasi);
            }
        }

        return proyekRepository.save(proyek);
    }

    public void deleteProyek(Integer id) {
        proyekRepository.deleteById(id);
    }
}

