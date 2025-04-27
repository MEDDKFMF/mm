/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


//package edu.iit.sat.itmd4515.csule1.domain;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.validation.constraints.FutureOrPresent;
//import jakarta.validation.constraints.NotBlank;
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.util.Objects;
//
///**
// *
// * @author chinmayi
// */
//@Entity
//public class Appointment {
//
//    public Appointment() {
//    }
//
//    public Appointment(LocalDate date, LocalTime time, String purpose) {
//        this.date = date;
//        this.time = time;
//        this.purpose = purpose;
//     
//    }
//    
//    
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    
//    @FutureOrPresent
//    private LocalDate date;
//
//    private LocalTime time;
//    
//    @NotBlank(message = "Purpose of the appointment required")
//     private String purpose;
//    
//    
//    //bidrectional
//    @ManyToOne
//    @JoinColumn(name = "parent_id")
//    private Parent parent;
//
//    //unidirectional(many appointment belong to one child)
//    @ManyToOne
//    @JoinColumn(name = "child_id")
//    private Child child;
//
//    //bidrectional
//    @ManyToOne
//    private CareGiver careGiver;
//
//    /**
//     * Get the value of careGiver
//     *
//     * @return the value of careGiver
//     */
//    public CareGiver getCareGiver() {
//        return careGiver;
//    }
//
//    /**
//     * Set the value of careGiver
//     *
//     * @param careGiver new value of careGiver
//     */
//    public void setCareGiver(CareGiver careGiver) {
//        this.careGiver = careGiver;
//    }
//
//    
//    
//    /**
//     * Get the value of parent
//     *
//     * @return the value of parent
//     */
//    public Parent getParent() {
//        return parent;
//    }
//  
//    /**
//     * Get the value of child
//     *
//     * @return the value of child
//     */
//    public Child getChild() {
//        return child;
//    }
//
//    /**
//     * Set the value of child
//     *
//     * @param child new value of child
//     */
//    public void setChild(Child child) {
//        this.child = child;
//    }
//
//
//    /**
//     * Set the value of parent
//     *
//     * @param parent new value of parent
//     */
//    public void setParent(Parent parent) {
//        this.parent = parent;
//    }
//
//
//  
//
//    public String getPurpose() {
//        return purpose;
//    }
//
//    public void setPurpose(String purpose) {
//        this.purpose = purpose;
//    }
//
//    @Override
//    public String toString() {
//        return "Appointment{" + "id=" + id + ", date=" + date + ", time=" + time + ", purpose=" + purpose + ", parent=" + parent + ", child=" + child + ", careGiver=" + careGiver + '}';
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 3;
//        hash = 67 * hash + Objects.hashCode(this.id);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Appointment other = (Appointment) obj;
//        
//        if (this.id == null || other.id == null) {
//            return false;
//        } 
//        return Objects.equals(this.id, other.id);
//    }
//    
//
//    /**
//     * Get the value of time
//     *
//     * @return the value of time
//     */
//    public LocalTime getTime() {
//        return time;
//    }
//
//    /**
//     * Set the value of time
//     *
//     * @param time new value of time
//     */
//    public void setTime(LocalTime time) {
//        this.time = time;
//    }
//
//    /**
//     * Get the value of date
//     *
//     * @return the value of date
//     */
//    public LocalDate getDate() {
//        return date;
//    }
//
//    /**
//     * Set the value of date
//     *
//     * @param date new value of date
//     */
//    public void setDate(LocalDate date) {
//        this.date = date;
//    }
//
//
//    /**
//     * Get the value of id
//     *
//     * @return the value of id
//     */
//    public Long getId() {
//        return id;
//    }
//
//    /**
//     * Set the value of id
//     *
//     * @param id new value of id
//     */
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//}