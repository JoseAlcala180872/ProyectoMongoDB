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
        Document filtro = new Document("_id", new ObjectId(actualizarCategoria.getId()));
        
        try{
            Document categoriaDocument = new Document()
                .append("estrellas", actualizarCategoria.getEstrellas())
                .append("iva", actualizarCategoria.getIva());

            coleccion.replaceOne(filtro, categoriaDocument);
            
        }catch (Exception e){
            
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
        Document filtro = new Document("_id", new ObjectId(eliminarCategoria.getId()));
        try{
            coleccion.deleteOne(filtro);
        }catch (Exception e){
            
        }
        
        return eliminarCategoria;
    }
    
}
