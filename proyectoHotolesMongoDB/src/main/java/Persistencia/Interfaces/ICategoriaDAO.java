/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia.Interfaces;
import Dominio.Categoria;
import Excepciones.PersistenciaException;
import org.bson.types.ObjectId;
/**
 *
 * @author marcos_zr
 */
public interface ICategoriaDAO {
    
    public Categoria insertar(Categoria insertarCategoria) throws PersistenciaException;
    public Categoria actualizar(Categoria actualizarCategoria) throws PersistenciaException;
    public Categoria eliminar(Categoria eliminarCategoria) throws PersistenciaException;
    public Categoria buscar(ObjectId idCategoria) throws PersistenciaException;
    public Categoria buscar(int estrellas) throws PersistenciaException;
}
