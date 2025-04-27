/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.csule1.security;

import edu.iit.sat.itmd4515.csule1.service.AbstractService;
import jakarta.ejb.Stateless;
import java.util.List;

/**
 *
 * @author chinmayi
 */
@Stateless
public class UserService extends AbstractService<User>{

    public UserService() {
        super(User.class);
    }
    
    /**
     *
     * @return
     */
    public List<User> readAll(){
    return super.readAll("User.findAll");
    }
    
}
