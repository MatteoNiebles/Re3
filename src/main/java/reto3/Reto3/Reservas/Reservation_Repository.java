/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto3.Reto3.Reservas;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Matteo Niebles
 */
@Repository
public class Reservation_Repository {
    @Autowired
    private Reservation_Interface crud4;
        
    public List<Reservation_Entity> getAll(){
        return(List<Reservation_Entity>) crud4.findAll();
    }
    public Optional<Reservation_Entity> getReservation(int id){
        return crud4.findById(id);
    }
    public Reservation_Entity save(Reservation_Entity reservation){
        return crud4.save(reservation);
    }
    public void delete(Reservation_Entity reservation){
        crud4.delete(reservation);
    }
}
