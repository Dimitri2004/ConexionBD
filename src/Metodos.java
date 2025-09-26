

public class Metodos {
    public static void main(String[] args) {
        ConexionBD.conexion();
        insertar(ConexionBD.conexion());

    }
    public static void insertar(java.sql.Connection conn){
        //Insertar datos en la tabla de base de datos
        try {
            String sql = "INSERT INTO anime (nome) VALUES ('Pokemon')";
            conn.createStatement().executeUpdate(sql);
            System.out.println("Datos insertados correctamente.");
        } catch (Exception e) {
            System.out.println("Error al insertar datos: " + e.getMessage());
            e.printStackTrace();
        }
    }




}
