/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;
import Dominio.Persona;
import Persistencia.Interfaces.IPersonaDAO;
import Excepciones.BOException;
import Excepciones.PersistenciaException;
import Persistencia.DAO.PersonaDAO;
import org.bson.types.ObjectId;
/**
 *
 * @author 
 */
public class PersonaBO {
    
    IPersonaDAO personaDAO;
    
    public PersonaBO(){
        personaDAO = new PersonaDAO();
    }
    
    /**
     * 
     * @param personaInsertar
     * @return
     * @throws BOException 
     */
    public Persona insertar(Persona personaInsertar) throws BOException{
        
        try{
            return personaDAO.insertar(personaInsertar);
        }catch(PersistenciaException e){
            throw new BOException(e.getMessage(), e);
        }
        
    }
    
    /**
     * 
     * @param personaActualizar
     * @return
     * @throws BOException 
     */
//    public Persona actualizar(Persona personaActualizar) throws BOException{
//        
//        try{
//            return personaDAO.actualizar(personaActualizar);
//        }catch(PersistenciaException e){
//            throw new BOException(e.getMessage(), e);
//        }
//        
//    }
   
    /**
     * 
     * @param personaEliminar
     * @return
     * @throws BOException 
     */
    public Persona eliminar(Persona personaEliminar) throws BOException{
        
        try{
            return personaDAO.eliminar(personaEliminar);
        }catch (PersistenciaException e){
            throw new BOException(e.getMessage(), e);
        }
    }
    
    /**
     * 
     * @param idPersona
     * @return
     * @throws BOException 
     */
    public Persona buscar(ObjectId idPersona) throws BOException{
        
        try{
            return personaDAO.buscar(idPersona);
        }catch (PersistenciaException e){
            throw new BOException(e.getMessage(), e);
        }
        
    }
}
