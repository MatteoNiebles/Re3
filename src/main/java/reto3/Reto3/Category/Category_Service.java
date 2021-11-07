/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto3.Reto3.Category;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Matteo Niebles
 */
@Service
public class Category_Service {
     @Autowired
    private Category_Repository metodosCrud;

    public List<Category_Entity> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Category_Entity> getCategory(int CategoriaId) {
        return metodosCrud.getCategory(CategoriaId);
    }

    public Category_Entity save(Category_Entity category) {
        if (category.getId()== null) {
            return metodosCrud.save(category);
        } else {
            Optional<Category_Entity> categoria1 = metodosCrud.getCategory(category.getId());
            if (categoria1.isEmpty()) {
                return metodosCrud.save(category);
            } else {
                return category;
            }
        }
    }

    public Category_Entity update(Category_Entity category){
        if(category.getId()!=null){
            Optional<Category_Entity>g=metodosCrud.getCategory(category.getId());
            if(!g.isEmpty()){
                if(category.getDescription()!=null){
                    g.get().setDescription(category.getDescription());
                }
                if(category.getName()!=null){
                    g.get().setName(category.getName());
                }
                return metodosCrud.save(g.get());
            }
        }
        return category;
    }
    public boolean deletecategoria(int categoriaId){
        Boolean d=getCategory(categoriaId).map(category -> {
            metodosCrud.delete(category);
            return true;
        }).orElse(false);
        return d;
    }
}
