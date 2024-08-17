package com.test.msib.models.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.hibernate.annotations.CreationTimestamp;
import java.util.List;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonManagedReference;


import java.time.LocalDateTime;
import java.io.Serializable;

@Entity
@Table(name = "lokasi")
public class Lokasi implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nama_lokasi", length = 255, nullable = false)
    private String namaLokasi;

    @Column(name = "negara", length = 255, nullable = false)
    private String negara;

    @Column(name = "provinsi", length = 255, nullable = false)
    private String provinsi;

    @Column(name = "kota", length = 255, nullable = false)
    private String kota;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "lokasi")
    @JsonManagedReference
    private List<ProyekLokasi> proyekLokasiList;


    public Lokasi(){

    }

    public Lokasi(String namaLokasi, String negara, String provinsi, String kota, LocalDateTime createdAt, List<ProyekLokasi> proyekLokasiList) {
        this.namaLokasi = namaLokasi;
        this.negara = negara;
        this.provinsi = provinsi;
        this.kota = kota;
        this.createdAt = createdAt;
        this.proyekLokasiList = proyekLokasiList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamaLokasi() {
        return namaLokasi;
    }

    public void setNamaLokasi(String namaLokasi) {
        this.namaLokasi = namaLokasi;
    }

    public String getNegara() {
        return negara;
    }

    public void setNegara(String negara) {
        this.negara = negara;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<ProyekLokasi> getProyekLokasiList() {
        return proyekLokasiList;
    }

    public void setProyekLokasiList(List<ProyekLokasi> proyekLokasiList) {
        this.proyekLokasiList = proyekLokasiList;
    }
}
