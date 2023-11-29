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
    private int  estrellas;
    private double iva;
    
    /**
     * 
     */
    public Categoria(){
        
    }

    /**
     * 
     * @param _id
     * @param estrellas
     * @param iva 
     */
    public Categoria(ObjectId _id, int estrellas, double iva) {
        this._id = _id;
        this.estrellas = estrellas;
        this.iva = iva;
    }
    
    public Categoria(int estrellas, double iva){
        this.estrellas = estrellas;
        this.iva = iva;
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    
    
}
