/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia.Interfaces;
import Dominio.Persona;
import Excepciones.PersistenciaException;
import org.bson.types.ObjectId;
/**
 *
 * @author marcos_zr
 */
public interface IPersonaDAO {
    /**
 * Interfaz que define los métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
 * sobre entidades de tipo Persona en la base de datos.
 */
    public Persona insertar(Persona insertarPersona) throws PersistenciaException;
    /**
     * Inserta una nueva persona en la base de datos.
     *
     * @param insertarPersona La persona a insertar.
     * @return La persona insertada.
     * @throws PersistenciaException Si ocurre un error durante la inserción.
     */
    public Persona eliminar(Persona eliminarPersona) throws PersistenciaException;
    /**
     * Elimina una persona de la base de datos.
     *
     * @param eliminarPersona La persona a eliminar.
     * @return La persona eliminada.
     * @throws PersistenciaException Si ocurre un error durante la eliminación.
     */
    public Persona buscar(ObjectId id) throws PersistenciaException;
    /**
     * Busca una persona por su ID en la base de datos.
     *
     * @param id El ID de la persona a buscar.
     * @return La persona encontrada.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda.
     */
   
}
