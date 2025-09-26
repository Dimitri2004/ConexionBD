
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Metodos {

    public static void main(String[] args){
        ConexionBD conn = new ConexionBD();
        //crearEntrada(conn);
        //borrarEntrada(conn, "Zoro");
        //actualixarEntrada(conn, "Luffy", "Capitan de los sombrero de paja" );
        leerEntrada(conn);
    }
   //crear entrada a base de datos
    public static void crearEntrada(ConexionBD conn){
        String sql = "INSERT INTO anime(nome, descripcion, data, puntuacion) VALUES('Luffy', 'Carniboro y gloton pirata', '2024-01-01', 9.5)";
        try(PreparedStatement pstmt = conn.getConexion().prepareStatement(sql)){
            pstmt.executeUpdate();
            System.out.println("Entrada creada correctamente");

        }catch(Exception e){
            System.out.println("Error al crear entrada: " + e.getMessage());
        }
    }
    //Borra la entrada asignada por nombre
    public static void borrarEntrada(ConexionBD conn, String nome){
        String sql = "DELETE FROM anime WHERE nome = ?";
        try(PreparedStatement pstmt = conn.getConexion().prepareStatement(sql)){
            //borrarlo por nombre
            pstmt.setString(1, nome);
            pstmt.executeUpdate();
            System.out.println("Entrada borrada correctamente");
        }catch(Exception e){
            System.out.println("Error al borrar entrada: " + e.getMessage());
        }
    }
    //Actualiza los datos con la entrada asignad apor nombre
    public static void actualixarEntrada(ConexionBD conn, String nome, String novaDescricion){
        String sql = "UPDATE anime SET descripcion = ? WHERE nome = ?";
        try(PreparedStatement pstmt = conn.getConexion().prepareStatement(sql)){
            pstmt.setString(1, novaDescricion);
            pstmt.setString(2, nome);
            pstmt.executeUpdate();
            System.out.println("Entrada actualizada correctamente");
        }catch(Exception e){
            System.out.println("Error al actualizar entrada: " + e.getMessage());
        }
    }
    //Mustra la consulta dada por nombre
    public static void  leerEntrada(ConexionBD conn){
        String sql="SELECT * FROM anime";
        try (PreparedStatement pstmt= conn.getConexion().prepareStatement(sql)){
            ResultSet nomeres=pstmt.executeQuery();

            while (nomeres.next()){
                String b=nomeres.getString(1);
                String c=nomeres.getString(2);
                Date d=nomeres.getDate(3);
                int e=nomeres.getInt(4);

                System.out.println("Lectura realizada resultado:"+b+" "+c+" "+d+" "+e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
