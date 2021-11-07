/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto3.Reto3.Client;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Matteo Niebles
 */
@Service
public class Client_Service {
     @Autowired
     private Client_Repository metodosCrud;
     
     public List<Client_Entity> getAll(){
        return metodosCrud.getAll();
    }
     
      public Optional<Client_Entity> getClient(int clientId) {
        return metodosCrud.getClient(clientId);
    }
    public Client_Entity save(Client_Entity client){
        if(client.getIdClient()==null){
            return metodosCrud.save(client);
        }else{
            Optional<Client_Entity> e= metodosCrud.getClient(client.getIdClient());
            if(e.isEmpty()){
                return metodosCrud.save(client);
            }else{
                return client;
            }
        }
    }
    public Client_Entity update(Client_Entity client){
        if(client.getIdClient()!=null){
            Optional<Client_Entity> e= metodosCrud.getClient(client.getIdClient());
            if(!e.isEmpty()){
                if(client.getName()!=null){
                    e.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    e.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    e.get().setPassword(client.getPassword());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }
    public boolean deleteClient(int clientId) {
        Boolean aBoolean = getClient(clientId).map(client -> {
            metodosCrud.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
