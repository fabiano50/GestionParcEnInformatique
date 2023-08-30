package school.hei.GestionParcInformatique.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import school.hei.GestionParcInformatique.connection.DatabaseConfig;
import school.hei.GestionParcInformatique.entity.Equipement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public abstract class EquipementJdbcRepository implements EquipementRepository {
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Connection connection;

    @Override
    public Equipement getEquipementById(long id_equipement) {
        List<Equipement> equipements = new ArrayList<>();
        try {
            connection = DatabaseConfig.getInstance().getConnection();
            preparedStatement =connection.prepareStatement(
                    "SELECT * FROM equipement WHERE id_equipement = ?"
            );
            preparedStatement.setLong(1, id_equipement);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                equipements.add(
                        new Equipement(
                                resultSet.getLong("id_equipement"),
                                resultSet.getString("nom"),
                                new ArrayList<>(),
                                new ArrayList<>()
                        )
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (Equipement) equipements;
    }

    @Override
    public List<Equipement> getAllEquipements() {
        List<Equipement> equipement = new ArrayList<>();
        try {
            connection = DatabaseConfig.getInstance().getConnection();
            preparedStatement =connection.prepareStatement(
                    "SELECT * FROM equipement"
            );
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                equipement.add(
                        new Equipement(
                                resultSet.getLong("id_utilisateur"),
                                resultSet.getString("nom"),
                                new ArrayList<>()
                        )
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equipement;
    }

    @Override
    public boolean createdEquipement(Equipement equipement) {
        try {
            connection = DatabaseConfig.getInstance().getConnection();
            preparedStatement =connection.prepareStatement(
                    "INSERT INTO equipement (id_equipement, nom, date_achat, etat, configuration) VALUES (?, ?, ?, ?, ?)"
            );
            preparedStatement.setLong(1, equipement.getId_equipement());
            preparedStatement.setString(2, equipement.getNom());
            preparedStatement.setDate(3, Date.valueOf(equipement.getDate_achat()));
            preparedStatement.setString(4, equipement.getEtat());
            preparedStatement.setString(5, equipement.getConfiguration());

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
    public boolean updateEquipement(long id_equipement, Equipement equipement) {
        try {
            connection = DatabaseConfig.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(
                    "UPDATE equipement SET nom = ?, date_achat = ?, etat = ?, configuration = ? WHERE id_equipement = ?"
            );
            preparedStatement.setString(1, equipement.getNom());
            preparedStatement.setDate(2, Date.valueOf(equipement.getDate_achat()));
            preparedStatement.setString(3, equipement.getEtat());
            preparedStatement.setString(4, equipement.getConfiguration());
            preparedStatement.setLong(5, equipement.getId_equipement());
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
    public boolean deleteEquipement(long id_equipement) {
        try {
            connection = DatabaseConfig.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(
                    "DELETE FROM equipement WHERE id_equipement = ?"
            );
            preparedStatement.setLong(1, id_equipement);
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
