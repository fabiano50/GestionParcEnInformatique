package school.hei.GestionParcInformatique.repository;

import school.hei.GestionParcInformatique.entity.Equipement;

import java.util.List;

public interface EquipementRepository {
    List<Equipement> getAllEquipements();

    Equipement getEquipementById(long id_equipement);
    boolean createdEquipement(Equipement newEquipement);
    boolean updateEquipement(long id, Equipement equipement);
    boolean deleteEquipement(long id);

}
