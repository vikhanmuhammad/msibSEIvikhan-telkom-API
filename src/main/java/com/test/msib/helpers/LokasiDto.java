package com.test.msib.helpers;

public class LokasiDto {
    private Integer id;
    private String namaLokasi;
    private String negara;
    private String provinsi;
    private String kota;

    public LokasiDto(Integer id, String namaLokasi, String negara, String provinsi, String kota) {
        this.id = id;
        this.namaLokasi = namaLokasi;
        this.negara = negara;
        this.provinsi = provinsi;
        this.kota = kota;
    }

    public Integer getId() {
        return id;
    }

    public String getNamaLokasi() {
        return namaLokasi;
    }

    public String getNegara() {
        return negara;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public String getKota() {
        return kota;
    }
}
