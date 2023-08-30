package school.hei.GestionParcInformatique.entity;

import java.time.LocalDate;
import java.util.ArrayList;

public class Logiciel {
    private Long id_logiciel;
    private String nom;
    private String version;
    private String editeur;
    private LocalDate dateInstallation;

    public Logiciel(Long id_logiciel, String nom, String version, String editeur, LocalDate dateInstallation) {
        this.id_logiciel = id_logiciel;
        this.nom = nom;
        this.version = version;
        this.editeur = editeur;
        this.dateInstallation = dateInstallation;
    }

    public <E> Logiciel(long idLogiciel, String nom, ArrayList<E> es) {
    }

    public Long getId_logiciel() {
        return id_logiciel;
    }

    public void setId_logiciel(Long id_logiciel) {
        this.id_logiciel = id_logiciel;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getEditeur() {
        return editeur;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    public LocalDate getDateInstallation() {
        return dateInstallation;
    }

    public void setDateInstallation(LocalDate dateInstallation) {
        this.dateInstallation = dateInstallation;
    }

    public <E> Logiciel(long idLogiciel, String nom, ArrayList<E> es, ArrayList<E> es1) {
    }
}
