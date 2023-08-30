package school.hei.GestionParcInformatique.service;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.hei.GestionParcInformatique.entity.Utilisateur;
import school.hei.GestionParcInformatique.repository.UtilisateurJdbcRepository;

import java.util.List;

@NoArgsConstructor
@Service
public abstract class UtilisateurServiceImp implements UtilisateurService {
    private UtilisateurJdbcRepository utilisateurJdbcRepository;

    @Autowired
    public UtilisateurServiceImp(UtilisateurJdbcRepository utilisateurJdbcRepository) {
        this.utilisateurJdbcRepository = utilisateurJdbcRepository;
    }

    @Override
    public boolean createdUtilisateur(Utilisateur utilisateur) {
        return utilisateurJdbcRepository
                .createdUtilisateur(utilisateur);
    }

    @Override
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurJdbcRepository
                .getAllUtilisateurs();
    }

    @Override
    public Utilisateur getUtilisateurById(long id_utilisateur) {
        return utilisateurJdbcRepository
                .getUtilisateurById(id_utilisateur);
    }

    @Override
    public boolean updateUtilisateur(long id_utilisateur, Utilisateur utilisateur) {
        try {
            Utilisateur existingUtilisateur = utilisateurJdbcRepository.getUtilisateurById(id_utilisateur);
            if (existingUtilisateur != null) {
                utilisateurJdbcRepository.updateUtilisateur(id_utilisateur, utilisateur);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteUtilisateur(long id) {
        try {
            Utilisateur existingUtilisateur = utilisateurJdbcRepository.getUtilisateurById(id);
            if (existingUtilisateur != null) {
                utilisateurJdbcRepository.deleteUtilisateur(id);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
