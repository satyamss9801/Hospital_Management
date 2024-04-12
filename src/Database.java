import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    public Statement sm;
    Connection con;

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/Hospital_data";
    private static final String USER = "root";
    private static final String PASSWORD = "satyam";

    public Database() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            sm = con.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
