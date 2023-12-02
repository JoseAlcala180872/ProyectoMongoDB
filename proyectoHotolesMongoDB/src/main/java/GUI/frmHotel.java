/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Dominio.Hotel;
import Excepciones.BOException;
import Negocio.HotelBO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author YeisiPC
 */
public class frmHotel extends javax.swing.JFrame {

    private final HotelBO hotelBO;

    /**
     * Creates new form frmHotel
     */
    public frmHotel() {

        initComponents();
        hotelBO = new HotelBO(); // Initialize HotelBO
        cargarDatosEnTabla();
    }

    /**
     * 
     */
    private void cargarDatosEnTabla() {
        try {
            // Llamar al método para obtener todos los hoteles
            List<Hotel> hoteles = hotelBO.obtenerTodosLosHoteles();

            // Crear un DefaultTableModel con nombres de columnas
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Nombre");
            model.addColumn("Dirección");
            model.addColumn("Teléfono");
            model.addColumn("Año Construcción");
            model.addColumn("Categoría");

            // Añadir datos al modelo de tabla
            for (Hotel hotel : hoteles) {
                Object[] rowData = new Object[]{
                    hotel.getNombre(),
                    hotel.getDireccion(),
                    hotel.getTelefono(),
                    hotel.getAñoConstruccion(),
                    // Comprueba si Categoria es nula antes de acceder a sus métodos
                    hotel.getCategoria() != null ? hotel.getCategoria().getEstrellas() : "N/A"
                };
                model.addRow(rowData);
            }

            // Establecer el modelo de tabla a la jTableHoteles
            tablaHoteles.setModel(model);
            
        } catch (BOException ex) {
            Logger.getLogger(frmHotel.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaHoteles = new javax.swing.JTable();
        btnSeleccionarHotel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Hoteles");

        tablaHoteles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaHoteles);
        if (tablaHoteles.getColumnModel().getColumnCount() > 0) {
            tablaHoteles.getColumnModel().getColumn(0).setHeaderValue("Title 1");
            tablaHoteles.getColumnModel().getColumn(1).setHeaderValue("Title 2");
            tablaHoteles.getColumnModel().getColumn(2).setHeaderValue("Title 3");
            tablaHoteles.getColumnModel().getColumn(3).setHeaderValue("Title 4");
        }

        btnSeleccionarHotel.setText("Seleccionar");
        btnSeleccionarHotel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarHotelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addComponent(jLabel1)
                .addContainerGap(213, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSeleccionarHotel)
                        .addGap(187, 187, 187))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(btnSeleccionarHotel)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarHotelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarHotelActionPerformed
        // TODO add your handling code here:
        int indiceHotel = tablaHoteles.getSelectedRow();
        
        String nombre = tablaHoteles.getValueAt(indiceHotel, 0).toString();
        
        try{
           Hotel hotelSeleccionado =  hotelBO.buscar(nombre);
           new frmHabitacion(hotelSeleccionado).setVisible(true);
           this.dispose();
        }catch (BOException e){
            e.getStackTrace();
        }
        
    }//GEN-LAST:event_btnSeleccionarHotelActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmHotel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSeleccionarHotel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaHoteles;
    // End of variables declaration//GEN-END:variables
}
