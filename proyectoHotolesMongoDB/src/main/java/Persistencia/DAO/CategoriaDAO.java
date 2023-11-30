/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.DAO;
import Persistencia.Conexion.Conexion;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import Dominio.Categoria;
import Persistencia.Interfaces.ICategoriaDAO;
import Excepciones.PersistenciaException;
import org.bson.types.ObjectId;
import org.bson.conversions.Bson;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.UpdateResult;

/**
 *
 * @author 
 */
public class CategoriaDAO implements ICategoriaDAO{
    MongoDatabase baseDatos;
    MongoCollection<Document> coleccion;

    public CategoriaDAO(){
        this.baseDatos = Conexion.getConexion();
        this.coleccion = baseDatos.getCollection("categoria");
    }
    
    /**
     * 
     * @param insertarCategoria
     * @return
     * @throws PersistenciaException 
     */
    @Override
    public Categoria insertar(Categoria insertarCategoria) throws PersistenciaException{
        Document categoriaDocument = new Document();

        try{
            categoriaDocument.append("estrellas", insertarCategoria.getEstrellas())
                .append("iva", insertarCategoria.getIva());

            coleccion.insertOne(categoriaDocument);
        }catch (Exception e){
            throw new PersistenciaException("Error al insertar categoria:" + e.getMessage());
        }
        
        return insertarCategoria;
        
    }

    /**
     * 
     * @param actualizarCategoria
     * @return
     * @throws PersistenciaException 
     */
    @Override
    public Categoria actualizar(Categoria actualizarCategoria) throws PersistenciaException{
        Bson filtro = Filters.eq("_id", actualizarCategoria.getId());
        
        try{
            Document categoriaDocument = new Document()
                .append("estrellas", actualizarCategoria.getEstrellas())
                .append("iva", actualizarCategoria.getIva());
            
            Document actualizacion = new Document("$set", categoriaDocument);
            UpdateResult updateResult = coleccion.updateOne(filtro, actualizacion);
          
            
        }catch (Exception e){
            throw new PersistenciaException("Error al buscar categoria:" + e.getMessage());
        }
        
        return actualizarCategoria;
        
    }

    /**
     * 
     * @param eliminarCategoria
     * @return
     * @throws PersistenciaException 
     */
    @Override
    public Categoria eliminar(Categoria eliminarCategoria) throws PersistenciaException{
        
        try{
            Document filtro = new Document("_id",eliminarCategoria.getId());
            coleccion.deleteOne(filtro);
        } catch (Exception e){
            throw new PersistenciaException("Error al eliminar categoria:" + e.getMessage());
        }
        
        return eliminarCategoria;
    }
    
    /**
     * 
     * @param id
     * @return
     * @throws PersistenciaException 
     */
    @Override
    public Categoria buscar(ObjectId id) throws PersistenciaException{
        
        Document filtro = new Document("_id", id);
        
        try{
            Document categoria = coleccion.find(filtro).first();
            
            return new Categoria(
                    categoria.getObjectId("_id"),
                    categoria.getInteger("estrellas"),
                    categoria.getDouble("iva")
            );
        }catch (Exception e){
            System.out.println("ocurrio un error en:"  + e.getMessage());
        }
        
        return null;
        
    }
    
    /**
     * 
     * @param estrellas
     * @return
     * @throws PersistenciaException 
     */
    @Override
    public Categoria buscar(int estrellas) throws PersistenciaException{
        
        Document filtro = new Document("estrellas", estrellas);
        
        try{
            Document categoria = coleccion.find(filtro).first();
            
            return new Categoria(
                    categoria.getObjectId("_id"),
                    categoria.getInteger("estrellas"),
                    categoria.getDouble("iva")
            );
        }catch (Exception e){
            System.out.println("ocurrio un error en:"  + e.getMessage());
        }
        
        return null;
        
    }
    
}
