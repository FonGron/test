package jm.task.core.jdbc.util;

import com.mysql.cj.xdevapi.SessionFactory;
import jm.task.core.jdbc.model.User;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/datauser";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "KAPriz148";
    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            System.out.println("CONNECTION OK");
        } catch (SQLException e) {
            System.out.println("NOT CONNECTION");
            throw new RuntimeException(e);

        }
        return connection;
    }
    public static void disconnected() {

        if(connection!=null){
            try {
                System.out.println("Disconnected OK");
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
