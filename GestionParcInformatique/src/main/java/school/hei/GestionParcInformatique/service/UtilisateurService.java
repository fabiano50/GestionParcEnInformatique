package school.hei.GestionParcInformatique.service;

import school.hei.GestionParcInformatique.entity.Utilisateur;

import java.util.List;

public interface UtilisateurService {
    List<Utilisateur> getAllUtilisateurs();

    Utilisateur getUtilisateurById(long id_utilisateur);
    boolean createdUtilisateur(Utilisateur newUtilisateur);
    boolean updateUtilisateur(long id, Utilisateur utilisateur);
    boolean deleteUtilisateur(long id);
}
