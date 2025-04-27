/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.csule1.service;

import edu.iit.sat.itmd4515.csule1.domain.Attendance;
import edu.iit.sat.itmd4515.csule1.domain.CareGiver;
import edu.iit.sat.itmd4515.csule1.domain.Child;
import edu.iit.sat.itmd4515.csule1.domain.Parent;
import jakarta.ejb.Stateless;
import jakarta.inject.Named;
import java.util.List;

/**
 *
 * @author chinmayi
 */
@Named
@Stateless
public class ParentService extends AbstractService<Parent> {

    /**
     *
     */
    public ParentService() {
        super(Parent.class);
    }

    /**
     *
     * @return
     */
    public List<Parent> readAll() {
        return super.readAll("Parent.findAll");
    }

    public Parent findByUsername(String username) {

        return em.createNamedQuery("Parent.findByUsername", Parent.class).setParameter("username", username).getSingleResult();
    }

    public void createChildForParent(Parent parent, Child child) {
        em.persist(child);

        Parent parentReference = em.getReference(Parent.class, parent.getId());

        parentReference.addChild(child);
        em.merge(parentReference);
    }

    public void editChildForParent(Parent p, Child c) {
        Child mngdChildRef = em.getReference(Child.class, c.getId());
        Parent mngdParentRef = em.getReference(Parent.class, p.getId());

        // update attributes of managed child entities
        mngdChildRef.setName(c.getName());
        mngdChildRef.setBirthDate(c.getBirthDate());
        mngdChildRef.setGender(c.getGender());
        mngdChildRef.setMealPreference(c.getMealPreference());

        // Step 3 - entity manager
        em.merge(mngdChildRef);

    }

    public void deleteChildForParent(Parent p, Child c) {

        Child managedChildRef = em.getReference(Child.class, c.getId());
        Parent managedParentRef = em.getReference(Parent.class, p.getId());
//        CareGiver managedCareGiverRef = em.getReference(CareGiver.class, cg.getId());

        //remove child from parent
        managedParentRef.removeChild(managedChildRef);
        
        //remove child from caregiver
//         managedCareGiverRef.removeChildFromCareGiver(managedChildRef);

       
        em.remove(managedChildRef);

    }

}
