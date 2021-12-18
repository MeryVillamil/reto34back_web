/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.sa.back34_web.app.repositori;

import app.sa.back34_web.app.model.Vegetarian;
import app.sa.back34_web.app.repository.crud.VegetarianCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrador
 */
@Repository
public class VegetarianRepository {
    
    @Autowired
    private VegetarianCrudRepository vegetarianCrudRepository;

    public List<Vegetarian> getAll() {
        return vegetarianCrudRepository.findAll();
    }

    public Optional<Vegetarian> getProduct(String reference) {
        return vegetarianCrudRepository.findById(reference);
    }
    public Vegetarian create(Vegetarian vegetarian) {
        return vegetarianCrudRepository.save(vegetarian);
    }

    public void update(Vegetarian vegetarian) {
        vegetarianCrudRepository.save(vegetarian);
    }
    
    public void delete(Vegetarian vegetarian) {
        vegetarianCrudRepository.delete(vegetarian);
    }
    
}