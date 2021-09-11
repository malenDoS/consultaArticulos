
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class escribirDatos {
    
    public void escribirDatos(ArrayList<String>peliculas) throws IOException{
        BufferedWriter bw=new BufferedWriter(new FileWriter("C:\\Users\\malen\\Desktop\\Carpetes\\Informática\\JAVA\\informacionArticulos1\\texto\\datosArticulos.txt",true));
        bw.newLine();
        bw.write("*************Datos del artículo***************");
        bw.newLine();
        int contador=1;
        for(int i=0;i<peliculas.size();i++){
            if(contador==1){
        bw.write("Nombre del artículo: "+peliculas.get(i));
        bw.newLine();
            }else if(contador==2){
        bw.write("País de origen del artículo: "+peliculas.get(i));
        bw.newLine();
            }else if(contador==3){
        bw.write("Precio del artículo: "+peliculas.get(i));
        bw.newLine();
            }else{
        bw.write("Sección del artículo: "+peliculas.get(i));
        bw.newLine();
            }
            contador++;
        }
        bw.close();
    }
}
