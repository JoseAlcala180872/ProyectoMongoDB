/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Dominio.Cliente;
import Persistencia.Interfaces.IClienteDAO;
import Excepciones.BOException;
import Excepciones.PersistenciaException;
import Persistencia.DAO.ClienteDAO;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase que representa la lógica de negocios para la entidad 'Cliente'.
 */
public class ClienteBO {

    IClienteDAO clienteDAO;

    /**
     * Constructor de la clase 'ClienteBO'. Inicializa la instancia del DAO para
     * el cliente.
     */
    public ClienteBO() {
        clienteDAO = new ClienteDAO();
    }

    /**
     * Inserta un nuevo cliente en la base de datos.
     *
     * @param clienteInsertar Cliente a insertar.
     * @return Cliente insertado.
     * @throws BOException Si ocurre un error durante la operación.
     */
    public Cliente insertar(Cliente clienteInsertar) throws BOException {

        try {
            return clienteDAO.insertar(clienteInsertar);
        } catch (PersistenciaException e) {
            throw new BOException(e.getMessage(), e);
        }

    }

    /**
     * Actualiza la información de un cliente en la base de datos.
     *
     * @param clienteActualizar Cliente con la información actualizada.
     * @return Cliente actualizado.
     * @throws BOException Si ocurre un error durante la operación.
     */
    public Cliente actualizar(Cliente clienteActualizar) throws BOException {

        try {
            return clienteDAO.actualizar(clienteActualizar);
        } catch (PersistenciaException e) {
            throw new BOException(e.getMessage(), e);
        }

    }

    /**
     * Elimina un cliente de la base de datos.
     *
     * @param clienteEliminar Cliente a eliminar.
     * @return Cliente eliminado.
     * @throws BOException Si ocurre un error durante la operación.
     */
    public Cliente eliminar(Cliente clienteEliminar) throws BOException {

        try {
            return clienteDAO.eliminar(clienteEliminar);
        } catch (PersistenciaException e) {
            throw new BOException(e.getMessage(), e);
        }
    }

    /**
     * Busca un cliente por su identificador en la base de datos.
     *
     * @param idCliente Identificador del cliente.
     * @return Cliente encontrado.
     * @throws BOException Si ocurre un error durante la operación.
     */
    public Cliente buscar(ObjectId _id) throws BOException {

        try {
            return clienteDAO.buscar(_id);
        } catch (PersistenciaException e) {
            throw new BOException(e.getMessage(), e);
        }

    }

    /**
     * Busca un cliente por su nombre en la base de datos.
     *
     * @param nombre Nombre del cliente.
     * @return Cliente encontrado.
     * @throws BOException Si ocurre un error durante la operación.
     */
    public Cliente buscar(String nombre) throws BOException {

        try {
            return clienteDAO.buscar(nombre);
        } catch (PersistenciaException e) {
            throw new BOException(e.getMessage(), e);
        }

    }
}
