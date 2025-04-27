/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.csule1.web;

import edu.iit.sat.itmd4515.csule1.domain.CareGiver;
import edu.iit.sat.itmd4515.csule1.domain.Child;
import edu.iit.sat.itmd4515.csule1.domain.Gender;
import edu.iit.sat.itmd4515.csule1.domain.MealPreference;
import edu.iit.sat.itmd4515.csule1.service.ChildService;
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
public class ParentChildController {

    @EJB
    ChildService childSvc;
    @EJB
    ParentService parentSvc;
   
    @Inject
    ParentWelcomeController pwc;

    private static final Logger LOG = Logger.getLogger(ParentChildController.class.getName());
    private Child child;
    
   

    /**
     *
     */
    public ParentChildController() {
    }

    @PostConstruct
    private void postConstruct() {
        LOG.info("In child controller **** post constructor() ****");

        child = new Child();
       
    }

    //JSF helper method
    /**
     *
     * @return
     */
    public MealPreference[] readAllMealPref() {
        return MealPreference.values();
    }

    //JSF helper method
    /**
     *
     * @return
     */
    public Gender[] readAllGender() {
        return Gender.values();
    }

    public String dummyAction(Child c) {

        LOG.info("Inside method dummyAction  " + c.toString());
        return "/parent/welcome.xhtml";

    }

    // Follows a 1-2-3 or MVC-style action method structure:
    // Step 1: Respond to the user's action (e.g., button click) and initialize or prepare the model.
    //         This step is focused on setting up the model, not executing the business logic.
    // Step 2: Navigate the user to the appropriate view, passing along the model if needed.
    // Step 3: Handle the user's interaction with the view, processing any updates to the model.
    public String displayCreateChildPage() {
        //no model to set
        LOG.info("Inside displayCreateChildPage");

        //direct user to create page
        return "/parent/createChild.xhtml";
    }

    public String displayReadChildPage(Child c) {
        LOG.info("Inside displayReadChildPage  " + c.toString());
        //setting the model
        this.child = c;

        // direct user to appropriate view
        return "/parent/readChild.xhtml";
    }

    public String displayEditChildPage(Child c) {
        LOG.info("Inside displayEditChildPage " + c.toString());
        //setting the model
        this.child = c;
        // direct user to appropriate edit page
        return "/parent/editChild.xhtml";
    }

    public String displayDeleteChildPage(Child c) {
        LOG.info("Inside displayDeleteChildPage  " + c.toString());
        //setting the model
        this.child = c;
        // direct user to appropriate confirm deletion page
        return "/parent/deleteChild.xhtml";
    }

    //Process the user action submitted from the view above
    // action methods
    /**
     *
     * @return
     */
    public String registerNewChild() {
        LOG.info("In child Controller **** registerNewChild() **** " + child.toString() + " BEFORE the service call made to create");
//       childSvc.create(child);
        ///to save new child to database
        parentSvc.createChildForParent(pwc.getParent(), child);
        LOG.info("In child Controller ****  registerNewChild() **** " + child.toString() + " AFTER the service call made to create");
        //  return "/parent/welcome.xhtml?faces-redirect=true";

        pwc.refreshParentModel();
        return "/parent/welcome.xhtml";
    
}
    
   public String deleteChild(){
        LOG.info("Inside delete Child  method ");
        
       
      parentSvc.deleteChildForParent(pwc.getParent(), child);
        
        pwc.refreshParentModel();
        return "/parent/welcome.xhtml";
    }
   
      public String editChild(){
        LOG.info("Inside delete Child  method ");
        
       
      
        parentSvc.editChildForParent(pwc.getParent(), child);
        pwc.refreshParentModel();
        return "/parent/welcome.xhtml";
    }
   
/**
 * Get the value of child
 *
 * @return the value of child
 */
public Child getChild() {
        return child;
    }

    /**
     * Set the value of child
     *
     * @param child new value of child
     */
    public void setChild(Child child) {
        this.child = child;
    }
}
