/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.csule1.service;

import edu.iit.sat.itmd4515.csule1.domain.MedicalRecord;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author chinmayi
 */
@Stateless
public class MedicalRecordService {

    @PersistenceContext(name = "itmd4515PU")
    private EntityManager em;
    
    /**
     *
     */
    public MedicalRecordService() {
    }
    
    /**
     *
     * @param m
     */
    public void create(MedicalRecord m){
        em.persist(m);
    }

    /**
     *
     * @param id
     * @return
     */
    public MedicalRecord read(Long id){
    return em.find(MedicalRecord.class, id);
    }
    
    /**
     *
     * @param m
     */
    public void update(MedicalRecord m){
    em.merge(m);
    }
    
    /**
     *
     * @param m
     */
    public void delete(MedicalRecord m){
    em.remove(m);
    }
    
    /**
     *
     * @return
     */
    public List<MedicalRecord> readAll(){
    
        return em.createNamedQuery("MedicalRecord.findAll", MedicalRecord.class).getResultList();
   
    }
    

}
