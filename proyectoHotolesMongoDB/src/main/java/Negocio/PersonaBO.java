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
 * Clase que representa la lógica de negocios para la entidad 'Persona'.
 */
public class PersonaBO {

    IPersonaDAO personaDAO;

    /**
     * Constructor de la clase 'PersonaBO'. Inicializa la instancia del DAO para
     * la persona.
     */
    public PersonaBO() {
        personaDAO = new PersonaDAO();
    }

    /**
     * Inserta una nueva persona en la base de datos.
     *
     * @param personaInsertar Persona a insertar.
     * @return Persona insertada.
     * @throws BOException Si ocurre un error durante la operación.
     */
    public Persona insertar(Persona personaInsertar) throws BOException {

        try {
            return personaDAO.insertar(personaInsertar);
        } catch (PersistenciaException e) {
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
     * Elimina una persona de la base de datos.
     *
     * @param personaEliminar Persona a eliminar.
     * @return Persona eliminada.
     * @throws BOException Si ocurre un error durante la operación.
     */
    public Persona eliminar(Persona personaEliminar) throws BOException {

        try {
            return personaDAO.eliminar(personaEliminar);
        } catch (PersistenciaException e) {
            throw new BOException(e.getMessage(), e);
        }
    }

    /**
     * Busca una persona por su identificador en la base de datos.
     *
     * @param idPersona Identificador de la persona.
     * @return Persona encontrada.
     * @throws BOException Si ocurre un error durante la operación.
     */
    public Persona buscar(ObjectId idPersona) throws BOException {

        try {
            return personaDAO.buscar(idPersona);
        } catch (PersistenciaException e) {
            throw new BOException(e.getMessage(), e);
        }

    }
}
