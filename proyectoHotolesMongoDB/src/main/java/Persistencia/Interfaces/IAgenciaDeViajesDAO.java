/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia.Interfaces;
import Dominio.AgenciaDeViajes;
import Excepciones.PersistenciaException;
import java.util.List;
import org.bson.types.ObjectId;
/**
 *
 * @author 
 */
public interface IAgenciaDeViajesDAO {
    public AgenciaDeViajes insertar(AgenciaDeViajes insertarAgenciaDeViajes) throws PersistenciaException;
    public AgenciaDeViajes actualizar(AgenciaDeViajes actualizarAgenciaDeViajes) throws PersistenciaException;
    public AgenciaDeViajes eliminar(AgenciaDeViajes eliminarAgenciaDeViajes) throws PersistenciaException;
    public List<AgenciaDeViajes> obtenerTodosLosHoteles() throws PersistenciaException;
    public AgenciaDeViajes buscar(ObjectId id) throws PersistenciaException;
}
