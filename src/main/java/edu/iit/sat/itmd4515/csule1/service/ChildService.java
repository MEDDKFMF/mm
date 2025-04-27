/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.csule1.service;

import edu.iit.sat.itmd4515.csule1.domain.Child;
import jakarta.ejb.Stateless;
import jakarta.inject.Named;
import java.util.List;

/**
 *
 * @author chinmayi
 */
@Named
@Stateless
public class ChildService extends AbstractService<Child> {

    /**
     *
     */
    public ChildService() {
        super(Child.class);
    }

    /**
     *
     * @return
     */
    public List<Child> readAll(){
    return super.readAll("Child.findAll");
    }
    
    
    
}
