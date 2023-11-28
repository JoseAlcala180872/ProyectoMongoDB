/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia.Interfaces;
import Dominio.Hotel;
import Excepciones.PersistenciaException;
/**
 *
 * @author marcos_zr
 */
public interface IHotelDAO {
    
    public void insertar(Hotel hotel) throws PersistenciaException;
    public void actualizar(Hotel hotel) throws PersistenciaException;
    public void eliminar(Hotel hotel) throws PersistenciaException;
}
