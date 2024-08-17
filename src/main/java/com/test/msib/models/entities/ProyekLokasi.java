package com.test.msib.models.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "proyek_lokasi")
public class ProyekLokasi implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "proyekLokasi", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Proyek> proyekList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "lokasi_id", nullable = false)
    @JsonBackReference
    private Lokasi lokasi;

    public ProyekLokasi() {}

    public ProyekLokasi(Lokasi lokasi, List<Proyek> proyekList) {
        this.lokasi = lokasi;
        this.proyekList = proyekList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Proyek> getProyekList() {
        return proyekList;
    }

    public void setProyekList(List<Proyek> proyekList) {
        this.proyekList = proyekList;
    }

    public Lokasi getLokasi() {
        return lokasi;
    }

    public void setLokasi(Lokasi lokasi) {
        this.lokasi = lokasi;
    }
}

