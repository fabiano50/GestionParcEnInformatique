package school.hei.GestionParcInformatique.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import school.hei.GestionParcInformatique.connection.DatabaseConfig;
import school.hei.GestionParcInformatique.entity.Departement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public abstract class DepartementJdbcRepository implements DepartementRepository {
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Connection connection;
    @Override
    public Departement getDepartementById(long id_departement) {
        List<Departement> departements = new ArrayList<>();
        try {
            connection = DatabaseConfig.getInstance().getConnection();
            preparedStatement =connection.prepareStatement(
                    "SELECT * FROM departement WHERE id_departement = ?"
            );
            preparedStatement.setLong(1, id_departement);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                departements.add(
                        new Departement(
                                resultSet.getLong("id_departement"),
                                resultSet.getString("nom"),
                                new ArrayList<>()
                        )
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (Departement) departements;
    }

    @Override
    public List<Departement> getAllDepartements() {
        List<Departement> departement = new ArrayList<>();
        try {
            connection = DatabaseConfig.getInstance().getConnection();
            preparedStatement =connection.prepareStatement(
                    "SELECT * FROM departement"
            );
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                departement.add(
                        new Departement(
                                resultSet.getLong("id_departement"),
                                resultSet.getString("nom"),
                                new ArrayList<>()
                        )
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departement;
    }

    @Override
    public boolean createdDepartement(Departement departement) {
        try {
            connection = DatabaseConfig.getInstance().getConnection();
            preparedStatement =connection.prepareStatement(
                    "INSERT INTO departement (id_departement, nom, localisation, type) VALUES (?, ?, ?, ?, ?)"
            );
            preparedStatement.setLong(1, departement.getId_departement());
            preparedStatement.setString(2, departement.getNom());
            preparedStatement.setString(3, departement.getLocalisation());
            preparedStatement.setString(4, departement.getType());

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
    public boolean updateDepartement(long id_departement,Departement departement) {
        try {
            connection = DatabaseConfig.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(
                    "UPDATE departement SET nom = ?, localisation = ?, etat = ?, type = ? WHERE id_equipement = ?"
            );
            preparedStatement.setLong(1, departement.getId_departement());
            preparedStatement.setString(2, departement.getNom());
            preparedStatement.setString(3, departement.getLocalisation());
            preparedStatement.setString(4, departement.getType());
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
    public boolean deleteDepartement(long id_departement) {
        try {
            connection = DatabaseConfig.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(
                    "DELETE FROM departement WHERE id_equipement = ?"
            );
            preparedStatement.setLong(1, id_departement);
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

