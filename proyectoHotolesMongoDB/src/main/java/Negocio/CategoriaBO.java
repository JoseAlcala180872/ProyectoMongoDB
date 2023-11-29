/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;
import Dominio.Categoria;
import Persistencia.Interfaces.ICategoriaDAO;
import Excepciones.BOException;
import Excepciones.PersistenciaException;
import Persistencia.DAO.CategoriaDAO;
import org.bson.types.ObjectId;
/**
 *
 * @author marcos_zr
 */
public class CategoriaBO {
    ICategoriaDAO categoriaDAO = new CategoriaDAO();
    
    public CategoriaBO(){
    }
    
    
     /**
     * 
     * @param CategoriaInsertar
     * @return
     * @throws BOException 
     */
    public Categoria insertar(Categoria CategoriaInsertar) throws BOException{
        
        try{
            return categoriaDAO.insertar(CategoriaInsertar);
        }catch(PersistenciaException e){
            throw new BOException(e.getMessage(), e);
        }
        
    }
    
    /**
     * 
     * @param categoriaActualizar
     * @return
     * @throws BOException 
     */
    public Categoria actualizar(Categoria categoriaActualizar) throws BOException{
        
        try{
            return categoriaDAO.actualizar(categoriaActualizar);
        }catch(PersistenciaException e){
            throw new BOException(e.getMessage(), e);
        }
        
    }
    
    /**
     * 
     * @param categoriaEliminar
     * @return
     * @throws BOException 
     */
    public Categoria eliminar(Categoria categoriaEliminar) throws BOException{
        
        try{
            return categoriaDAO.eliminar(categoriaEliminar);
        }catch (PersistenciaException e){
            throw new BOException(e.getMessage(), e);
        }
    }
    
    /**
     * 
     * @param idCategoria
     * @return
     * @throws BOException 
     */
    public Categoria buscar(ObjectId idCategoria) throws BOException{
        
        try{
            return categoriaDAO.buscar(idCategoria);
        }catch (PersistenciaException e){
            throw new BOException(e.getMessage(), e);
        }
        
    }
    
    /**
     * 
     * @param estrellas
     * @return
     * @throws BOException 
     */
    public Categoria buscar(int estrellas) throws BOException{
        
        try{
            return categoriaDAO.buscar(estrellas);
        }catch (PersistenciaException e){
            throw new BOException(e.getMessage(), e);
        }
        
    }
}
