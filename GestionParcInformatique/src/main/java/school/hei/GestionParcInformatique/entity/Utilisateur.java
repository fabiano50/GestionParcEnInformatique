package school.hei.GestionParcInformatique.entity;

import lombok.*;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Utilisateur {
    private Long id_utilisateur;
    private String nom;

    public Utilisateur(long idUtilisateur, String nom, ArrayList<Object> objects, ArrayList<Object> objects1) {
    }

    public <E> Utilisateur(long idUtilisateur, String nom, ArrayList<E> es) {
    }

    public Long getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(Long id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
