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
 *
 * @author 
 */
public class ClienteBO {
    
    IClienteDAO clienteDAO;
    public ClienteBO(){
        clienteDAO = new ClienteDAO();
    }
    
    /**
     * 
     * @param clienteInsertar
     * @return
     * @throws BOException 
     */
    public Cliente insertar(Cliente clienteInsertar) throws BOException{
        
        try{
            return clienteDAO.insertar(clienteInsertar);
        }catch(PersistenciaException e){
            throw new BOException(e.getMessage(), e);
        }
        
    }
    
    /**
     * 
     * @param clienteActualizar
     * @return
     * @throws BOException 
     */
    public Cliente actualizar(Cliente clienteActualizar) throws BOException{
        
        try{
            return clienteDAO.actualizar(clienteActualizar);
        }catch(PersistenciaException e){
            throw new BOException(e.getMessage(), e);
        }
        
    }
   
    /**
     * 
     * @param clienteEliminar
     * @return
     * @throws BOException 
     */
    public Cliente eliminar(Cliente clienteEliminar) throws BOException{
        
        try{
            return clienteDAO.eliminar(clienteEliminar);
        }catch (PersistenciaException e){
            throw new BOException(e.getMessage(), e);
        }
    }
    
    /**
     * 
     * @param idSistema
     * @return
     * @throws BOException 
     */
    public Cliente buscar(ObjectId _id) throws BOException{
        
        try{
            return clienteDAO.buscar(_id);
        }catch (PersistenciaException e){
            throw new BOException(e.getMessage(), e);
        }
        
    }
    
    /**
     * 
     * @param idSistema
     * @return
     * @throws BOException 
     */
    public Cliente buscar(int idSistema) throws BOException{
        
        try{
            return clienteDAO.buscar(idSistema);
        }catch (PersistenciaException e){
            throw new BOException(e.getMessage(), e);
        }
        
    }
}
