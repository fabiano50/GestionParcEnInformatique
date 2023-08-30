package school.hei.GestionParcInformatique.repository;

import school.hei.GestionParcInformatique.entity.Utilisateur;

import java.util.List;

public interface UtilisateurRepository {
    List<Utilisateur> getAllUtilisateurs();

    Utilisateur getUtilisateurById(long id_utilisateur);
    boolean createdUtilisateur(Utilisateur newUtilisateur);
    boolean updateUtilisateur(long id, Utilisateur utilisateur);
    boolean deleteUtilisateur(long id);
}
