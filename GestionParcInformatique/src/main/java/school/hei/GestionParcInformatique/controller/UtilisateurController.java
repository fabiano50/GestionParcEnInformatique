package school.hei.GestionParcInformatique.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.hei.GestionParcInformatique.entity.Utilisateur;
import school.hei.GestionParcInformatique.service.UtilisateurServiceImp;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/utilisateur")
public class UtilisateurController {
    private final UtilisateurServiceImp utilisateurServiceImp;

    @Autowired
    public UtilisateurController(UtilisateurServiceImp utilisateurServiceImp) {
        this.utilisateurServiceImp = utilisateurServiceImp;
    }

    @GetMapping("/")
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurServiceImp
                .getAllUtilisateurs();
    }

    @GetMapping("/{id}")
    public Utilisateur getUtilisateurById(@PathVariable long id_utilisateur) {
        return  utilisateurServiceImp
                .getUtilisateurById( id_utilisateur );
    }

    @PostMapping("/add")
    public String createdUtilisateur(@RequestBody Utilisateur newUser) {
        boolean success = utilisateurServiceImp.createdUtilisateur( newUser );
        if(success) {
            return "User added successfully";
        }else{
            return "Failed to add user";
        }
    }

    @PutMapping("/update/put/{id}")
    public String updateUtilisateur(@PathVariable Long id, @RequestBody Utilisateur newUser) {
        boolean success = utilisateurServiceImp.updateUtilisateur(id, newUser);
        if (success) {
            return "User updated successfully";
        }else {
        return "Failed to updated User";
        }
    }

    @PatchMapping("/update/patch/{id}")
    public String patchUtilisateur(@PathVariable long id, @RequestBody Map<String, String> newUser) {
        boolean success = utilisateurServiceImp.updateUtilisateur(id, (Utilisateur) newUser);
        if (success) {
            return "User updated successfully";
        }else {
            return "Failed to updated User";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteUtilisateur(@PathVariable Long id) {
        boolean success = utilisateurServiceImp.deleteUtilisateur(id);
        if (success) {
            return "User delete successfully";
        }else {
            return "Failed to delete User";
        }
    }
}
