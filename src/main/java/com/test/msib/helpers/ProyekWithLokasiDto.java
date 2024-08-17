package com.test.msib.helpers;

import java.time.LocalDate;

public class ProyekWithLokasiDto {
    private Integer id;
    private String namaProyek;
    private String client;
    private LocalDate tglMulai;
    private LocalDate tglSelesai;
    private String pimpinanProyek;
    private String keterangan;
    private Integer lokasiId;

    public ProyekWithLokasiDto() {}

    public ProyekWithLokasiDto(Integer id, String namaProyek, String client, LocalDate tglMulai, LocalDate tglSelesai, String pimpinanProyek, String keterangan, Integer lokasiId) {
        this.id = id;
        this.namaProyek = namaProyek;
        this.client = client;
        this.tglMulai = tglMulai;
        this.tglSelesai = tglSelesai;
        this.pimpinanProyek = pimpinanProyek;
        this.keterangan = keterangan;
        this.lokasiId = lokasiId;
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

    public Integer getLokasiId(){
        return lokasiId;
    }

    public void setLokasiId(Integer lokasiId){
        this.lokasiId = lokasiId;
    }
}