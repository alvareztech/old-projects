package a3d;

import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;

public class PanelOpciones extends javax.swing.JPanel {

    private JButton btnAdministrarServicios;
    private JButton btnRegistrarCliente;
    private JButton btnSolicitarMaterial;
    private JButton btnVerClientes;
    private JButton btnVerEmpleados;
    private JButton btnVerMaterialesRegistrados;
    private JButton btnVerServicios;
    private JButton btnVerSolicitudesDeMaterial;
    private JButton btnMaterialesAComprar;

    private JButton btnRealizarPedido;

    private VentanaPrincipal nucleo;
    private int codigo;
    private FormRegistrarCliente frmRegistrarCliente;

    public PanelOpciones(VentanaPrincipal f, int cod) {
        nucleo = f;
        codigo = cod;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        initComponents();
    }

    private void initComponents() {

        btnRegistrarCliente = new JButton("Registrar Cliente");
        btnVerEmpleados = new JButton("Ver Empleados");
        btnVerClientes = new JButton("Ver Clientes");
        btnSolicitarMaterial = new JButton("Solicitar Material");
        btnVerMaterialesRegistrados = new JButton("Ver Materiales Registrados");
        btnVerSolicitudesDeMaterial = new JButton("Ver Material Solicitado");
        btnMaterialesAComprar = new JButton("Materiales a comprar");
        btnVerServicios = new javax.swing.JButton("Ver Servicios");
        btnAdministrarServicios = new javax.swing.JButton("Administrar Servicios");

        btnRealizarPedido = new JButton("Realizar Pedido");

btnRealizarPedido.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarPedidoActionPerformed(evt);
            }

            private void btnRealizarPedidoActionPerformed(ActionEvent evt) {
                nucleo.mostrarRelizarPedido();
            }
        });


        btnRegistrarCliente.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarClienteActionPerformed(evt);
            }
        });
        btnVerEmpleados.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerEmpleadosActionPerformed(evt);
            }
        });
        btnVerClientes.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerClientesActionPerformed(evt);
            }
        });
        btnSolicitarMaterial.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitarMaterialActionPerformed(evt);
            }
        });
        btnVerMaterialesRegistrados.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerMaterialesRegistradosActionPerformed(evt);
            }
        });
        btnVerSolicitudesDeMaterial.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerSolicitudesDeMaterialActionPerformed(evt);
            }
        });

        btnMaterialesAComprar.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaterialesAComprarActionPerformed(evt);
            }
        });
        btnVerServicios.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerServiciosActionPerformed(evt);
            }
        });

        btnAdministrarServicios.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministrarServiciosActionPerformed(evt);
            }
        });

        MGamesDB DB = new MGamesDB();
        String c = DB.getCargoEmpleado(codigo);

//Administrador de Servicios
//Encargado de Ventas
//Limpieza y Mantenimiento
//Encargado Inventarios
//Encargado Control de Personal
        
        if (c.equals("Administrador de Servicios")) {
            add(btnAdministrarServicios);
            add(btnVerServicios);
            add(btnVerClientes);
            add(btnSolicitarMaterial);

        }
        if (c.equals("Encargado de Ventas")) {
            add(btnRealizarPedido);
            add(btnVerClientes);
            add(btnSolicitarMaterial);
        }
        if (c.equals("Limpieza y Mantenimiento")) {
            
        }
        if (c.equals("Encargado Inventarios")) {
            add(btnVerMaterialesRegistrados);
            add(btnVerSolicitudesDeMaterial);
            add(btnMaterialesAComprar);
            add(btnSolicitarMaterial);
        }
        if (c.equals("Encargado Control de Personal")) {
            add(btnVerEmpleados);
            add(btnSolicitarMaterial);
        }
        if (c.equals("Administrador")) {
            add(btnVerClientes);
            add(btnAdministrarServicios);
            add(btnVerMaterialesRegistrados);
            add(btnVerSolicitudesDeMaterial);
            add(btnMaterialesAComprar);
            add(btnSolicitarMaterial);
            add(btnRealizarPedido);
            add(btnVerEmpleados);
        }
    }

    private void btnMaterialesAComprarActionPerformed(ActionEvent evt) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void btnRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {
        nucleo.mostrarRegistrarCliente();
    }

    private void btnVerEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {
        nucleo.mostrarVerEmpleados();
    }

    private void btnVerClientesActionPerformed(java.awt.event.ActionEvent evt) {
        nucleo.mostrarVerClientes();
    }

    private void btnSolicitarMaterialActionPerformed(java.awt.event.ActionEvent evt) {
        nucleo.mostrarSolicitarMaterial();
    }

    private void btnVerMaterialesRegistradosActionPerformed(java.awt.event.ActionEvent evt) {
        nucleo.mostrarVerMaterialesRegistrados();
    }

    private void btnVerServiciosActionPerformed(java.awt.event.ActionEvent evt) {
        nucleo.mostrarVerServicios();
    }

    private void btnVerSolicitudesDeMaterialActionPerformed(java.awt.event.ActionEvent evt) {
        nucleo.mostrarVerSolicitudesDeMaterial();
    }

    private void btnAdministrarServiciosActionPerformed(java.awt.event.ActionEvent evt) {
        nucleo.mostrarAdministrarServicios();
    }
}
