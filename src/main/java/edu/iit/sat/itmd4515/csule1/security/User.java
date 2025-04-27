/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.csule1.security;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author chinmayi
 */ 

@Entity 
@Table(name="SEC_USER")
@EntityListeners(HashTheUserPasswordListener.class)
@NamedQuery(name = "User.findAll", query = "select u from User u")
public class User {
    
    @Id
    @NotBlank(message = "Please enter a username")
    private String username;
    @NotBlank(message = "Please enter a password")
    private String password;
    
    @ManyToMany
    @JoinTable(name = "SEC_USER_GROUPS",
            joinColumns = @JoinColumn(name = "USERNAME"),//owning side
            inverseJoinColumns = @JoinColumn(name = "GROUPNAME"))//inverse side
    private List<Group> groups=new ArrayList<>();
    
    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
   
    //As its a bidirectional , we add helper method
    
     public void addToGroup(Group g){
        this.groups.add(g);
        
            if (!g.getUserMember().contains(this)) {
                 g.getUserMember().add(this);
            }
    }
    
    public void removeFromGroup(Group g){
        this.groups.remove(g);
        
         if(g.getUserMember().contains(this)){
                g.getUserMember().remove(this);
         }
    }
    
    @Override
    public String toString() {
        return "User{" + "username=" + username + ", groups=" + groups + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.username);
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
        final User other = (User) obj;
        return Objects.equals(this.username, other.username);
    }

  

    /**
     * Get the value of groups
     *
     * @return the value of groups
     */
    public List<Group> getGroups() {
        return groups;
    }

    /**
     * Set the value of groups
     *
     * @param groups new value of groups
     */
    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

 
    

    /**
     * Get the value of password
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password) {
        this.password = password;
    }


    /**
     * Get the value of username
     *
     * @return the value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the value of username
     *
     * @param username new value of username
     */
    public void setUsername(String username) {
        this.username = username;
    }

}
