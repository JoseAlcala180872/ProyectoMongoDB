/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.itson.proyectohotolesmongodb;

import org.bson.types.ObjectId;
import Persistencia.Conexion.Conexion;
import Persistencia.DAO.*;
import Excepciones.PersistenciaException;
import Dominio.*;
import Excepciones.BOException;
import Persistencia.Interfaces.*;
import Negocio.*;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author José Carlos Alcalá Ruíz 180872
 */
public class ProyectoHotolesMongoDB {

    public static void main(String[] args) throws PersistenciaException, BOException {
        IHotelDAO hotelDAO = new HotelDAO();
        ICategoriaDAO categoriaDAO = new CategoriaDAO();
        IHabitacionDAO habitacionDAO = new HabitacionDAO();

        IClienteDAO clienteDAO = new ClienteDAO();
        IPersonaDAO personaDAO = new PersonaDAO();
        ClienteBO clienteBO = new ClienteBO();
        PersonaBO personaBO = new PersonaBO();
       AgenciaDeViajesBO agenciaBO = new AgenciaDeViajesBO();
      
       /**
       try{
           Cliente cliente = new Persona( "marcos zazueta", "colonia nueva palmira", "6441715490");
          Cliente clienteObtenido = clienteBO.insertar(cliente);
           Persona persona = new Persona(clienteActual.getNombre(), clienteActual.getDireccion(), clienteActual.getTelefono(), clienteActual);
            personaBO.insertar(persona);
            
           Cliente cliente2 = new Cliente("agencia trivago", "los angeles", "777");
           Cliente clienteInsertado = clienteBO.insertar(cliente2);
            Cliente clienteBuscado = clienteBO.buscar(new ObjectId("656d47532a37a72236ad60ef"));
            
            AgenciaDeViajes cliente3 = new AgenciaDeViajes( "stephen curry", clienteBuscado);
            agenciaBO.insertar(cliente3);

        }catch(BOException e){
            throw new BOException(e.getMessage(), e);
        }
// */
//        Cliente clienteNuevo = new Persona("mario bros", "pueblo champiñon", "6445540");
//
//        Cliente clienteI = clienteBO.insertar(clienteNuevo);
//
//        System.out.println(clienteI.getId().toString());
//        Categoria categoria1 = new Categoria(5, 0.16);
//        Categoria categoria2 = new Categoria(3, 0.16);
//        Categoria categoria3 = new Categoria(1, 0.16);
//
//        categoriaDAO.insertar(categoria1);
//        categoriaDAO.insertar(categoria2);
//        categoriaDAO.insertar(categoria3);
//        
//        Categoria categoria4 = categoriaDAO.buscar(5);
//        Categoria categoria5 = categoriaDAO.buscar(3);
//        Categoria categoria6 = categoriaDAO.buscar(1);
//        Hotel hotel1 = new Hotel("Posada Deluexe", "Campestre 3151", "6441983990", "2003", categoria4);
//        Hotel hotel2 = new Hotel("El viejo Jimmy", "El campanario", "6441983920", "1995", categoria5);
//        Hotel hotel3 = new Hotel("La nana", "Pueblo Yaqui", "6441983900", "2021", categoria6);
//        hotelDAO.insertar(hotel1);
//        hotelDAO.insertar(hotel2);
//        hotelDAO.insertar(hotel3);
        
        
        Hotel hotel4 = hotelDAO.buscar("Posada Deluexe");
        Hotel hotel5 = hotelDAO.buscar("La nana");
        Hotel hotel6 = hotelDAO.buscar("El viejo Jimmy");
        
        Habitacion habitacion1 = new Habitacion("inidividual", 12, 1500, hotel4, false);
        Habitacion habitacion2 = new Habitacion("individual", 13, 2500, hotel5, false);
        Habitacion habitacion3 = new Habitacion("doble", 15, 4500, hotel6, false);
        
//        Habitacion habitacionO1 = new Habitacion("doble", 16, 500, hotel4, true);
//        Habitacion habitacionO2 = new Habitacion("individual", 17, 250, hotel5, true);
//        Habitacion habitacionO3 = new Habitacion("doble", 18, 450, hotel6, true);
            
        habitacionDAO.insertar(habitacion1);
        habitacionDAO.insertar(habitacion2);
        habitacionDAO.insertar(habitacion3);

//        ArrayList<Habitacion> listaHabitaciones = (ArrayList<Habitacion>) habitacionDAO.obtenerTodasLasHabitacionesPorHotel(hotel4);
//        ArrayList<Habitacion> listaHabitacionesSinAsignar = new ArrayList<>();
//        for (int i = 0; i < listaHabitaciones.size(); i++) {
//            if(!listaHabitaciones.get(i).isIsAsignado()){
//                
//                listaHabitacionesSinAsignar.add(listaHabitaciones.get(i));
//          }
//       }
//        
//        
//        for (Habitacion habitacion : listaHabitacionesSinAsignar) {
//            System.out.println(habitacion.toString());
//        }
    }
}
