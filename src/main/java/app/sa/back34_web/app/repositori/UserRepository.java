/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.sa.back34_web.app.repositori;

import app.sa.back34_web.app.model.User;
import app.sa.back34_web.app.repository.crud.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrador
 */
@Repository
public class UserRepository {
    @Autowired
    private UserCrudRepository userCrudRepository;
    
    public List<User> getAll(){
        return userCrudRepository.findAll();
    }
    
    public Optional<User> getUser(Integer id){
        return userCrudRepository.findById(id);
    }
    
    public boolean ExisteEmail(String email){
        Optional<User> usuario = userCrudRepository.findByEmail(email);
         
        return !usuario.isEmpty();
    }
    
    public Optional<User> autenticarUser(String email, String password){
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
    
    public User save(User user){
        return userCrudRepository.save(user);
    }
    
    public void update(User user){
        userCrudRepository.save(user);
    }
    
    public void delete(User user){
        userCrudRepository.delete(user);
    }
    
}
    

