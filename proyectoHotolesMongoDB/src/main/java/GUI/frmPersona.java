/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import Dominio.Cliente;
import Dominio.Persona;
import Excepciones.BOException;
import Negocio.ClienteBO;
import Negocio.PersonaBO;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
/**
 *
 * @author YeisiPC
 */
public class frmPersona extends javax.swing.JFrame {

    private Cliente cliente;
    private Persona persona;
    private ClienteBO clienteBO;
    private PersonaBO personaBO;
    /**
     * Creates new form frmPersona
     */
    public frmPersona(Cliente cliente) {
        initComponents();
        this.clienteBO = new ClienteBO();
        this.personaBO = new PersonaBO();
        this.cliente = cliente;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        btnRegistar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Personas");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Dirección:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Teléfono:");

        txtNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txtDireccion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txtTelefono.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        btnRegistar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRegistar.setIcon(new javax.swing.ImageIcon("C:\\Users\\YeisiPC\\Documents\\GitHub\\ProyectoHotelesMongoDB\\toolbar\\Disc_Drive.png")); // NOI18N
        btnRegistar.setText("Registrar");
        btnRegistar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombre))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jLabel1)
                        .addGap(0, 154, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDireccion)
                            .addComponent(txtTelefono))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(btnRegistar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(btnRegistar)
                .addGap(32, 32, 32))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistarActionPerformed
        // TODO add your handling code here:
        try{
            String nombre = txtNombre.getText();
            String direccion = txtDireccion.getText();
            String telefono = txtTelefono.getText();
            
            if(validacionNombre(nombre)){
                if(validacionTelefono(telefono)){
                    
                    this.cliente.setNombre(nombre);
                    this.cliente.setDireccion(direccion);
                    this.cliente.setTelefono(telefono);

                    this.cliente = obtenerPersona(this.cliente);

                    frmHotel hotelFrame = new frmHotel(this.cliente);

                    hotelFrame.setVisible(true);
                    this.dispose();
                }else{
                    mostrarError("Solo puedes poner números en el teléfono, máximo 16 digitos", "Error", "Error al registrar");
                }
                
            }else{
                mostrarError("Solo puedes poner letras en el nombre", "Error", "Error al registrar");
            }
            
        }catch (BOException e){
            Logger.getLogger(frmPersona.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }//GEN-LAST:event_btnRegistarActionPerformed

    /**
     * 
     * @param registrarCliente
     * @throws BOException 
     */
    private Cliente registrarPersona(Cliente registrarCliente) throws BOException{
        
        try{
            Cliente clienteRegistrado = clienteBO.insertar(registrarCliente);
            this.persona = new Persona(clienteRegistrado.getNombre(), clienteRegistrado.getDireccion(), clienteRegistrado.getTelefono(), clienteRegistrado);
            Persona personaRegistrado = personaBO.insertar(this.persona);
            return clienteRegistrado;
        }catch(BOException e){
            throw new BOException(e.getMessage(), e);
        }
        
        
    }
    
    /**
     * 
     * @param buscarCliente
     * @return
     * @throws BOException 
     */
    private Cliente obtenerPersona(Cliente buscarCliente) throws BOException{
        Cliente clienteObtenido;
        try{
            clienteObtenido = registrarPersona(buscarCliente);
            clienteObtenido = clienteBO.buscar(clienteObtenido.getId());
            
            return clienteObtenido;
        }catch(BOException e){
            throw new BOException(e.getMessage(), e);
        }
        
     
    }
    
    /**
     * 
     * @param nombre
     * @return 
     */
    private boolean validacionNombre(String nombre) {
        
        String nombreSinEspacios = nombre.trim();
        
        // Reemplazar múltiples espacios en el medio por un solo espacio
        nombreSinEspacios = nombreSinEspacios.replaceAll("\\s+", " ");

        
        Pattern patronSoloLetras = Pattern.compile("^[a-zA-Z]+$");
        Matcher matcher = patronSoloLetras.matcher(nombreSinEspacios);
        
        return !nombreSinEspacios.isEmpty() && matcher.matches();
        
    }
    
    /**
     * 
     * @param telefono
     * @return 
     */
    private boolean validacionTelefono(String telefono){
        
        Pattern patronSoloNumeros = Pattern.compile("/^[0-9]+$/");
        Matcher matcher = patronSoloNumeros.matcher(telefono);
        
        return matcher.matches();
     
    }
    
    /**
     * 
     * @param mensaje
     * @param tipo
     * @param titulo 
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

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(frmPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(frmPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(frmPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(frmPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new frmPersona().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
