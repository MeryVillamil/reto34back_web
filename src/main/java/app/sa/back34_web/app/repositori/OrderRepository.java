/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.sa.back34_web.app.repositori;

import app.sa.back34_web.app.model.Order;
import app.sa.back34_web.app.repository.crud.OrderCrudRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrador
 */
@Repository
public class OrderRepository {
    @Autowired
    private OrderCrudRepository orderCrudRepository;
    
    public List<Order> getAll(){
        return orderCrudRepository.findAll();
    }
    
    public Optional<Order> getOrder(Integer id){
        return orderCrudRepository.findById(id);
    }
    
    public Order create(Order order){
        return orderCrudRepository.save(order);
    }
    
    public void update(Order order){
       orderCrudRepository.save(order);
    }
    
    public void delete(Order order){
        orderCrudRepository.delete(order);
    }
    
    public List<Order> getZone(String zone){
        return orderCrudRepository.findBySalesManZone(zone);
    }

    public List<Order> getBySalesManId(Integer id){
        return orderCrudRepository.findBySalesManId(id);
    }

    public List<Order> getBySalesManIdAndStatus(Integer id, String status){
        return orderCrudRepository.findBySalesManIdAndStatus(id, status);
    }

    public List<Order> getByRegisterDayAndSalesManId(String registerDay, Integer id){
        try {
            return orderCrudRepository.findByRegisterDayAndSalesManId(new SimpleDateFormat("yyyy-MM-dd").parse(registerDay), id);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }


}