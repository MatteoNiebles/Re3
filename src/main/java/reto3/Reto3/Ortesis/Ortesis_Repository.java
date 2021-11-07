/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto3.Reto3.Ortesis;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Matteo Niebles
 */
@Repository
public class Ortesis_Repository {
    
    @Autowired
    private Ortesis_Interface crud;
        
    public List<Ortesis_Entity> getAll(){
        return(List<Ortesis_Entity>) crud.findAll();
    }
    public Optional<Ortesis_Entity> getOrtopedic(int id){
        return crud.findById(id);
    }
    public Ortesis_Entity save(Ortesis_Entity ortopedic){
        return crud.save(ortopedic);
    }
    public void delete(Ortesis_Entity ortopedic){
        crud.delete(ortopedic);
    }   
}
