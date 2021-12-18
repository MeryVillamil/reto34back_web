/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package app.sa.back34_web.app.repository.crud;

import app.sa.back34_web.app.model.Vegetarian;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Administrador
 */
public interface VegetarianCrudRepository extends MongoRepository<Vegetarian, String>{
    
}
