/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

/**
 * Clase de excepción personalizada para errores relacionados con la capa de
 * negocios (BO - Business Object).
 */
public class BOException extends Exception {

    /**
     * Constructor vacío de la clase BOException. Se utiliza para crear
     * instancias de la excepción sin proporcionar un mensaje detallado.
     */
    public BOException() {
    }

    /**
     * Constructor de la clase BOException que recibe un mensaje de error.
     *
     * @param message Mensaje de error que describe la excepción.
     */
    public BOException(String message) {
        super(message);
    }

    /**
     * Constructor de la clase BOException que recibe un mensaje de error y una
     * causa.
     *
     * @param message Mensaje de error que describe la excepción.
     * @param cause Causa original de la excepción.
     */
    public BOException(String message, Throwable cause) {
        super(message, cause);
    }
}
