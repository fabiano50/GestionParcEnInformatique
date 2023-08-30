package school.hei.GestionParcInformatique.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.hei.GestionParcInformatique.entity.Departement;
import school.hei.GestionParcInformatique.service.DepartementServiceImp;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/departement")
public abstract class DepartementController {

    private final DepartementServiceImp departementServiceImp ;

    @Autowired
    public DepartementController(DepartementServiceImp departementServiceImp) {
        this.departementServiceImp = departementServiceImp;
    }

    @GetMapping("/")
    public List<Departement> getAllDepartements() {
        return departementServiceImp
                .getAllDepartements();
    }

    @GetMapping("/{id}")
    public Departement getDepartementById(@PathVariable long id_departement) {
        return  departementServiceImp
                .getDepartementById( id_departement);
    }

    @PostMapping("/add")
    public String createdDepartement(@RequestBody Departement newDepartement) {
        boolean success = departementServiceImp.createdDepartement( newDepartement );
        if(success) {
            return "Departement added successfully";
        }else{
            return "Failed to add Departement";
        }
    }

    @PutMapping("/update/put/{id}")
    public String updateDepartement(@PathVariable long id, @RequestBody Departement newDepartement) {
        boolean success = departementServiceImp.updateDepartement(id, newDepartement);
        if (success) {
            return "Departement updated successfully";
        }else {
            return "Failed to updated Departement";
        }
    }

    @PatchMapping("/update/patch/{id}")
    public String patchDepartement(@PathVariable long id, @RequestBody Map<String, String> newDepartement) {
        boolean success = departementServiceImp.updateDepartement(id, (Departement) newDepartement);
        if (success) {
            return "Departement updated successfully";
        }else {
            return "Failed to updated Departement";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteDepartement(@PathVariable long id) {
        boolean success = departementServiceImp.deleteDepartement(id);
        if (success) {
            return "Departement delete successfully";
        }else {
            return "Failed to delete Departement";
        }
    }

}