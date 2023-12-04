/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Dominio.Cliente;
import Dominio.Habitacion;
import Dominio.Hotel;
import Dominio.Reservacion;
import Persistencia.Interfaces.IReservacionDAO;
import Persistencia.DAO.ReservacionDAO;
import Excepciones.BOException;
import Negocio.HabitacionBO;
import Negocio.ReservacionBO;
import Excepciones.PersistenciaException;
import Persistencia.DAO.HabitacionDAO;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author YeisiPC
 */
public class frmHabitacion extends javax.swing.JFrame {

    private JPanel errorPanel;
    private final HabitacionBO habitacionBO;
    private Hotel hotelSeleccionado;
    private Cliente clienteRegistrado;
    private IReservacionDAO reservacionDAO;
    private ReservacionBO reservacionBO;
    private Reservacion reservacion = new Reservacion();

    /**
     * Creates new form frmHabitacion
     *
     * @param clienteRegistrado
     * @param hotelSeleccionado
     */
    public frmHabitacion(Cliente clienteRegistrado, Hotel hotelSeleccionado) {
        initComponents();
        this.reservacionBO = new ReservacionBO();
        this.reservacionDAO = new ReservacionDAO();
        this.clienteRegistrado = clienteRegistrado;
        this.hotelSeleccionado = hotelSeleccionado;
        habitacionBO = new HabitacionBO();
        this.cargarDatosEnTabla();
    }

    /**
     *
     */
    public void cargarDatosEnTabla() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Numero de Habitacion");
        model.addColumn("Tipo de Habitacion");
        model.addColumn("Tarifa");
        try {
            List<Habitacion> habitaciones = habitacionBO.obtenerHabitacionsSinAsignar(hotelSeleccionado);

            for (Habitacion habitacion : habitaciones) {
                Object[] rowData = new Object[]{
                    habitacion.getNumeroHabitacion(),
                    habitacion.getTipoHabitacion(),
                    habitacion.getTarifa(),
                    habitacion.getHotel() != null ? habitacion.getHotel() : "N/A"
                };
                model.addRow(rowData);
            }

            tablaHabitacion.setModel(model);

        } catch (BOException e) {
            e.printStackTrace();
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
        tablaHabitacion = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        calendarioFechaInicial = new com.github.lgooddatepicker.components.CalendarPanel();
        calendarioFechaFinal = new com.github.lgooddatepicker.components.CalendarPanel();
        btnReservar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnCalcular = new javax.swing.JButton();
        lblDias = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Habitaciones");
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        tablaHabitacion.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaHabitacion);

        jLabel2.setText("Fecha inicial");

        jLabel3.setText("Fecha final");

        btnReservar.setText("Reservar");
        btnReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservarActionPerformed(evt);
            }
        });

        jLabel4.setText("Dias reservados:");

        jLabel5.setText("Precio:");

        btnCalcular.setText("Calcular");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(171, 171, 171))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(btnCalcular))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPrecio)
                                    .addComponent(lblDias))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnReservar)
                    .addComponent(calendarioFechaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(calendarioFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(calendarioFechaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calendarioFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReservar)
                    .addComponent(btnCalcular))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblDias))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblPrecio))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservarActionPerformed
        // TODO add your handling code here:

        try {
            int indiceHabitacion = tablaHabitacion.getSelectedRow();

            if (indiceHabitacion == -1) {
                mostrarError("Selecciona una habitación para reservar.");
                return;
            }

            LocalDate fechaActual = LocalDate.now();
            LocalDate fechaInicial = calendarioFechaInicial.getSelectedDate();
            LocalDate fechaFinal = calendarioFechaFinal.getSelectedDate();

            if (fechaInicial.isBefore(fechaActual) || fechaFinal == null || fechaFinal.isBefore(fechaInicial) || fechaFinal.isEqual(fechaInicial)) {
                mostrarError("La fecha inicial no puede ser anterior a la fecha actual y la fecha final debe ser posterior a la fecha inicial y no puede ser igual.");
                return;
            }

            // Nueva verificación para no permitir reservas días antes de la fecha actual
            if (fechaInicial.isBefore(fechaActual)) {
                mostrarError("No puedes reservar para fechas anteriores a la fecha actual.");
                return;
            }

            // Adding a check for the year to ensure reservations are not made too far in the future
            int maxReservationYear = 5; // You can adjust this value based on your requirements
            if (fechaInicial.getYear() > fechaActual.getYear() + maxReservationYear || fechaFinal.getYear() > fechaActual.getYear() + maxReservationYear) {
                mostrarError("No puedes reservar para fechas demasiado lejanas en el futuro.");
                return;
            }

            String numeroHabitacion = tablaHabitacion.getValueAt(indiceHabitacion, 0).toString();
            Habitacion habitacionSeleccionada = habitacionBO.buscar(Integer.parseInt(numeroHabitacion));
            reservacion.setTarifa(calcularTarifa());
            reservacion.setCategoriaHotel(this.hotelSeleccionado);
            reservacion.setClaseHabitacion(habitacionSeleccionada);
            reservacion.setPeriodoEstancia(obtenerPeriodo());
            reservacion.setCliente(this.clienteRegistrado);

            this.reservacionBO.insertar(reservacion);
            new frmReporteDeReservación(this.reservacion).setVisible(true);
            this.dispose();
        } catch (BOException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnReservarActionPerformed
    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(errorPanel, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        try {
            int indiceHabitacion = tablaHabitacion.getSelectedRow();

            if (indiceHabitacion == -1) {
                mostrarError("Selecciona una habitación antes de calcular la tarifa.");
                return;
            }

            System.out.println("Estoy aqui");
            obtenerPeriodo();
            calcularTarifa();

            // Resto del código
        } catch (Exception e) {
            e.printStackTrace();
        }

//        txtDiasReservados.setText(dias.toString());
//        txtPrecioFinal.setText(String.valueOf(precioFinal));
    }//GEN-LAST:event_btnCalcularActionPerformed

    /**
     * @param args the command line arguments
     */
    public Integer obtenerPeriodo() {
        LocalDate fechaSeleccionadaInicial = calendarioFechaInicial.getSelectedDate();
        LocalDate fechaSeleccionadaFinal = calendarioFechaFinal.getSelectedDate();

        int dia, mes, año;
        dia = fechaSeleccionadaInicial.getDayOfMonth();
        mes = fechaSeleccionadaInicial.getMonthValue();
        año = fechaSeleccionadaInicial.getYear();

        LocalDate diaInicial = LocalDate.of(año, mes, dia);

        LocalDate diaFinal = LocalDate.of(fechaSeleccionadaFinal.getYear(),
                fechaSeleccionadaFinal.getMonthValue(),
                fechaSeleccionadaFinal.getDayOfMonth());

        Period periodo = Period.between(diaInicial, diaFinal);

        lblDias.setText(String.valueOf(periodo.getDays()));
        return periodo.getDays();
    }

    /**
     *
     * @return
     */
    public double calcularTarifa() {
        Integer dias = this.obtenerPeriodo();
        int indiceHabitacion = tablaHabitacion.getSelectedRow();

        double tarifa = Double.parseDouble(tablaHabitacion.getValueAt(indiceHabitacion, 2).toString());

        double precioNeto = tarifa * dias;

        lblPrecio.setText(String.valueOf(precioNeto));
        System.out.println("" + precioNeto + dias);
        return precioNeto;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnReservar;
    private com.github.lgooddatepicker.components.CalendarPanel calendarioFechaFinal;
    private com.github.lgooddatepicker.components.CalendarPanel calendarioFechaInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDias;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JTable tablaHabitacion;
    // End of variables declaration//GEN-END:variables

}
