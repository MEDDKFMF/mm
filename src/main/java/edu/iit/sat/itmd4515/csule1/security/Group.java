/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.csule1.security;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author chinmayi
 */
@Entity
@Table(name= "SEC_GROUP")
@NamedQuery(name = "Group.findAll", query = "select g from Group g")
public class Group {
    
    @Id
    private String groupname;
    private String description;

    @Override
    public String toString() {
        return "Group{" + "groupname=" + groupname + ", description=" + description + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.groupname);
        return hash;
    }

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
        final Group other = (Group) obj;
        return Objects.equals(this.groupname, other.groupname);
    }
    
    
    @ManyToMany(mappedBy= "groups")
    private List<User> userMember = new ArrayList<>();

    /**
     * Get the value of userMember
     *
     * @return the value of userMember
     */
    public List<User> getUserMember() {
        return userMember;
    }

    /**
     * Set the value of userMember
     *
     * @param userMember new value of userMember
     */
    public void setUserMember(List<User> userMember) {
        this.userMember = userMember;
    }

    public Group() {
    }

    public Group(String groupname, String description) {
        this.groupname = groupname;
        this.description = description;
    }

    /**
     * Get the value of description
     *
     * @return the value of description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the value of description
     *
     * @param description new value of description
     */
    public void setDescription(String description) {
        this.description = description;
    }


    /**
     * Get the value of groupname
     *
     * @return the value of groupname
     */
    public String getGroupname() {
        return groupname;
    }

    /**
     * Set the value of groupname
     *
     * @param groupname new value of groupname
     */
    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

}
