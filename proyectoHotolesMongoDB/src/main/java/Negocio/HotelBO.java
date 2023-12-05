/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Dominio.Hotel;
import Persistencia.Interfaces.IHotelDAO;
import Excepciones.BOException;
import Excepciones.PersistenciaException;
import Persistencia.DAO.HotelDAO;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase que representa la lógica de negocios para la entidad 'Hotel'.
 */
public class HotelBO {

    IHotelDAO hotelDAO = new HotelDAO();

    /**
     * Constructor de la clase 'HotelBO'. Inicializa la instancia del DAO para
     * el hotel.
     */
    public HotelBO() {

    }

    /**
     * Inserta un nuevo hotel en la base de datos.
     *
     * @param hotelInsertar Hotel a insertar.
     * @return Hotel insertado.
     * @throws BOException Si ocurre un error durante la operación.
     */
    public Hotel insertar(Hotel hotelInsertar) throws BOException {

        try {
            return hotelDAO.insertar(hotelInsertar);
        } catch (PersistenciaException e) {
            throw new BOException(e.getMessage(), e);
        }

    }

    /**
     * Actualiza la información de un hotel en la base de datos.
     *
     * @param hotelActualizar Hotel con la información actualizada.
     * @return Hotel actualizado.
     * @throws BOException Si ocurre un error durante la operación.
     */
    public Hotel actualizar(Hotel hotelActualizar) throws BOException {

        try {
            return hotelDAO.actualizar(hotelActualizar);
        } catch (PersistenciaException e) {
            throw new BOException(e.getMessage(), e);
        }

    }

    /**
     * Elimina un hotel de la base de datos.
     *
     * @param hotelEliminar Hotel a eliminar.
     * @return Hotel eliminado.
     * @throws BOException Si ocurre un error durante la operación.
     */
    public Hotel eliminar(Hotel hotelEliminar) throws BOException {

        try {
            return hotelDAO.eliminar(hotelEliminar);
        } catch (PersistenciaException e) {
            throw new BOException(e.getMessage(), e);
        }
    }

    /**
     * Busca un hotel por su identificador en la base de datos.
     *
     * @param idHotel Identificador del hotel.
     * @return Hotel encontrado.
     * @throws BOException Si ocurre un error durante la operación.
     */
    public Hotel buscar(ObjectId idHotel) throws BOException {

        try {
            return hotelDAO.buscar(idHotel);
        } catch (PersistenciaException e) {
            throw new BOException(e.getMessage(), e);
        }

    }

    /**
     * Busca un hotel por su nombre en la base de datos.
     *
     * @param nombre Nombre del hotel.
     * @return Hotel encontrado.
     * @throws BOException Si ocurre un error durante la operación.
     */
    public Hotel buscar(String nombre) throws BOException {

        try {
            return hotelDAO.buscar(nombre);
        } catch (PersistenciaException e) {
            throw new BOException(e.getMessage(), e);
        }
    }

    /**
     * Obtiene todos los hoteles de la base de datos.
     *
     * @return Lista de todos los hoteles.
     * @throws BOException Si ocurre un error durante la operación.
     */
    public List<Hotel> obtenerTodosLosHoteles() throws BOException {

        try {
            return hotelDAO.obtenerTodosLosHoteles();
        } catch (PersistenciaException e) {
            throw new BOException(e.getMessage(), e);
        }

    }
}
