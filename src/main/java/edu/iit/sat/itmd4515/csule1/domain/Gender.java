/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package edu.iit.sat.itmd4515.csule1.domain;

/**
 *
 * @author chinmayi
 */
public enum Gender {

    /**
     *
     */
    MALE("Male"),

    /**
     *
     */
    FEMALE("Female"),

    /**
     *
     */
    NON_BINARY("Non Binary"),

    /**
     *
     */
    OTHER("Others");
   
    private String label;
    
    private Gender(String label){
    
    this.label=label;
    }
    
    public String getLabel(){
        return label;
    }
}
