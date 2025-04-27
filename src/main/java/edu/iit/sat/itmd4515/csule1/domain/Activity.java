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
//import jakarta.persistence.JoinTable;
//import jakarta.persistence.ManyToMany;
//import jakarta.validation.constraints.NotBlank;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
///**
// *
// * @author chinmayi
// */
//@Entity
//public class Activity {
//
//    public Activity() {
//    }
//
//    public Activity(String name) {
//        this.name = name;
//    }
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @NotBlank(message = "Activity name is required")
//
//    private String name;
//
//    @ManyToMany(mappedBy = "activities")
//    @JoinTable(name="Children_Activities",
//            joinColumns = @JoinColumn(name="ACTIVITY_ID"),
//            inverseJoinColumns = @JoinColumn(name="CHILD_ID"))
//    private List<Child> children=new ArrayList<>();
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
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
//    public List<Child> getChildren() {
//        return children;
//    }
//
//    public void setChildren(List<Child> children) {
//        this.children = children;
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
//    @Override
//    public String toString() {
//        return "Activity{" + "id=" + id + ", name=" + name + '}';
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 29 * hash + Objects.hashCode(this.id);
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
//        final Activity other = (Activity) obj;
//
//        if (this.id == null || other.id == null) {
//            return false;
//        }
//
//        return Objects.equals(this.id, other.id);
//    }
//
//}
