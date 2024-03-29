/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto3.Reto3.Client;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Matteo Niebles
 */
@Repository
public class Client_Repository {
    @Autowired
    private Client_Interface crud1;
        
    public List<Client_Entity> getAll(){
        return(List<Client_Entity>) crud1.findAll();
    }
    public Optional<Client_Entity> getClient(int id){
        return crud1.findById(id);
    }
    public Client_Entity save(Client_Entity client){
        return crud1.save(client);
    }
    public void delete(Client_Entity client){
        crud1.delete(client);
    }
}
