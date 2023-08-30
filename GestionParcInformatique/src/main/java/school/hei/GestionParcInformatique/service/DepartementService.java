package school.hei.GestionParcInformatique.service;

import school.hei.GestionParcInformatique.entity.Departement;

import java.util.List;

public interface DepartementService {
    List<Departement> getAllDepartements();
    Departement getDepartementById(long id_departement);
    boolean createdDepartement(Departement newDepartement);

    List<Departement> getAllDepartement();

    boolean updateDepartement(long id, Departement departement);
    boolean deleteDepartement(long id);
}
