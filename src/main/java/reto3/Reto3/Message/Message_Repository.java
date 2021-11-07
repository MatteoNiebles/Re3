/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto3.Reto3.Message;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Matteo Niebles
 */
@Repository
public class Message_Repository {
    @Autowired
    private Message_Interface crud3;
        
    public List<Message_Entity> getAll(){
        return(List<Message_Entity>) crud3.findAll();
    }
    public Optional<Message_Entity> getMessage(int id){
        return crud3.findById(id);
    }
    public Message_Entity save(Message_Entity message){
        return crud3.save(message);
    }
    public void delete(Message_Entity message){
        crud3.delete(message);
    }
}
