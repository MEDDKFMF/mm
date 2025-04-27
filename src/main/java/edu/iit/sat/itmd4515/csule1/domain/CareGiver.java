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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author chinmayi
 */
@Entity
@NamedQuery(name="CareGiver.findAll", query="select cg from CareGiver cg")
@NamedQuery(name = "CareGiver.findByUsername", query = "select cg from CareGiver cg where cg.user.username = :username")
public class CareGiver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Caregiver name is required")
    private String name;
    
    @NotNull(message = "Years Of Experience Required")
    private Long experienceYears;
    
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
    public CareGiver() {
    }

    /**
     *
     * @param name
     * @param experienceYears
     */
    public CareGiver(String name, Long experienceYears) {
        this.name = name;
        this.experienceYears = experienceYears;
    }
    
    @OneToMany(mappedBy = "careGiver")
    private List<Attendance> attendanceRecords=new ArrayList<>();

    /**
     * Get the value of attendanceRecords
     *
     * @return the value of attendanceRecords
     */
    public List<Attendance> getAttendanceRecords() {
        return attendanceRecords;
    }

    /**
     * Set the value of attendanceRecords
     *
     * @param attendanceRecords new value of attendanceRecords
     */
    public void setAttendanceRecords(List<Attendance> attendanceRecords) {
        this.attendanceRecords = attendanceRecords;
    }


//adding management/helper methods

    /**
     *
     * @param c
     */
    public void addChildToCareGiver(Child c) {
        if (!this.children.contains(c)) {
            this.children.add(c);
        }
        if (!c.getCareGiver().contains(this)) {
            c.getCareGiver().add(this);
        }
    }
//adding management/helper methods

    /**
     *
     * @param c
     */
    public void removeChildFromCareGiver(Child c) {
        
       if(this.children.contains(c)){
        this.children.remove(c);
       }
       
        if(c.getCareGiver().contains(this)){
        c.getCareGiver().remove(this);}
    }

  

    /**
     * Get the value of experienceYears
     *
     * @return the value of experienceYears
     */
    public Long getExperienceYears() {
        return experienceYears;
    }

    /**
     * Set the value of experienceYears
     *
     * @param experienceYears new value of experienceYears
     */
    public void setExperienceYears(Long experienceYears) {
        this.experienceYears = experienceYears;
    }


//bidrectional    
// Relationship with Children (Many-to-Many)
    @ManyToMany
    @JoinTable(name = "CareGiver_Children",
            joinColumns = @JoinColumn(name = "CAREGIVER_ID"),
            inverseJoinColumns = @JoinColumn(name = "CHILD_ID"))
    private List<Child> children = new ArrayList<Child>();
    /**
     * Get the value of children
     *
     * @return the value of children
     */
    public List<Child> getChildren() {
        return children;
    }

    /**
     * Set the value of children
     *
     * @param children new value of children
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
        return "CareGiver{" + "id=" + id + ", name=" + name + ", experienceYears=" + experienceYears + ", children=" + children + '}';
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        final CareGiver other = (CareGiver) obj;

        if (this.id == null || other.id == null) {
            return false;
        }

        return Objects.equals(this.id, other.id);
    }

}
