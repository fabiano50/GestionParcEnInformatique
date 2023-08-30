package school.hei.GestionParcInformatique.service;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.hei.GestionParcInformatique.entity.Equipement;
import school.hei.GestionParcInformatique.repository.EquipementJdbcRepository;

import java.util.List;

@NoArgsConstructor
@Service
public abstract class EquipementServiceImp implements EquipementService {

    private EquipementJdbcRepository equipementJdbcRepository ;

    @Autowired
    public EquipementServiceImp(EquipementJdbcRepository equipementJdbcRepository) {
        this.equipementJdbcRepository = equipementJdbcRepository;
    }

    @Override
    public boolean createdEquipement(Equipement equipement) {
        return equipementJdbcRepository
                .createdEquipement(equipement);
    }

    @Override
    public Equipement getEquipmentById(long id_equipement) {
        return equipementJdbcRepository
                .getEquipementById(id_equipement);
    }

    @Override
    public List<Equipement> getAllEquipement() {
        return equipementJdbcRepository
                .getAllEquipements();
    }

    @Override
    public boolean updateEquipement(long id_equipement, Equipement equipement) {
        try {
            Equipement existingEquipement = equipementJdbcRepository.getEquipementById(id_equipement);
            if (existingEquipement != null) {
                return equipementJdbcRepository.updateEquipement(id_equipement, equipement);
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean deleteEquipement(long id_equipement) {
        try {
            Equipement existingEquipement = equipementJdbcRepository.getEquipementById(id_equipement);
            if (existingEquipement != null) {
                return equipementJdbcRepository.deleteEquipement(id_equipement);
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
