/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Dominio.AgenciaDeViajes;
import Dominio.Cliente;
import Excepciones.BOException;
import Negocio.ClienteBO;
import Negocio.AgenciaDeViajesBO;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author YeisiPC
 */
public class frmAgenciaDeViajes1 extends javax.swing.JFrame {

    /**
     * Creates new form frmAgenciaDeViajes
     */
    private Cliente cliente;
    private AgenciaDeViajes agencia;
    private AgenciaDeViajesBO agenciaBO;
    private ClienteBO clienteBO;
    private String personaReservacion;

    public frmAgenciaDeViajes1(Cliente cliente) {
        initComponents();
        this.cliente = cliente;
        this.clienteBO = new ClienteBO();
        this.agenciaBO = new AgenciaDeViajesBO();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtPersona = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombre.setBackground(new java.awt.Color(255, 255, 255));
        txtNombre.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(0, 0, 0));
        txtNombre.setBorder(null);
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 305, 28));

        txtDireccion.setBackground(new java.awt.Color(255, 255, 255));
        txtDireccion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(0, 0, 0));
        txtDireccion.setBorder(null);
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 305, 20));

        txtTelefono.setBackground(new java.awt.Color(255, 255, 255));
        txtTelefono.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(0, 0, 0));
        txtTelefono.setBorder(null);
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, 305, 20));

        txtPersona.setBackground(new java.awt.Color(255, 255, 255));
        txtPersona.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtPersona.setForeground(new java.awt.Color(0, 0, 0));
        txtPersona.setBorder(null);
        jPanel1.add(txtPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 305, 28));

        btnRegistrar.setContentAreaFilled(false);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 333, 180, 70));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pantallaRegistrarAgencia.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
/**
     * Realiza la validación de los campos de entrada y registra una nueva
     * agencia de viajes. Muestra mensajes de error en caso de campos inválidos.
     *
     * @param evt Evento de acción al hacer clic en el botón de registrar.
     */
    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        try {
            String nombre = txtNombre.getText();
            String direccion = txtDireccion.getText();
            String telefono = txtTelefono.getText();
            String personaReservacion = txtPersona.getText();

            if (validacionNombre(nombre) != null && validacionNombre(personaReservacion) != null) {
                if (validacionTelefono(telefono) != null) {
                    if (validacionDireccion(direccion) != null) {
                        if (validacionCliente(nombre) == null) {
                            this.cliente.setNombre(validacionNombre(nombre));
                            this.cliente.setDireccion(validacionDireccion(direccion));
                            this.cliente.setTelefono(validacionTelefono(telefono));
                            this.personaReservacion = validacionNombre(personaReservacion);
                            this.cliente = obtenerAgencia(this.cliente, this.personaReservacion);

                            frmHotel1 hotelFrame = new frmHotel1(this.cliente);

                            hotelFrame.setVisible(true);
                            this.dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "La agencia ya existe");
                            this.cliente = validacionCliente(nombre);
                            this.personaReservacion = validacionNombre(personaReservacion);
                            this.cliente = obtenerAgencia(this.cliente, this.personaReservacion);
                            new frmHotel1(this.cliente).setVisible(true);
                            this.dispose();
                        }
                    } else {
                        mostrarError("No campos vacíos", "Error", "Error al registrar");
                    }
                } else {
                    mostrarError("Solo puedes poner números en el teléfono, máximo 16 digitos. No campos vacíos", "Error", "Error al registrar");
                }
            } else {
                mostrarError("Solo puedes poner letras en el nombre. No campos vacíos", "Error", "Error al registrar");
            }

        } catch (BOException e) {
            Logger.getLogger(frmPersona1.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    /**
     * Actualiza la información de la agencia asociada al cliente en la base de
     * datos.
     *
     * @param cliente Cliente asociado a la agencia.
     * @param personaReservacion Nombre de la persona de reservación.
     */
    public void actualizarAgencia(Cliente cliente, String personaReservacion) {
        try {
            AgenciaDeViajes agencia = agenciaBO.buscarPorCliente(cliente.getId());
            agencia.setPersonaReservacion(personaReservacion);
            agenciaBO.actualizar(agencia);
        } catch (BOException e) {
            Logger.getLogger(frmPersona1.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    /**
     *
     * @param registrarAgencia
     * @return
     * @throws BOException
     */
    private Cliente registrarAgencia(Cliente registrarCliente, String personaReservacion) throws BOException {

        try {
            Cliente clienteRegistrado = clienteBO.insertar(registrarCliente);
            this.agencia = new AgenciaDeViajes(clienteRegistrado.getNombre(), clienteRegistrado.getDireccion(), clienteRegistrado.getTelefono(), clienteRegistrado, personaReservacion);
            AgenciaDeViajes agenciaRegistrado = agenciaBO.insertar(this.agencia);
            return clienteRegistrado;
        } catch (BOException e) {
            throw new BOException(e.getMessage(), e);
        }

    }

    /**
     *
     * @param buscarCliente
     * @return
     * @throws BOException
     */
    private Cliente obtenerAgencia(Cliente buscarCliente, String personaReservacion) throws BOException {
        Cliente clienteObtenido;
        try {
            clienteObtenido = registrarAgencia(buscarCliente, personaReservacion);
            clienteObtenido = clienteBO.buscar(clienteObtenido.getId());

            return clienteObtenido;
        } catch (BOException e) {
            throw new BOException(e.getMessage(), e);
        }

    }

    /**
     * Realiza la validación del Cliente, buscándolo en la base de datos por su
     * nombre.
     *
     * @param nombre Nombre del Cliente a validar.
     * @return Cliente si existe, o null si no se encuentra.
     * @throws BOException Excepción de lógica de negocio.
     */
    public Cliente validacionCliente(String nombre) throws BOException {

        try {
            Cliente cliente = this.clienteBO.buscar(nombre);
            if (cliente != null) {
                return cliente;
            }

        } catch (BOException e) {
            throw new BOException(e.getMessage(), e);
        }

        return null;
    }

    /**
     * Realiza la validación del nombre, eliminando espacios en blanco
     * innecesarios, permitiendo solo letras y algunos caracteres especiales.
     *
     * @param nombre Nombre a validar.
     * @return Nombre válido sin espacios innecesarios o null si es inválido.
     */
    private String validacionNombre(String nombre) {

        String nombreSinEspacios = nombre.trim();

        // Reemplazar múltiples espacios en el medio por un solo espacio
        nombreSinEspacios = nombreSinEspacios.replaceAll("\\s+", " ");

        Pattern patronSoloLetras = Pattern.compile("^[a-zA-Z\\s'-]+$");
        Matcher matcher = patronSoloLetras.matcher(nombreSinEspacios);

        if (!nombreSinEspacios.isEmpty() && matcher.matches()) {
            return nombreSinEspacios;
        } else {
            return null;
        }

    }

    /**
     * Realiza la validación de la dirección, eliminando espacios en blanco
     * innecesarios.
     *
     * @param direccion Dirección a validar.
     * @return Dirección válida sin espacios innecesarios o null si es inválida.
     */
    private String validacionDireccion(String direccion) {
        String direccionSinEspacios = direccion.trim();

        // Reemplazar múltiples espacios en el medio por un solo espacio
        direccionSinEspacios = direccionSinEspacios.replaceAll("\\s+", " ");

        if (!direccionSinEspacios.isEmpty()) {
            return direccionSinEspacios;
        } else {
            return null;
        }
    }

    /**
     * Realiza la validación del número de teléfono, permitiendo solo números y
     * eliminando espacios.
     *
     * @param telefono Número de teléfono a validar.
     * @return Número de teléfono válido sin espacios o null si es inválido.
     */
    private String validacionTelefono(String telefono) {

        String telefonoSinEspacios = telefono.replaceAll("\\s", "");

        // Modificar el patrón para permitir solo números
        Pattern patronSoloNumeros = Pattern.compile("^[0-9]+$");
        Matcher matcher = patronSoloNumeros.matcher(telefonoSinEspacios);

        if (!telefonoSinEspacios.isEmpty() && matcher.matches()) {
            return telefonoSinEspacios;
        } else {
            return null;
        }

    }

    /**
     * Muestra un cuadro de diálogo con un mensaje de error o información.
     *
     * @param mensaje Mensaje a mostrar.
     * @param tipo Tipo de mensaje ("Error" o "Info").
     * @param titulo Título del cuadro de diálogo.
     */
    public void mostrarError(String mensaje, String tipo, String titulo) {
        JOptionPane optionPane = new JOptionPane(mensaje);
        if (tipo.equals("Info")) {
            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        } else if (tipo.equals("Error")) {
            optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
        }
        JDialog dialog = optionPane.createDialog(titulo);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPersona;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
