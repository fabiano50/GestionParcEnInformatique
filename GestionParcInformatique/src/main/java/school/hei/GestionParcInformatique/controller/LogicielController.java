package school.hei.GestionParcInformatique.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.hei.GestionParcInformatique.entity.Logiciel;
import school.hei.GestionParcInformatique.service.LogicielServiceImp;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/logiciel")
public class LogicielController {
    private final LogicielServiceImp logicielServiceImp;

    @Autowired
    public LogicielController(LogicielServiceImp logicielServiceImp) {
        this.logicielServiceImp = logicielServiceImp;
    }

    @GetMapping("/")
    public List<Logiciel> getAllLogiciels() {
        return logicielServiceImp
                .getAllLogiciels();
    }

    @GetMapping("/{id}")
    public Logiciel getLogicielById(@PathVariable long id_logiciel) {
        return  logicielServiceImp
                .getLogicielById( id_logiciel );
    }

    @PostMapping("/add")
    public String createdLogiciel(@RequestBody Logiciel newLogiciel) {
        boolean success = logicielServiceImp.createdLogiciel( newLogiciel );
        if(success) {
            return "Logiciel added successfully";
        }else{
            return "Failed to add Logiciel";
        }
    }

    @PutMapping("/update/put/{id}")
    public String updateLogiciel(@PathVariable Long id, @RequestBody Logiciel newLogiciel) {
        boolean success = logicielServiceImp.updateLogiciel(id, newLogiciel);
        if (success) {
            return "Logiciel updated successfully";
        }else {
            return "Failed to updated Logiciel";
        }
    }

    @PatchMapping("/update/patch/{id}")
    public String patchLogiciel(@PathVariable long id, @RequestBody Map<String, String> newLogiciel) {
        boolean success = logicielServiceImp.updateLogiciel(id, (Logiciel) newLogiciel);
        if (success) {
            return "Logiciel updated successfully";
        }else {
            return "Logiciel to updated Logiciel";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteLogiciel(@PathVariable Long id) {
        boolean success = logicielServiceImp.deleteLogiciel(id);
        if (success) {
            return "Logiciel delete successfully";
        }else {
            return "Failed to delete Logiciel";
        }
    }
}

