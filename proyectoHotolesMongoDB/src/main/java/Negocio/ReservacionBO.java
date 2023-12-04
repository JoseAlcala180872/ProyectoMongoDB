/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;
import Dominio.Reservacion;
import Persistencia.Interfaces.IReservacionDAO;
import Excepciones.BOException;
import Excepciones.PersistenciaException;
import Persistencia.DAO.ReservacionDAO;
import java.util.List;
import org.bson.types.ObjectId;
/**
 *
 * @author 
 */
public class ReservacionBO {
    IReservacionDAO reservacionDAO;
    
    public ReservacionBO(){
        this.reservacionDAO = new ReservacionDAO();
    }
    
    public Reservacion insertar(Reservacion reservacionInsertar) throws BOException{
        
        try{
            return this.reservacionDAO.insertar(reservacionInsertar);
        }catch(PersistenciaException e){
            throw new BOException(e.getMessage(), e);
        }
        
    }
}
