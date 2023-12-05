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
 *
 * @author
 */
public class AgenciaDeViajesBO {
    
    IAgenciaDeViajesDAO agenciaDAO;
    
    public AgenciaDeViajesBO(){
        agenciaDAO = new AgenciaDeViajesDAO();
    }
    
    /**
     * 
     * @param agenciaInsertar
     * @return
     * @throws BOException 
     */
    public AgenciaDeViajes insertar(AgenciaDeViajes agenciaInsertar) throws BOException{
        
        try{
            return agenciaDAO.insertar(agenciaInsertar);
        }catch(PersistenciaException e){
            throw new BOException(e.getMessage(), e);
        }
        
    }
    
   /**
    * 
    * @param agenciaActualizar
    * @return
    * @throws BOException 
    */
    public AgenciaDeViajes actualizar(AgenciaDeViajes agenciaActualizar) throws BOException{
        
        try{
            return agenciaDAO.actualizar(agenciaActualizar);
        }catch(PersistenciaException e){
            throw new BOException(e.getMessage(), e);
        }
        
    }
   
    /**
     * 
     * @param agenciaEliminar
     * @return
     * @throws BOException 
     */
    public AgenciaDeViajes eliminar(AgenciaDeViajes agenciaEliminar) throws BOException{
        
        try{
            return agenciaDAO.eliminar(agenciaEliminar);
        }catch (PersistenciaException e){
            throw new BOException(e.getMessage(), e);
        }
    }
    
    /**
     * 
     * @param idAgencia
     * @return
     * @throws BOException 
     */
    public AgenciaDeViajes buscar(ObjectId idAgencia) throws BOException{
        
        try{
            return agenciaDAO.buscar(idAgencia);
        }catch (PersistenciaException e){
            throw new BOException(e.getMessage(), e);
        }
        
    }
    
    public AgenciaDeViajes buscarPorCliente(ObjectId idCliente) throws BOException{
        
        try{
            return agenciaDAO.buscar(idCliente);
        }catch (PersistenciaException e){
            throw new BOException(e.getMessage(), e);
        }
        
    }
}
