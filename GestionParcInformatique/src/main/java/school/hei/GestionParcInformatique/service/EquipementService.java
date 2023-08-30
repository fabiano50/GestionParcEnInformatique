package school.hei.GestionParcInformatique.service;

import school.hei.GestionParcInformatique.entity.Departement;
import school.hei.GestionParcInformatique.entity.Equipement;
import school.hei.GestionParcInformatique.entity.Logiciel;

import java.util.List;

public interface EquipementService {
    List<Equipement> getAllEquipements();

    Equipement getEquipementById(long id_equipement);
    boolean createdEquipement(Equipement newEquipement);

    Departement getDepartementById(long id_departement);

    List<Departement> getAllDepartement();

    boolean updateEquipement(long id, Equipement equipement);

    boolean createdLogiciel(Logiciel logiciel);

    Logiciel getLogicielById(long id_logiciel);

    List<Logiciel> getAllLogiciels();

    boolean updateEquipement(long id_logiciel, Logiciel logiciel);

    boolean deleteEquipement(long id);

    Equipement getEquipmentById(Long id);

    Equipement getEquipmentById(long id_equipement);

    List<Equipement> getAllEquipment();

    boolean updateEquipement(Long id, Equipement equipment);

    List<Equipement> getAllEquipement();

    boolean deleteEquipement(Long id);

    boolean updateLogiciel(long id_logiciel, Logiciel logiciel);

    boolean deleteLogiciel(long id_logiciel);
}
