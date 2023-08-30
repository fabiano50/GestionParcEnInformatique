package school.hei.GestionParcInformatique.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    private static DatabaseConfig instance;

    private Connection connection;

    public Connection getConnection() throws SQLException {
        if(connection == null || connection.isClosed()) {
            try {
                connection = DriverManager.getConnection(
                     Config.URL,
                     Config.USERNAME,
                     Config.PASSWORD
                );
            } catch (SQLException e) {
                throw new RuntimeException("Failed to initialize database connection.", e);
            }
        }
        return connection;
    }

    public static DatabaseConfig getInstance(){
        if(instance == null){
            instance = new DatabaseConfig();
        }
        return instance;
    }
}
