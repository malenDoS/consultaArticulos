
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class InsercionBaseDatos {
    
    private static String url="jdbc:mysql://localhost:3306/articulos";
    private static String user="root";
    private static String contrasegna="nloeig31416";
    private ArrayList<String> peliculas;

    
   public ArrayList<String> consultaInformacion(String nombreP) throws SQLException{
       peliculas=new ArrayList<String>();
       Connection conexion=DriverManager.getConnection(url, user,contrasegna);
       Statement miStatement=conexion.createStatement();
       String query="SELECT * FROM articulosexportado WHERE nombreArticulo='"+nombreP+"'";
       ResultSet resultado=miStatement.executeQuery(query);
       while(resultado.next()){
           peliculas.add(resultado.getString("nombreArticulo"));
           peliculas.add(resultado.getString("PaisDeOrigen"));
           peliculas.add(resultado.getString("PRECIO"));
           peliculas.add(resultado.getString("SECCION"));
       }
       if(peliculas.size()==0){
           peliculas.add("Artículo no existente");
           return peliculas;
       }else{
       return peliculas;
       }
   }
}
