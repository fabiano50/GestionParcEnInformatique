package school.hei.GestionParcInformatique.service;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.hei.GestionParcInformatique.entity.Logiciel;
import school.hei.GestionParcInformatique.repository.LogicielJdbcRepository;

import java.util.List;

@NoArgsConstructor
@Service
public abstract class LogicielServiceImp implements LogicielService {

    private LogicielJdbcRepository logicielJdbcRepository ;

    @Autowired
    public LogicielServiceImp(LogicielJdbcRepository logicielJdbcRepository) {
        this.logicielJdbcRepository = logicielJdbcRepository;
    }

    @Override
    public boolean createdLogiciel(Logiciel logiciel) {
        return logicielJdbcRepository
                .createdLogiciel(logiciel);
    }

    @Override
    public Logiciel getLogicielById(long id_logiciel) {
        return logicielJdbcRepository
                .getLogicielById(id_logiciel);
    }

    @Override
    public List<Logiciel> getAllLogiciels() {
        return logicielJdbcRepository
                .getAllLogiciels();
    }

    @Override
    public boolean updateLogiciel(long id_logiciel, Logiciel logiciel) {
        try {
            Logiciel existingLogiciel = logicielJdbcRepository.getLogicielById(id_logiciel);
            if (existingLogiciel != null) {
                return logicielJdbcRepository.updateLogiciel(id_logiciel, logiciel);
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean deleteLogiciel(long id_logiciel) {
        try {
            Logiciel existingLogiciel = logicielJdbcRepository.getLogicielById(id_logiciel);
            if (existingLogiciel != null) {
                return logicielJdbcRepository.deleteLogiciel(id_logiciel);
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}

