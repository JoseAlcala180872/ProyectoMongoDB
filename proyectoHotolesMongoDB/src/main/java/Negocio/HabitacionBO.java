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
 *
 * @author 
 */
public class HabitacionBO {
    IHabitacionDAO habitacionDAO = new HabitacionDAO();
    
    public HabitacionBO(){
        
    }
    
    /**
     * 
     * @param habitacionInsertar
     * @return
     * @throws BOException 
     */
    public Habitacion insertar(Habitacion habitacionInsertar) throws BOException{
        
        try{
            return habitacionDAO.insertar(habitacionInsertar);
        }catch(PersistenciaException e){
            throw new BOException(e.getMessage(), e);
        }
        
    }
    
    /**
     * 
     * @param habitacionActualizar
     * @return
     * @throws BOException 
     */
    public Habitacion actualizar(Habitacion habitacionActualizar) throws BOException{
        
        try{
            return habitacionDAO.actualizar(habitacionActualizar);
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
    public Habitacion eliminar(Habitacion habitacionEliminar) throws BOException{
        
        try{
            return habitacionDAO.eliminar(habitacionEliminar);
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
    public Habitacion buscar(ObjectId idHabitacion) throws BOException{
        
        try{
            return habitacionDAO.buscar(idHabitacion);
        }catch (PersistenciaException e){
            throw new BOException(e.getMessage(), e);
        }
        
    }
    
    /**
     * 
     * @param numeroHabitacion
     * @return
     * @throws BOException 
     */
    public Habitacion buscar(int numeroHabitacion) throws BOException{
        
        try{
            return habitacionDAO.buscar(numeroHabitacion);
        }catch(PersistenciaException e){
            throw new BOException(e.getMessage(), e);
        }
    }
    
    /**
     * 
     * @param hotelSeleccionado
     * @return
     * @throws BOException 
     */
    public List<Habitacion> obtenerTodasLasHabitacionesPorHotel(Hotel hotelSeleccionado) throws BOException{
        
        try{
            
            List<Habitacion> listaHabitaciones = habitacionDAO.obtenerTodasLasHabitacionesPorHotel(hotelSeleccionado);
            
            return listaHabitaciones;
            
        }catch(PersistenciaException e){
            throw new BOException(e.getMessage(), e);
        }
        
    }
    
    /**
     * 
     * @param hotelSeleccionado
     * @return 
     * @throws Excepciones.BOException 
     */
    public ArrayList<Habitacion> obtenerHabitacionsSinAsignar(Hotel hotelSeleccionado) throws BOException{
        
        try{
            ArrayList<Habitacion> listaHabitaciones = (ArrayList<Habitacion>) habitacionDAO.obtenerTodasLasHabitacionesPorHotel(hotelSeleccionado);
            ArrayList<Habitacion> listaHabitacionesSinAsignar = new ArrayList<>();
            
        for (int i = 0; i < listaHabitaciones.size(); i++) {
            if(!listaHabitaciones.get(i).isIsAsignado()){
                
                listaHabitacionesSinAsignar.add(listaHabitaciones.get(i));
            }
        }

            return listaHabitacionesSinAsignar;
            
        }catch(PersistenciaException e){
            throw new BOException(e.getMessage(), e);
        }
                
        
    }
}
