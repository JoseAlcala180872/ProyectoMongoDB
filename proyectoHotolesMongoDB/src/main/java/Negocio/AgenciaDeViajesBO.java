/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Dominio.AgenciaDeViajes;
import Persistencia.Interfaces.IAgenciaDeViajesDAO;
import Excepciones.BOException;
import Excepciones.PersistenciaException;
import Persistencia.DAO.AgenciaDeViajesDAO;
import org.bson.types.ObjectId;

/**
 * Clase que representa la lógica de negocios para la entidad 'AgenciaDeViajes'.
 */
public class AgenciaDeViajesBO {

    IAgenciaDeViajesDAO agenciaDAO;

    /**
     * Constructor de la clase 'AgenciaDeViajesBO'. Inicializa la instancia del
     * DAO para la agencia de viajes.
     */
    public AgenciaDeViajesBO() {
        agenciaDAO = new AgenciaDeViajesDAO();
    }

    /**
     * Inserta una nueva agencia de viajes en la base de datos.
     *
     * @param agenciaInsertar Agencia de viajes a insertar.
     * @return Agencia de viajes insertada.
     * @throws BOException Si ocurre un error durante la operación.
     */
    public AgenciaDeViajes insertar(AgenciaDeViajes agenciaInsertar) throws BOException {

        try {
            return agenciaDAO.insertar(agenciaInsertar);
        } catch (PersistenciaException e) {
            throw new BOException(e.getMessage(), e);
        }

    }

    /**
     * Actualiza la información de una agencia de viajes en la base de datos.
     *
     * @param agenciaActualizar Agencia de viajes con la información
     * actualizada.
     * @return Agencia de viajes actualizada.
     * @throws BOException Si ocurre un error durante la operación.
     */
    public AgenciaDeViajes actualizar(AgenciaDeViajes agenciaActualizar) throws BOException {

        try {
            return agenciaDAO.actualizar(agenciaActualizar);
        } catch (PersistenciaException e) {
            throw new BOException(e.getMessage(), e);
        }

    }

    /**
     * Elimina una agencia de viajes de la base de datos.
     *
     * @param agenciaEliminar Agencia de viajes a eliminar.
     * @return Agencia de viajes eliminada.
     * @throws BOException Si ocurre un error durante la operación.
     */
    public AgenciaDeViajes eliminar(AgenciaDeViajes agenciaEliminar) throws BOException {

        try {
            return agenciaDAO.eliminar(agenciaEliminar);
        } catch (PersistenciaException e) {
            throw new BOException(e.getMessage(), e);
        }
    }

    /**
     * Busca una agencia de viajes por su identificador en la base de datos.
     *
     * @param idAgencia Identificador de la agencia de viajes.
     * @return Agencia de viajes encontrada.
     * @throws BOException Si ocurre un error durante la operación.
     */
    public AgenciaDeViajes buscar(ObjectId idAgencia) throws BOException {

        try {
            return agenciaDAO.buscar(idAgencia);
        } catch (PersistenciaException e) {
            throw new BOException(e.getMessage(), e);
        }

    }

    /**
     * Busca una agencia de viajes asociada a un cliente por su identificador en
     * la base de datos.
     *
     * @param idCliente Identificador del cliente asociado a la agencia de
     * viajes.
     * @return Agencia de viajes encontrada.
     * @throws BOException Si ocurre un error durante la operación.
     */
    public AgenciaDeViajes buscarPorCliente(ObjectId idCliente) throws BOException {

        try {
            return agenciaDAO.buscar(idCliente);
        } catch (PersistenciaException e) {
            throw new BOException(e.getMessage(), e);
        }

    }
}
