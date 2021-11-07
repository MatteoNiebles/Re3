/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto3.Reto3.Category;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Matteo Niebles
 */
@Repository
public class Category_Repository {
    @Autowired
    private Category_Interface crud;
        
    public List<Category_Entity> getAll(){
        return(List<Category_Entity>) crud.findAll();
    }
    public Optional<Category_Entity> getCategory(int id){
        return crud.findById(id);
    }
    public Category_Entity save(Category_Entity category){
        return crud.save(category);
    }
    public void delete(Category_Entity category){
        crud.delete(category);
    }
}
