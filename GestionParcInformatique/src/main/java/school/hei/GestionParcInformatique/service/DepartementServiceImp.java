package school.hei.GestionParcInformatique.service;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.hei.GestionParcInformatique.entity.Departement;
import school.hei.GestionParcInformatique.repository.DepartementJdbcRepository;

import java.util.List;

@NoArgsConstructor
@Service
public abstract class DepartementServiceImp implements DepartementService {

    private DepartementJdbcRepository departementJdbcRepository ;

    @Autowired
    public DepartementServiceImp(DepartementJdbcRepository departementJdbcRepository) {
        this.departementJdbcRepository = departementJdbcRepository;
    }

    @Override
    public boolean createdDepartement(Departement newDepartement) {
        return departementJdbcRepository
                .createdDepartement(newDepartement);
    }

    @Override
    public Departement getDepartementById(long id_departement) {
        return departementJdbcRepository
                .getDepartementById(id_departement);
    }

    @Override
    public List<Departement> getAllDepartement() {
        return departementJdbcRepository
                .getAllDepartements();
    }

    @Override
    public boolean updateDepartement(long id_departement, Departement departement) {
        try {
            Departement existingDepartement = departementJdbcRepository.getDepartementById(id_departement);
            if (existingDepartement != null) {
                return departementJdbcRepository.updateDepartement(id_departement, departement);
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean deleteDepartement(long id_departement) {
        try {
            Departement existingDepartement = departementJdbcRepository.getDepartementById(id_departement);
            if (existingDepartement != null) {
                return departementJdbcRepository.deleteDepartement(id_departement);
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
