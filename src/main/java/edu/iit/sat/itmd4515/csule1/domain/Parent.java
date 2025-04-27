/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.csule1.domain;

import edu.iit.sat.itmd4515.csule1.security.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author chinmayi
 */
@Entity
@NamedQuery(name="Parent.findAll", query="select p from Parent p")
@NamedQuery(name = "Parent.findByUsername", query = "select p from Parent p where p.user.username = :username")
public class Parent {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Parent name is required")
    private String name;

    @NotBlank(message = "Phone number is required")
    private String phone;

    @Email(message = "Email should be valid")
    private String email;

    @OneToMany(mappedBy = "parent")
    private List<Child> children=new ArrayList<>();
    
    @OneToOne
    @JoinColumn(name="USERNAME")
    private User user;

    /**
     * Get the value of user
     *
     * @return the value of user
     */
    public User getUser() {
        return user;
    }

    /**
     * Set the value of user
     *
     * @param user new value of user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     *
     */
    public Parent() {
    }

    /**
     *
     * @param name
     * @param phone
     * @param email
     */
    public Parent(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
    
    
    /**
     *
     * @return
     */
    public List<Child> getChildren() {
        return children;
    }

    /**
     *
     * @param children
     */
    public void setChildren(List<Child> children) {
        this.children = children;
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
     *
     * @return
     */
    public String getPhone() {
        return phone;
    }

    /**
     *
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
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
        return "Parent{" + "id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + '}';
    }
    
   // Helper Method to Add a Child

    /**
     *
     * @param child
     */
    public void addChild(Child child) {
        if (!children.contains(child)) {
            children.add(child);
            child.setParent(this); // Maintain bidirectional relation
        }
    }

    // Helper Method to Remove a Child

    /**
     *
     * @param child
     */
    public void removeChild(Child child) {
        if (children.contains(child)) {
            children.remove(child);
            child.setParent(null); // Remove parent reference in child
        }
    }
       
    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.id);
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
        final Parent other = (Parent) obj;
        
        if (this.id == null || other.id == null) {
            return false;
        }
      
        return Objects.equals(this.id, other.id);
    }
    
}
