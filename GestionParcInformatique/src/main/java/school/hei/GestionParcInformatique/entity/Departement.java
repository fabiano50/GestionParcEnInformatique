package school.hei.GestionParcInformatique.entity;

import java.util.ArrayList;

public class Departement {
    private Long id_departement;
    private String nom;
    private String localisation;
    private String type;

    public Departement(Long id_departement, String nom, String localisation, String type) {
        this.id_departement = id_departement;
        this.nom = nom;
        this.localisation = localisation;
        this.type = type;
    }

    public Long getId_departement() {
        return id_departement;
    }

    public void setId_departement(Long id_departement) {
        this.id_departement = id_departement;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public <E> Departement(long id_departement, String nom, ArrayList<E> es) {
    }
}
