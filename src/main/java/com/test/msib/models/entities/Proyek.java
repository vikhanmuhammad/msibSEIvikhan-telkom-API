package com.test.msib.models.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonBackReference;


import java.time.LocalDate;
import java.io.Serializable;

@Entity
@Table(name = "proyek")
public class Proyek implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nama_proyek", length = 255, nullable = false)
    private String namaProyek;

    @Column(name = "client", length = 255, nullable = false)
    private String client;

    @Column(name = "tgl_mulai", nullable = false)
    private LocalDate tglMulai;

    @Column(name = "tgl_selesai", nullable = false)
    private LocalDate tglSelesai;

    @Column(name = "pimpinan_proyek", length = 255, nullable = false)
    private String pimpinanProyek;

    @Column(name = "keterangan", columnDefinition = "TEXT")
    private String keterangan;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private LocalDate createdAt;

    @ManyToOne
    @JoinColumn(name = "proyek_lokasi_id", nullable = false)
    @JsonBackReference
    private ProyekLokasi proyekLokasi;

    public Proyek() {}

    public Proyek(String namaProyek, String client, LocalDate tglMulai, LocalDate tglSelesai, String pimpinanProyek, String keterangan) {
        this.namaProyek = namaProyek;
        this.client = client;
        this.tglMulai = tglMulai;
        this.tglSelesai = tglSelesai;
        this.pimpinanProyek = pimpinanProyek;
        this.keterangan = keterangan;
    }

    public ProyekLokasi getProyekLokasi() {
        return proyekLokasi;
    }

    public void setProyekLokasi(ProyekLokasi proyekLokasi) {
        this.proyekLokasi = proyekLokasi;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamaProyek() {
        return namaProyek;
    }

    public void setNamaProyek(String namaProyek) {
        this.namaProyek = namaProyek;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public LocalDate getTglMulai() {
        return tglMulai;
    }

    public void setTglMulai(LocalDate tglMulai) {
        this.tglMulai = tglMulai;
    }

    public LocalDate getTglSelesai() {
        return tglSelesai;
    }

    public void setTglSelesai(LocalDate tglSelesai) {
        this.tglSelesai = tglSelesai;
    }

    public String getPimpinanProyek() {
        return pimpinanProyek;
    }

    public void setPimpinanProyek(String pimpinanProyek) {
        this.pimpinanProyek = pimpinanProyek;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
