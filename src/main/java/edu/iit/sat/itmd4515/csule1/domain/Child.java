/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.csule1.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author chinmayi
 * My code is based on Instructor's Example
 */
@Entity
@Table(name = "CHILD")
@NamedQuery(name="Child.findAll", query="select c from Child c")
public class Child {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto increment field
    private Long id;

 
    @NotBlank(message = "Name Required") // Ensures the name is not blank or empty
    @Column(name = "CHILD_NAME", length = 4000, nullable = false)
    private String name;
    
    @PastOrPresent(message = "BirthDate should be in the past or present") // Validates that the birthDate is not a future date
    @NotNull(message = "BirthDate Required")
    private LocalDate birthDate;
    
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Gender Required")
    private Gender gender;
    
    @Enumerated(EnumType.STRING)
    @NotNull(message = "MealPreference Required")
    private MealPreference mealPreference;
 
    //Child to parent (Many to One)
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;
    
    //Many children have many care giver
    //bidrectional
    @ManyToMany(mappedBy = "children")
    @JoinColumn(name = "caregiver_id")
    private List<CareGiver> careGiver=new ArrayList<>();
  
    
    //one to one unidirectional relationship between child and medical record
    @OneToOne
    @JoinColumn(name = "medical_record_id")
    private MedicalRecord medicalRecord;
  
    /**
     * Get the value of careGiver
     *
     * @return the value of careGiver
     */
    public List<CareGiver> getCareGiver() {
        return careGiver;
    }

    /**
     * Set the value of careGiver
     *
     * @param careGiver new value of careGiver
     */
    public void setCareGiver(List<CareGiver> careGiver) {
        this.careGiver = careGiver;
    }


   
    /**
     * Get the value of parent
     *
     * @return the value of parent
     */
    public Parent getParent() {
        return parent;
    }

    /**
     * Set the value of parent
     *
     * @param parent new value of parent
     */
    public void setParent(Parent parent) {
        this.parent = parent;
    }

    /**
     *
     * @return
     */
    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    /**
     *
     * @param medicalRecord
     */
    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Child{" + "id=" + id + ", Name=" + name + ", birthDate=" + birthDate + ", gender=" + gender + ", mealPreference=" + mealPreference + ", medicalRecord=" + medicalRecord + '}';
    }

    /**
     * Get the value of mealPreference
     *
     * @return the value of mealPreference
     */
    public MealPreference getMealPreference() {
        return mealPreference;
    }

    /**
     * Set the value of mealPreference
     *
     * @param mealPreference new value of mealPreference
     */
    public void setMealPreference(MealPreference mealPreference) {
        this.mealPreference = mealPreference;
    }

    /**
     *
     */
    public Child(){}
    
    /**
     *
     * @param Name
     * @param birthDate
     * @param gender
     * @param mealPreference
     */
    public Child(String Name, LocalDate birthDate, Gender gender, MealPreference mealPreference) {
        this.name = Name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.mealPreference = mealPreference;
    }

    /**
     * Get the value of gender
     *
     * @return the value of gender
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Set the value of gender
     *
     * @param gender new value of gender
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * Get the value of birthDate
     *
     * @return the value of birthDate
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Set the value of birthDate
     *
     * @param birthDate new value of birthDate
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
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
    public int hashCode() {
        int hash = 7;
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
        final Child other = (Child) obj;
      
        if (this.id == null || other.id == null) {
            return false;
        }

        return Objects.equals(this.id, other.id);
    }
    

}
