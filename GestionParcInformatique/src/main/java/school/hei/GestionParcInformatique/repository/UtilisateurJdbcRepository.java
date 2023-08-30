package school.hei.GestionParcInformatique.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import school.hei.GestionParcInformatique.connection.DatabaseConfig;
import school.hei.GestionParcInformatique.entity.Utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public abstract class UtilisateurJdbcRepository implements UtilisateurRepository {
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Connection connection;

    @Override
    public Utilisateur getUtilisateurById(long id_utilisateur) {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        try {
            connection = DatabaseConfig.getInstance().getConnection();
            preparedStatement =connection.prepareStatement(
                    "SELECT * FROM utilisateur WHERE id_utilisateur = ?"
            );
            preparedStatement.setLong(1, id_utilisateur);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                utilisateurs.add(
                        new Utilisateur(
                                resultSet.getLong("id_utilisateur"),
                                resultSet.getString("nom"),
                                new ArrayList<>(),
                                new ArrayList<>()
                        )
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (Utilisateur) utilisateurs;
    }

    @Override
    public List<Utilisateur> getAllUtilisateurs() {
        List<Utilisateur> utilisateur = new ArrayList<>();
        try {
            connection = DatabaseConfig.getInstance().getConnection();
            preparedStatement =connection.prepareStatement(
                    "SELECT * FROM utilisateur"
            );
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                utilisateur.add(
                        new Utilisateur(
                                resultSet.getLong("id_utilisateur"),
                                resultSet.getString("nom"),
                                new ArrayList<>()
                        )
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateur;
    }

    @Override
    public boolean createdUtilisateur(Utilisateur utilisateur) {
        try {
            connection = DatabaseConfig.getInstance().getConnection();
            preparedStatement =connection.prepareStatement(
                    "INSERT INTO utilisateur (nom)" +"VALUES (?)"
            );
            preparedStatement.setString(1, utilisateur.getNom());
            int success = preparedStatement.executeUpdate();
            if(success == 1) {
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
    public boolean updateUtilisateur(long id_utilisateur, Utilisateur utilisateur) {
        try {
            connection = DatabaseConfig.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(
                    "UPDATE utilisateur SET nom = ? WHERE id_utilisateur = ?"
            );
            preparedStatement.setString(1, utilisateur.getNom());
            preparedStatement.setLong(2, id_utilisateur);
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
    public boolean deleteUtilisateur(long id_utilisateur) {
        try {
            connection = DatabaseConfig.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(
                    "DELETE FROM utilisateur WHERE id_utilisateur = ?"
            );
            preparedStatement.setLong(1, id_utilisateur);
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
