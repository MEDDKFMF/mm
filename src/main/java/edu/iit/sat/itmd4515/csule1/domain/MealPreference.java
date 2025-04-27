/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package edu.iit.sat.itmd4515.csule1.domain;

/**
 *
 * @author chinmayi
 *
 */
public enum MealPreference {

    /**
     *
     */
    STANDARD("Standard Meal"),

    /**
     *
     */
    VEGETARIAN("Vegetarian Meal"),

    /**
     *
     */
    VEGAN("Vegan Meal"),

    /**
     *
     */
    GLUTEN_FREE("Gluten-Free Meal"),

    /**
     *
     */
    LACTOSE_FREE("Lactose-Free Meal");
    
    private String label;
    
    private MealPreference(String label){
    
    this.label=label;
    }
    
    private String getlabel(){
    return label;
    }
}
