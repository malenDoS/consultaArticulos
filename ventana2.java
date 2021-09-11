
import javax.swing.JFrame;
public class ventana2 extends JFrame {
    
    public ventana2(){
        setSize(300,500);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Ventana2");
        setLocation(700,900);
        panelesSegundaVentana paneles;
        paneles=new panelesSegundaVentana();
        add(paneles);
        setVisible(true);
    }
}
