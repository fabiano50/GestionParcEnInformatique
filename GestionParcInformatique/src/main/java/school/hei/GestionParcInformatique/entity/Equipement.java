package school.hei.GestionParcInformatique.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class Equipement {
    private Long id_equipement;
    private String nom;
    private LocalDate date_achat;
    private String etat;
    private String configuration;

    public Equipement(Long id_equipement, String nom, LocalDate date_achat, String etat, String configuration) {
        this.id_equipement = id_equipement;
        this.nom = nom;
        this.date_achat = date_achat;
        this.etat = etat;
        this.configuration = configuration;
    }

    public Equipement(long idUtilisateur, String nom, ArrayList<Object> objects) {
    }

    public <E> Equipement(long idEquipement, String nom, ArrayList<E> es, ArrayList<E> es1) {
    }

    public Long getId_equipement() {
        return id_equipement;
    }

    public void setId_equipement(Long id_equipement) {
        this.id_equipement = id_equipement;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getDate_achat() {
        return date_achat;
    }

    public void setDate_achat(LocalDate date_achat) {
        this.date_achat = date_achat;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }
}
