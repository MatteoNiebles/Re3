/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto3.Reto3.Ortesis;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Matteo Niebles
 */
@RestController
@RequestMapping("/api/Ortopedic")
@CrossOrigin(origins = "*",methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class Ortesis_Controller {
     @Autowired
    private Ortesis_Service servicio;
    @GetMapping("/all")
    public List<Ortesis_Entity> getOrtopedics(){
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Ortesis_Entity> getBike(@PathVariable("id") int bikeId) {
        return servicio.getOrtopedic(bikeId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Ortesis_Entity save(@RequestBody Ortesis_Entity ortopedic) {
        return servicio.save(ortopedic);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Ortesis_Entity update(@RequestBody Ortesis_Entity ortopedic) {
        return servicio.update(ortopedic);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int ortopedicId) {
        return servicio.deleteOrtopedic(ortopedicId);
    }
}
