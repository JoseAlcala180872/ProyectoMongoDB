/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia.Interfaces;
import Dominio.Cliente;
import Excepciones.PersistenciaException;
import java.util.List;
import org.bson.types.ObjectId;
/**
 *
 * @author 
 */
public interface IClienteDAO {
    public Cliente insertar(Cliente insertarCliente) throws PersistenciaException;
    public Cliente actualizar(Cliente actualizarCliente) throws PersistenciaException;
    public Cliente eliminar(Cliente eliminarCliente) throws PersistenciaException;
    public List<Cliente> obtenerTodosLosHoteles() throws PersistenciaException;
    public Cliente buscar(ObjectId id) throws PersistenciaException;
    public Cliente buscar(int idSistema) throws PersistenciaException;
}
