/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import org.bson.types.ObjectId;

/**
 *
 * @author
 */
public class Categoria {

    private ObjectId _id;
    private int estrellas;
    private double iva;

    /**
     * Constructor vacío de la clase Categoria. Se utiliza para crear instancias
     * de la clase sin proporcionar valores iniciales.
     */
    public Categoria() {

    }

    /**
     * Constructor de la clase Categoria que recibe parámetros para inicializar
     * sus atributos.
     *
     * @param _id Identificador único de la categoría.
     * @param estrellas Número de estrellas de la categoría.
     * @param iva Valor del impuesto IVA asociado a la categoría.
     */
    public Categoria(ObjectId _id, int estrellas, double iva) {
        this._id = _id;
        this.estrellas = estrellas;
        this.iva = iva;
    }

    /**
     * Constructor de la clase Categoria que recibe parámetros para inicializar
     * sus atributos.
     *
     * @param estrellas Número de estrellas de la categoría.
     * @param iva Valor del impuesto IVA asociado a la categoría.
     */
    public Categoria(int estrellas, double iva) {
        this.estrellas = estrellas;
        this.iva = iva;
    }

    /**
     * Obtiene el identificador único de la categoría.
     *
     * @return Identificador único de la categoría.
     */
    public ObjectId getId() {
        return _id;
    }

    /**
     * Establece el identificador único de la categoría.
     *
     * @param _id Nuevo identificador único de la categoría.
     */
    public void setId(ObjectId _id) {
        this._id = _id;
    }

    /**
     * Obtiene el número de estrellas de la categoría.
     *
     * @return Número de estrellas de la categoría.
     */
    public int getEstrellas() {
        return estrellas;
    }

    /**
     * Establece el número de estrellas de la categoría.
     *
     * @param estrellas Nuevo número de estrellas de la categoría.
     */
    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    /**
     * Obtiene el valor del impuesto IVA asociado a la categoría.
     *
     * @return Valor del impuesto IVA asociado a la categoría.
     */
    public double getIva() {
        return iva;
    }

    /**
     * Establece el valor del impuesto IVA asociado a la categoría.
     *
     * @param iva Nuevo valor del impuesto IVA asociado a la categoría.
     */
    public void setIva(double iva) {
        this.iva = iva;
    }

}
