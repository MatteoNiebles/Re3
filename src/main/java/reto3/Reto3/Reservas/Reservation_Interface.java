/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package reto3.Reto3.Reservas;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Matteo Niebles
 */
public interface Reservation_Interface extends CrudRepository<Reservation_Entity,Integer> {
    
}
