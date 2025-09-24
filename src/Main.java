import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://10.0.2.15:5432/probas"; // Reemplaza con tu URL
        String usuario = "postgres";                           // Reemplaza con tu usuario
        String contrasinal = "admin";                   // Reemplaza con tu contraseña

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, usuario, contrasinal);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos:");
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Conexión cerrada.");
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexión:");
                    e.printStackTrace();
                }
            }
        }


        }
    }