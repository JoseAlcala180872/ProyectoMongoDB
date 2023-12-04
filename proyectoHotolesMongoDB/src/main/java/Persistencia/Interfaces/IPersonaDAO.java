/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia.Interfaces;
import Dominio.Persona;
import Excepciones.PersistenciaException;
import java.util.List;
import org.bson.types.ObjectId;
/**
 *
 * @author marcos_zr
 */
public interface IPersonaDAO {
    public Persona insertar(Persona insertarPersona) throws PersistenciaException;
//    public Persona actualizar(Persona actualizarPersona) throws PersistenciaException;
    public Persona eliminar(Persona eliminarPersona) throws PersistenciaException;
    public List<Persona> obtenerTodosLosHoteles() throws PersistenciaException;
    public Persona buscar(ObjectId id) throws PersistenciaException;
   
}