/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

/**
 * Clase de excepción personalizada para errores relacionados con la
 * persistencia de datos.
 */
public class PersistenciaException extends Exception {

    /**
     * Constructor vacío de la clase PersistenciaException. Se utiliza para
     * crear instancias de la excepción sin proporcionar un mensaje detallado.
     */
    public PersistenciaException() {
    }

    /**
     * Constructor de la clase PersistenciaException que recibe un mensaje de
     * error.
     *
     * @param message Mensaje de error que describe la excepción.
     */
    public PersistenciaException(String message) {
        super(message);
    }

    /**
     * Constructor de la clase PersistenciaException que recibe un mensaje de
     * error y una causa.
     *
     * @param message Mensaje de error que describe la excepción.
     * @param cause Causa original de la excepción.
     */
    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }

}
