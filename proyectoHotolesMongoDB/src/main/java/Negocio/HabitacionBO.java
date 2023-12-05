/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Dominio.Habitacion;
import Dominio.Hotel;
import Persistencia.Interfaces.IHabitacionDAO;
import Excepciones.BOException;
import Excepciones.PersistenciaException;
import Persistencia.DAO.HabitacionDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase que representa la lógica de negocios para la entidad 'Habitacion'.
 */
public class HabitacionBO {

    IHabitacionDAO habitacionDAO = new HabitacionDAO();

    public HabitacionBO() {

    }

    /**
     * Inserta una nueva habitación en la base de datos.
     *
     * @param habitacionInsertar Habitación a insertar.
     * @return Habitación insertada.
     * @throws BOException Si ocurre un error durante la operación.
     */
    public Habitacion insertar(Habitacion habitacionInsertar) throws BOException {

        try {
            return habitacionDAO.insertar(habitacionInsertar);
        } catch (PersistenciaException e) {
            throw new BOException(e.getMessage(), e);
        }

    }

    /**
     * Actualiza la información de una habitación en la base de datos.
     *
     * @param habitacionActualizar Habitación con la información actualizada.
     * @return Habitación actualizada.
     * @throws BOException Si ocurre un error durante la operación.
     */
    public Habitacion actualizar(Habitacion habitacionActualizar) throws BOException {

        try {
            return habitacionDAO.actualizar(habitacionActualizar);
        } catch (PersistenciaException e) {
            throw new BOException(e.getMessage(), e);
        }

    }

    /**
     * Elimina una habitación de la base de datos.
     *
     * @param habitacionEliminar Habitación a eliminar.
     * @return Habitación eliminada.
     * @throws BOException Si ocurre un error durante la operación.
     */
    public Habitacion eliminar(Habitacion habitacionEliminar) throws BOException {

        try {
            return habitacionDAO.eliminar(habitacionEliminar);
        } catch (PersistenciaException e) {
            throw new BOException(e.getMessage(), e);
        }
    }

    /**
     * Busca una habitación por su identificador en la base de datos.
     *
     * @param idHabitacion Identificador de la habitación.
     * @return Habitación encontrada.
     * @throws BOException Si ocurre un error durante la operación.
     */
    public Habitacion buscar(ObjectId idHabitacion) throws BOException {

        try {
            return habitacionDAO.buscar(idHabitacion);
        } catch (PersistenciaException e) {
            throw new BOException(e.getMessage(), e);
        }

    }

    /**
     * Busca una habitación por su número en la base de datos.
     *
     * @param numeroHabitacion Número de la habitación.
     * @return Habitación encontrada.
     * @throws BOException Si ocurre un error durante la operación.
     */
    public Habitacion buscar(int numeroHabitacion) throws BOException {

        try {
            return habitacionDAO.buscar(numeroHabitacion);
        } catch (PersistenciaException e) {
            throw new BOException(e.getMessage(), e);
        }
    }

    /**
     * Obtiene todas las habitaciones de un hotel específico.
     *
     * @param hotelSeleccionado Hotel del cual obtener las habitaciones.
     * @return Lista de habitaciones del hotel.
     * @throws BOException Si ocurre un error durante la operación.
     */
    public List<Habitacion> obtenerTodasLasHabitacionesPorHotel(Hotel hotelSeleccionado) throws BOException {

        try {

            List<Habitacion> listaHabitaciones = habitacionDAO.obtenerTodasLasHabitacionesPorHotel(hotelSeleccionado);

            return listaHabitaciones;

        } catch (PersistenciaException e) {
            throw new BOException(e.getMessage(), e);
        }

    }

    /**
     * Obtiene todas las habitaciones no asignadas de un hotel específico.
     *
     * @param hotelSeleccionado Hotel del cual obtener las habitaciones no
     * asignadas.
     * @return Lista de habitaciones no asignadas del hotel.
     * @throws BOException Si ocurre un error durante la operación.
     */
    public ArrayList<Habitacion> obtenerHabitacionsSinAsignar(Hotel hotelSeleccionado) throws BOException {

        try {
            ArrayList<Habitacion> listaHabitaciones = (ArrayList<Habitacion>) habitacionDAO.obtenerTodasLasHabitacionesPorHotel(hotelSeleccionado);
            ArrayList<Habitacion> listaHabitacionesSinAsignar = new ArrayList<>();

            for (int i = 0; i < listaHabitaciones.size(); i++) {
                if (!listaHabitaciones.get(i).isIsAsignado()) {

                    listaHabitacionesSinAsignar.add(listaHabitaciones.get(i));
                }
            }

            return listaHabitacionesSinAsignar;

        } catch (PersistenciaException e) {
            throw new BOException(e.getMessage(), e);
        }

    }
}
