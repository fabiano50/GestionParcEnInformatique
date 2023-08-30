package school.hei.GestionParcInformatique.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import school.hei.GestionParcInformatique.connection.DatabaseConfig;
import school.hei.GestionParcInformatique.entity.Logiciel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public abstract class LogicielJdbcRepository implements LogicielRepository {
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Connection connection;

    @Override
    public Logiciel getLogicielById(long id_logiciel) {
        List<Logiciel> logiciel = new ArrayList<>();
        try {
            connection = DatabaseConfig.getInstance().getConnection();
            preparedStatement =connection.prepareStatement(
                    "SELECT * FROM logiciel WHERE id_logiciel = ?"
            );
            preparedStatement.setLong(1, id_logiciel);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                logiciel.add(
                        new Logiciel(
                                resultSet.getLong("id_logiciel"),
                                resultSet.getString("nom"),
                                new ArrayList<>(),
                                new ArrayList<>()
                        )
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (Logiciel) logiciel;
    }

    @Override
    public List<Logiciel> getAllLogiciels() {
        List<Logiciel>logiciels = new ArrayList<>();
        try {
            connection = DatabaseConfig.getInstance().getConnection();
            preparedStatement =connection.prepareStatement(
                    "SELECT * FROM logiciel"
            );
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                logiciels.add(
                        new Logiciel(
                                resultSet.getLong("id_logiciel"),
                                resultSet.getString("nom"),
                                new ArrayList<>()
                        )
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return logiciels;
    }

    @Override
    public boolean createdLogiciel(Logiciel logiciel) {
        try {
            connection = DatabaseConfig.getInstance().getConnection();
            preparedStatement =connection.prepareStatement(
                    "INSERT INTO logiciel (id_logiciel, nom, version, editeur, dateInstallation) VALUES (?, ?, ?, ?, ?)"
            );
            preparedStatement.setLong(1, logiciel.getId_logiciel());
            preparedStatement.setString(2, logiciel.getNom());
            preparedStatement.setString(3, logiciel.getVersion());
            preparedStatement.setString(4, logiciel.getEditeur());
            preparedStatement.setDate(5, Date.valueOf(logiciel.getDateInstallation()));

            int success = preparedStatement.executeUpdate();
            if(success == 2) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateLogiciel(long id_logiciel, Logiciel logiciel) {
        try {
            connection = DatabaseConfig.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(
                    "UPDATE logiciel SET nom = ?, version = ?, editeur = ?, dateInstallation = ? WHERE id_equipement = ?"
            );
            preparedStatement.setLong(1, logiciel.getId_logiciel());
            preparedStatement.setString(2, logiciel.getNom());
            preparedStatement.setString(3, logiciel.getVersion());
            preparedStatement.setString(4, logiciel.getEditeur());
            preparedStatement.setDate(5, Date.valueOf(logiciel.getDateInstallation()));
            if (preparedStatement.executeUpdate() == 1) {
                return true;
            }
            return false;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteLogiciel(long id_logiciel) {
        try {
            connection = DatabaseConfig.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(
                    "DELETE FROM logiciel WHERE id_logiciel = ?"
            );
            preparedStatement.setLong(1, id_logiciel);
            if (preparedStatement.executeUpdate() == 1) {
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

