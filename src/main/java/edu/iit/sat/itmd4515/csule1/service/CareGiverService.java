/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.csule1.service;

import edu.iit.sat.itmd4515.csule1.domain.CareGiver;
import jakarta.ejb.Stateless;
import jakarta.inject.Named;
import java.util.List;

/**
 *
 * @author chinmayi
 */
@Named
@Stateless
public class CareGiverService extends AbstractService<CareGiver> {

    /**
     *
     */
    public CareGiverService() {
        super(CareGiver.class);
    }

    /**
     *
     * @return
     */
    public List<CareGiver> readAll() {
        return super.readAll("CareGiver.findAll");
    }

    public CareGiver findByUsername(String username) {
       
        return em.createNamedQuery("CareGiver.findByUsername", CareGiver.class).setParameter("username", username).getSingleResult();
    }

}
