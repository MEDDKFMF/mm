/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.csule1.web;

import edu.iit.sat.itmd4515.csule1.domain.Parent;
import edu.iit.sat.itmd4515.csule1.service.ParentService;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.logging.Logger;

/**
 *
 * @author chinmayi My code is based on Instructor's Example
 */
@Named
@RequestScoped
public class ParentWelcomeController {

    private static final Logger LOG = Logger.getLogger(ParentWelcomeController.class.getName());

    @Inject
    LoginController loginController;

    private Parent parent;

    @EJB
    private ParentService parentServ;

    @PostConstruct
    private void postConstruct() {
        LOG.info("ParentWelcomeController.postConstruct");
        parent = parentServ.findByUsername(loginController.getAuthenticatedUser());
        LOG.info("ParentWelcomeController.postConstruct: " + parent.toString());
    }

    //Refresh model using Utility method 
    public void refreshParentModel(){
     parent = parentServ.findByUsername(loginController.getAuthenticatedUser());
    }
    
    public ParentWelcomeController() {
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }
    
    


}
