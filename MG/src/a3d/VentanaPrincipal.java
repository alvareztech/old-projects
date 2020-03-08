package a3d;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

public class VentanaPrincipal extends JFrame {

    private int codigo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    // JDialog
    private Login login;
    private FormRegistrarCliente frmRegistrarCliente;
    private FormNuevoEmpleado frmNuevoEmpleado;
    private FormNuevoServicio frmNuevoServicio;
    // JPanel
    private PanelBienvenida pnlBienvenida;
    private PanelOpciones pnlOpciones;
    private PanelInformacion pnlInformacion;
    private JPanel pnlCentro;
    private PanelMaterialesRegistrados pnlMaterialesRegistrados;
    private PanelSolicitarMaterial pnlSolicitarMaterial;
    //---
    private PanelClientes pnlClientes;
    private PanelEmpleados pnlEmpleados;
    private PanelServicios pnlServicios;
    private PanelMaterialesSolicitados pnlMaterialesSolicitados;
    private PanelAdministrarServicios pnlAdministrarServicios;
    private PanelNuevoPedido pnlNuevoPedido;

    public VentanaPrincipal(int cod){
        codigo = cod;
        setTitle("MGames");

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();
        int x = 800, y = 600;
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((pantalla.width - x) / 2, (pantalla.height - y) / 2, x, y);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //setLayout(new BorderLayout());
        //setResizable(false);
        //getContentPane().setBackground(Color.DARK_GRAY);
        setVisible(true);

    }

    private void initComponents() {


        //---
        pnlInformacion = new PanelInformacion();
        pnlOpciones = new PanelOpciones(this, codigo);
        pnlCentro = new JPanel(new CardLayout());
        //---
        pnlBienvenida = new PanelBienvenida(new MGamesDB().getNombreEmpleado(codigo), new MGamesDB().getCargoEmpleado(codigo));
        pnlClientes = new PanelClientes(this);
        pnlEmpleados = new PanelEmpleados(this);
        pnlMaterialesRegistrados = new PanelMaterialesRegistrados();
        pnlServicios = new PanelServicios(this);
        pnlMaterialesSolicitados = new PanelMaterialesSolicitados();
        pnlAdministrarServicios = new PanelAdministrarServicios();
        pnlNuevoPedido = new PanelNuevoPedido();
        pnlSolicitarMaterial = new PanelSolicitarMaterial();
        //---
        pnlCentro.add(pnlBienvenida, "pnlBienvenida");
        pnlCentro.add(pnlClientes, "pnlClientes");
        pnlCentro.add(pnlEmpleados, "pnlEmpleados");
        pnlCentro.add(pnlMaterialesRegistrados, "pnlMaterialesRegistrados");
        pnlCentro.add(pnlServicios, "pnlServicios");
        pnlCentro.add(pnlMaterialesSolicitados, "pnlMaterialesSolicitados");
        pnlCentro.add(pnlAdministrarServicios, "pnlAdministrarServicios");
        pnlCentro.add(pnlNuevoPedido, "pnlNuevoPedido");
        pnlCentro.add(pnlSolicitarMaterial, "pnlSolicitarMaterial");

        add(pnlInformacion, BorderLayout.NORTH);
        add(pnlOpciones, BorderLayout.WEST);
        add(pnlCentro, BorderLayout.CENTER);

    }

    public void mostrarRegistrarCliente() {
        frmRegistrarCliente = new FormRegistrarCliente(this, true);
        frmRegistrarCliente.setVisible(true);
    }

    public void mostrarVerEmpleados() {
        pnlEmpleados.actualizarTablaEmpleados();
        CardLayout cl = (CardLayout) (pnlCentro.getLayout());
        cl.show(pnlCentro, "pnlEmpleados");
    }

    public void mostrarVerClientes() {

        pnlClientes.actualizarTablaClientes();
        CardLayout cl = (CardLayout) (pnlCentro.getLayout());
        cl.show(pnlCentro, "pnlClientes");
    }

    public void mostrarSolicitarMaterial() {
        CardLayout cl = (CardLayout) (pnlCentro.getLayout());
        cl.show(pnlCentro, "pnlSolicitarMaterial");
    }

    public void mostrarVerMaterialesRegistrados() {
        CardLayout cl = (CardLayout) (pnlCentro.getLayout());
        cl.show(pnlCentro, "pnlMaterialesRegistrados");
    }

    void mostrarRegistrarEmpleado() {
        frmNuevoEmpleado = new FormNuevoEmpleado(this, true);
        frmNuevoEmpleado.setLocationRelativeTo(this);
        frmNuevoEmpleado.setVisible(true);
    }

    void mostrarVerServicios() {
        pnlServicios.actualizarTablaServicios();
        CardLayout cl = (CardLayout) (pnlCentro.getLayout());
        cl.show(pnlCentro, "pnlServicios");
    }

    void mostrarRegistrarServicio() {
        frmNuevoServicio = new FormNuevoServicio(this, true);
        frmNuevoServicio.setLocationRelativeTo(this);
        frmNuevoServicio.setVisible(true);
    }

    void mostrarVerSolicitudesDeMaterial() {
        //pnlClientes.actualizarTablaClientes();
        CardLayout cl = (CardLayout) (pnlCentro.getLayout());
        cl.show(pnlCentro, "pnlMaterialesSolicitados");
    }

    void mostrarAdministrarServicios() {
        CardLayout cl = (CardLayout) (pnlCentro.getLayout());
        cl.show(pnlCentro, "pnlAdministrarServicios");
    }

    void verRegistrarCliente() {
        frmRegistrarCliente = new FormRegistrarCliente(this, true);
        frmRegistrarCliente.setLocationRelativeTo(this);
        frmRegistrarCliente.setVisible(true);
    }

    void actualizarTablaClientes() {
        pnlClientes.actualizarTablaClientes();
    }

    void actualizarTablaEmpleados() {
        pnlEmpleados.actualizarTablaEmpleados();
    }

    void actualizarBienvenida(String x, String y)
    {
        pnlBienvenida.setVisible(false);
        pnlBienvenida = new PanelBienvenida(x, y);
        pnlBienvenida.setVisible(true);
    }

    void mostrarRelizarPedido() {
        CardLayout cl = (CardLayout) (pnlCentro.getLayout());
        cl.show(pnlCentro, "pnlNuevoPedido");
    }



//    private void modificarUsuario(String u, String c) {
//        usuario = u;
//        cargo = c;
//    }
}
