/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto3.Reto3.Ortesis;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Matteo Niebles
 */
@Service
public class Ortesis_Service {
    @Autowired
    private Ortesis_Repository metodosCrud;
    public List<Ortesis_Entity> getAll(){
        return metodosCrud.getAll();
    }
    public Optional<Ortesis_Entity> getOrtopedic(int OrtopedicId){
        return metodosCrud.getOrtopedic(OrtopedicId);
    }
    public Ortesis_Entity save(Ortesis_Entity ortopedic){
        if(ortopedic.getId()==null){
            return metodosCrud.save(ortopedic);
        }else{
            Optional<Ortesis_Entity> e=metodosCrud.getOrtopedic(ortopedic.getId());
            if(e.isEmpty()){
                return metodosCrud.save(ortopedic);
            }else{
                return ortopedic;
            }
        }
    }
    public Ortesis_Entity update(Ortesis_Entity ortopedic){
        if(ortopedic.getId()!=null){
            Optional<Ortesis_Entity> e=metodosCrud.getOrtopedic(ortopedic.getId());
            if(!e.isEmpty()){
                if(ortopedic.getName()!=null){
                    e.get().setName(ortopedic.getName());
                }
                if(ortopedic.getBrand()!=null){
                    e.get().setBrand(ortopedic.getBrand());
                }
                if(ortopedic.getYear()!=null){
                    e.get().setBrand(ortopedic.getBrand());
                }
                if(ortopedic.getDescription()!=null){
                    e.get().setDescription(ortopedic.getDescription());
                }
                if(ortopedic.getCategory()!=null){
                    e.get().setCategory(ortopedic.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return ortopedic;
            }
        }else{
            return ortopedic;
        }
    }
    public boolean deleteOrtopedic(int ortopedicId){
        Boolean aBoolean = getOrtopedic(ortopedicId).map(ortopedic ->{
            metodosCrud.delete(ortopedic);
            return false;
        }).orElse(false);
        return aBoolean;
    }
}
