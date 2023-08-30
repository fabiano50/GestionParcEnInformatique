package school.hei.GestionParcInformatique.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import school.hei.GestionParcInformatique.entity.Equipement;
import school.hei.GestionParcInformatique.service.EquipementServiceImp;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/equipement")
public class EquipementController {
    private final EquipementServiceImp equipementServiceImp;

    @Autowired
    public EquipementController(EquipementServiceImp equipementServiceImp) {
        this.equipementServiceImp = equipementServiceImp;
    }

    @GetMapping("/")
    public List<Equipement> getAllEquipements() {
        return equipementServiceImp
                .getAllEquipements();
    }

    @GetMapping("/{id}")
    public Equipement getEquipementById(@PathVariable long id_equipement) {
        return  equipementServiceImp
                .getEquipementById( id_equipement);
    }

    @PostMapping("/add")
    public String createdEquipement(@RequestBody Equipement newEquipement) {
        boolean success = equipementServiceImp.createdEquipement( newEquipement );
        if(success) {
            return "Equipement added successfully";
        }else{
            return "Failed to add Equipement";
        }
    }

    @PutMapping("/update/put/{id}")
    public String updateEquipement(@PathVariable Long id, @RequestBody Equipement newEquipement) {
        boolean success = equipementServiceImp.updateEquipement(id, newEquipement);
        if (success) {
            return "Equipement updated successfully";
        }else {
            return "Failed to updated Equipement";
        }
    }

    @PatchMapping("/update/patch/{id}")
    public String patchEquipement(@PathVariable long id, @RequestBody Map<String, String> newEquipement) {
        boolean success = equipementServiceImp.updateEquipement(id, (Equipement) newEquipement);
        if (success) {
            return "Equipement updated successfully";
        }else {
            return "Failed to updated Equipement";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteEquipement(@PathVariable Long id) {
        boolean success = equipementServiceImp.deleteEquipement(id);
        if (success) {
            return "Equipement delete successfully";
        }else {
            return "Failed to delete Equipement";
        }
    }
}

