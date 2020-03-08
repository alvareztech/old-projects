package a3d;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 * Clase VentanaPrincipal
 * @author Daniel Alvarez (a3dany)
 */
public class VentanaPrincipal extends JFrame implements ActionListener {

    private JList lista;
    private DefaultListModel modeloLista;
    private JButton botonAdicionar;
    private JButton botonEliminar;
    private VentanaSecundaria ventanaAmigos;

    public VentanaPrincipal() {
        super();
        configurarVentana();
        inicializarComponentes();
    }

    private void configurarVentana() {
        this.setTitle("Mis Amigos");                   // colocamos titulo a la ventana
        this.setSize(400, 400);                                 // colocamos tamanio a la ventana (ancho, alto)
        this.setLocationRelativeTo(null);                       // centramos la ventana en la pantalla
        this.setLayout(null);                                   // no usamos ningun layout, solo asi podremos dar posiciones a los componentes
        this.setResizable(false);                               // hacemos que la ventana no sea redimiensionable
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // hacemos que cuando se cierre la ventana termina todo proceso
    }

    private void inicializarComponentes() {
        modeloLista = new DefaultListModel();
        lista = new JList(modeloLista);

        JScrollPane listScrollPane = new JScrollPane(lista);
        listScrollPane.setBounds(20, 20, 350, 300);


        botonAdicionar = new JButton();
        botonAdicionar.setText("Adicionar Amigo");
        botonAdicionar.setBounds(20, 330, 170, 30);
        botonAdicionar.addActionListener(this);

        botonEliminar = new JButton();
        botonEliminar.setText("Eliminar Amigo");
        botonEliminar.setBounds(200, 330, 170, 30);
        botonEliminar.addActionListener(this);

        add(botonAdicionar);
        add(botonEliminar);
        add(listScrollPane);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonAdicionar) {
            ventanaAmigos = new VentanaSecundaria(this, true);
            ventanaAmigos.setVisible(true);
        }
        if (e.getSource() == botonEliminar) {
            eliminarAmigo();
        }

    }

    public void adicionarAmigo(Amigo A) {
        modeloLista.addElement(A.getInformacion());
    }

    public void eliminarAmigo() {
        int i = lista.getSelectedIndex();
        modeloLista.remove(i);
    }
}
