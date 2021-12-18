/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.sa.back34_web.app.service;

import app.sa.back34_web.app.model.Vegetarian;
import app.sa.back34_web.app.repositori.VegetarianRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrador
 */
@Service
public class VegetarianService {
    
    @Autowired
    private VegetarianRepository vegetarianRepository;

    public List<Vegetarian> getAll() {
        return vegetarianRepository.getAll();
    }

   public Optional<Vegetarian>getProduct(String reference) {
        return vegetarianRepository.getProduct(reference);
    }

    public Vegetarian save(Vegetarian accesory) {
        if (accesory.getReference() == null) {
            return accesory;
        } else {
            return vegetarianRepository.create(accesory);
        }
    }

    public Vegetarian update(Vegetarian accesory) {

        if (accesory.getReference() != null) {
            Optional<Vegetarian> accesoryDb = vegetarianRepository.getProduct(accesory.getReference());
            if (!accesoryDb.isEmpty()) {
                
                if (accesory.getBrand()!= null) {
                    accesoryDb.get().setBrand(accesory.getBrand());
                }
                
                if (accesory.getCategory() != null) {
                    accesoryDb.get().setCategory(accesory.getCategory());
                }
                
                if (accesory.getDescription() != null) {
                    accesoryDb.get().setDescription(accesory.getDescription());
                }
                if (accesory.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(accesory.getPrice());
                }
                if (accesory.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(accesory.getQuantity());
                }
                if (accesory.getPhotography() != null) {
                    accesoryDb.get().setPhotography(accesory.getPhotography());
                }
                accesoryDb.get().setAvailability(accesory.isAvailability());
                vegetarianRepository.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return accesory;
            }
        } else {
            return accesory;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getProduct(reference).map(accesory -> {
            vegetarianRepository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}