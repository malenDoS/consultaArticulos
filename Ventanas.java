
import javax.swing.JFrame;


public class Ventanas extends JFrame {
    
    public Ventanas(){
        setTitle("información artículos");
        setSize(700,950);
        setResizable(true);
        setLocation(200,50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Paneles panelPrograma=new Paneles();
        add(panelPrograma);
        setVisible(true);
    }
}

