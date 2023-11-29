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
import org.bson.types.ObjectId;
/**
 *
 * @author 
 */
public class HotelBO {
    
    IHotelDAO hotelDAO = new HotelDAO();
    
    public HotelBO(){
        
    }
    
    /**
     * 
     * @param hotelInsertar
     * @return
     * @throws BOException 
     */
    public Hotel insertar(Hotel hotelInsertar) throws BOException{
        
        try{
            return hotelDAO.insertar(hotelInsertar);
        }catch(PersistenciaException e){
            throw new BOException(e.getMessage(), e);
        }
        
    }
    
    /**
     * 
     * @param hotelActualizar
     * @return
     * @throws BOException 
     */
    public Hotel actualizar(Hotel hotelActualizar) throws BOException{
        
        try{
            return hotelDAO.actualizar(hotelActualizar);
        }catch(PersistenciaException e){
            throw new BOException(e.getMessage(), e);
        }
        
    }
    
    /**
     * 
     * @param hotelEliminar
     * @return
     * @throws BOException 
     */
    public Hotel eliminar(Hotel hotelEliminar) throws BOException{
        
        try{
            return hotelDAO.eliminar(hotelEliminar);
        }catch (PersistenciaException e){
            throw new BOException(e.getMessage(), e);
        }
    }
    
    /**
     * 
     * @param idHotel
     * @return
     * @throws BOException 
     */
    public Hotel buscar(ObjectId idHotel) throws BOException{
        
        try{
            return hotelDAO.buscar(idHotel);
        }catch (PersistenciaException e){
            throw new BOException(e.getMessage(), e);
        }
        
    }
}
