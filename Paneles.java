
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import static java.awt.Font.BOLD;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.font.TextAttribute.FONT;
import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Paneles extends JPanel{
    private JTextField nombreArticulo;
    private JTextField seccion;
    private JButton boton;
    private JButton escribirDatos;
    private JTextArea resultadoArticulo;
    private JMenuBar menu;
    private JMenu menuSuperior;
    private JMenuItem consultarInformacion;
    private JMenuItem escribir;
    private JMenuItem simuladorCompra;
   
    
    public Paneles(){
        setLayout(new BorderLayout());
        add(panel1(),BorderLayout.NORTH);
        add(panelBoton(),BorderLayout.SOUTH);
        add(panelInformacion(),BorderLayout.WEST);
        
    }
    
    public JPanel panel1(){
        JPanel panelTexto=new JPanel();
        panelTexto.setLayout(new GridLayout(2,1));
        nombreArticulo=new JTextField("nombreArticulo");
        nombreArticulo.setPreferredSize(new Dimension(50,40));
        Font fuenteTexto=new Font("arial",Font.BOLD,25);
        nombreArticulo.setFont(fuenteTexto);
        panelTexto.add(panelMenu());
        panelTexto.add(nombreArticulo);
        return panelTexto;
    }
    
    public JPanel panelBoton(){
        JPanel panelBoton=new JPanel();
        panelBoton.setLayout(new GridLayout(1,2));
        boton=new JButton("Buscar");
        boton.setPreferredSize(new Dimension(100,50));
        Font fuenteTextoBoton=new Font("Serif",Font.BOLD,30);
        AccionBoton botonBuscarEscribir;
        botonBuscarEscribir=new AccionBoton();
        boton.setFont(fuenteTextoBoton);
        boton.addActionListener(botonBuscarEscribir);
        escribirDatos=new JButton("Escribir Datos");
        escribirDatos.setFont(fuenteTextoBoton);
        escribirDatos.addActionListener(botonBuscarEscribir);
        panelBoton.add(escribirDatos);
        panelBoton.add(boton);
        return panelBoton;
    }
    
    public JPanel panelInformacion(){
        JPanel panelInformacion;
        panelInformacion=new JPanel();
        panelInformacion.setLayout(new CardLayout());
        resultadoArticulo=new JTextArea(10,15);
        resultadoArticulo.setBackground(Color.DARK_GRAY);
        add(resultadoArticulo);
        return panelInformacion;
    }
    //Panel para el menú
    public JMenuBar panelMenu(){
        JPanel panelMenu=new JPanel();
        AccionBoton accionMenu;
        accionMenu=new AccionBoton();
        menuSuperior=new JMenu("Menú");
        consultarInformacion=new JMenuItem("Consulta información");
        consultarInformacion.addActionListener(accionMenu);
        escribir=new JMenuItem("Escribir información");
        escribir.addActionListener(accionMenu);
        simuladorCompra=new JMenuItem("Simulador compra");
        accionVentana accionSimulador;
        accionSimulador=new accionVentana();
        simuladorCompra.addActionListener(accionSimulador);
        menuSuperior.add(simuladorCompra);
        menuSuperior.add(consultarInformacion);
        menuSuperior.add(escribir);
        menu=new JMenuBar();
        menu.add(menuSuperior);
        return menu;
        
    }
    
    class AccionBoton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            resultadoArticulo.setText("");
            if(nombreArticulo.getText()!=""){
                
                InsercionBaseDatos consulta;
                consulta=new InsercionBaseDatos();
                ArrayList<String>articulos;
                articulos=new ArrayList<String>();
                try {
                    articulos.addAll(consulta.consultaInformacion(nombreArticulo.getText()));
                    if(e.getSource()==boton||e.getSource()==consultarInformacion){
                    for(int i=0;i<articulos.size();i++){
                        Font fuenteArticulos=new Font("arial",BOLD,25);
                        resultadoArticulo.setFont(fuenteArticulos);
                        resultadoArticulo.setForeground(Color.cyan);
                        resultadoArticulo.append(articulos.get(i));
                        resultadoArticulo.append(" |");
                        resultadoArticulo.append(" ");
                    }
                    }else if(e.getSource()==escribirDatos||e.getSource()==escribir){
                        escribirDatos textoTxt;
                        textoTxt=new escribirDatos();
                        textoTxt.escribirDatos(articulos);
                        Font fuenteEscritura=new Font("arial",BOLD,25);
                        resultadoArticulo.setForeground(Color.cyan);
                        resultadoArticulo.setFont(fuenteEscritura);
                        resultadoArticulo.setText("Información escrita correctamente");
                        }
                } catch (SQLException ex) {
                    Logger.getLogger(Paneles.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Paneles.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
    
    class accionVentana implements ActionListener{

        
        @Override
        public void actionPerformed(ActionEvent e) {
           ventana2 ventanaCompras=new ventana2();
        }
        
    }
}

