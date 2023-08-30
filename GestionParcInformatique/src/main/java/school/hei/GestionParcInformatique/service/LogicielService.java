package school.hei.GestionParcInformatique.service;

import school.hei.GestionParcInformatique.entity.Logiciel;

import java.util.List;

public interface LogicielService {
    Logiciel getLogicielById(long id_logiciel);
    List<Logiciel> getAllLogiciels();
    boolean createdLogiciel(Logiciel logiciel);
    boolean updateLogiciel(long id_logiciel, Logiciel logiciel);
    boolean deleteLogiciel(long id_equipement);
}
