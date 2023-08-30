package school.hei.GestionParcInformatique.repository;

import school.hei.GestionParcInformatique.entity.Departement;

import java.util.List;

public interface DepartementRepository {
    List<Departement> getAllDepartements();
    Departement getDepartementById(long id_departement);
    boolean createdDepartement(Departement newDepartement);
    boolean updateDepartement(long id, Departement departement);
    boolean deleteDepartement(long id);
}
