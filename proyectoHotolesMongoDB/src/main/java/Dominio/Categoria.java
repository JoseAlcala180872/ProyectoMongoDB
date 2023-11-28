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
    
    private String _id;
    private int  estrellas;
    private float iva;
    
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
    public Categoria(String _id, int estrellas, float iva) {
        this._id = _id;
        this.estrellas = estrellas;
        this.iva = iva;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    
    
}
