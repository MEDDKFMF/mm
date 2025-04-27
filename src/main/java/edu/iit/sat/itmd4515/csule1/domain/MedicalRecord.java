/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.csule1.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.validation.constraints.NotBlank;
import java.util.Objects;

/**
 *
 * @author chinmayi
 */
@Entity
@NamedQuery(name="MedicalRecord.findAll",query="select m from MedicalRecord m")
public class MedicalRecord {

    /**
     *
     */
    public MedicalRecord() {
    }

    /**
     *
     * @param allegeries
     * @param medicalConditions
     */
    public MedicalRecord(String allegeries, String medicalConditions) {
        this.allegeries = allegeries;
        this.medicalConditions = medicalConditions;
    }
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //auto increment field
    private Long id;
    
   
    @NotBlank(message = "Allergy Information is required")
    private String allegeries;
    
    @NotBlank(message = "Medical conditions information is required")
    private String medicalConditions;

    /**
     *
     * @return
     */
    public String getAllegeries() {
        return allegeries;
    }

    /**
     *
     * @param allegeries
     */
    public void setAllegeries(String allegeries) {
        this.allegeries = allegeries;
    }

    /**
     *
     * @return
     */
    public String getMedicalConditions() {
        return medicalConditions;
    }

    /**
     *
     * @param medicalConditions
     */
    public void setMedicalConditions(String medicalConditions) {
        this.medicalConditions = medicalConditions;
    }

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "MedicalRecord{" + "id=" + id + ", allegeries=" + allegeries + ", medicalConditions=" + medicalConditions + '}';
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MedicalRecord other = (MedicalRecord) obj;
        
        if (this.id == null || other.id == null) {
            return false;
        }
        
        return Objects.equals(this.id, other.id);
    }

}
