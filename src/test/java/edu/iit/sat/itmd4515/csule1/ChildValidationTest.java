/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.csule1;

import edu.iit.sat.itmd4515.csule1.domain.Child;
import edu.iit.sat.itmd4515.csule1.domain.Gender;
import edu.iit.sat.itmd4515.csule1.domain.MealPreference;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.time.LocalDate;
import java.util.Set;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author chinmayi
 */
public class ChildValidationTest {
  
    private static Validator validator;
    
    /**
     *
     */
    @BeforeAll
    public static void beforeAll(){
        ValidatorFactory factory=Validation.buildDefaultValidatorFactory();
        validator=factory.getValidator();
    }
    
    /**
     *
     */
    @BeforeEach
    public  void beforeEach(){
    }
     
    /**
     *
     */
    @Test
    public void childShouldValidateAndPass() {
        // Valid child data
        Child c = new Child("Aline Test Rayan", LocalDate.of(2022, 05, 21), Gender.FEMALE, MealPreference.GLUTEN_FREE);
        Set<ConstraintViolation<Child>> violations = validator.validate(c);
        System.out.println("Validating child: " + c);
        System.out.println("Validation violations: " + violations.size());
        assertEquals(0, violations.size());  // No validation errors expected
    }

    /**
     *
     */
    @Test
    public void blankNameShouldNotValidate() {
       // Blank Name should not be valid
        Child c = new Child("", LocalDate.of(2022, 05, 21), Gender.FEMALE, MealPreference.GLUTEN_FREE);
        Set<ConstraintViolation<Child>> violations = validator.validate(c);
        System.out.println("Validating child with blank name: " + c);
        System.out.println("Validation violations: " + violations.size());
        assertEquals(1, violations.size());
        System.out.println("Violation message: " + violations.iterator().next().getMessage());
        assertEquals("Name Required", violations.iterator().next().getMessage());
    }

    /**
     *
     */
    @Test
    public void nullBirthDateShouldNotValidate() {
        // Null birthDate should not be valid
        Child c = new Child("Sarah", null, Gender.FEMALE, MealPreference.GLUTEN_FREE);
        Set<ConstraintViolation<Child>> violations = validator.validate(c);
        System.out.println("Validating child with null birthDate: " + c);
        System.out.println("Validation violations: " + violations.size());
        assertEquals(1, violations.size());
        System.out.println("Violation message: " + violations.iterator().next().getMessage());
        assertEquals("BirthDate Required", violations.iterator().next().getMessage());
    }

    /**
     *
     */
    @Test
    public void invalidGenderShouldNotValidate() {
        // Invalid Gender (null in this case) should not be valid
        Child c = new Child("Seerang", LocalDate.of(2023, 05, 21), null, MealPreference.GLUTEN_FREE);
        Set<ConstraintViolation<Child>> violations = validator.validate(c);
        System.out.println("Validating child with null gender: " + c);
        System.out.println("Validation violations: " + violations.size());
        assertEquals(1, violations.size());
        System.out.println("Violation message: " + violations.iterator().next().getMessage());
        assertEquals("Gender Required", violations.iterator().next().getMessage());
    }
    
    /**
     *
     */
    @Test
    public void nullMealPreferenceShouldNotValidate() {
        // Null MealPreference should not be valid
        Child c = new Child("Test Name", LocalDate.of(2022, 05, 21), Gender.FEMALE, null);
        Set<ConstraintViolation<Child>> violations = validator.validate(c);
        System.out.println("Validating child with null meal preference: " + c);
        System.out.println("Validation violations: " + violations.size());
        assertEquals(1, violations.size());
        System.out.println("Violation message: " + violations.iterator().next().getMessage());
        assertEquals("MealPreference Required", violations.iterator().next().getMessage());
    }
    
    /* @Test
    public void invalidMealPreferenceShouldNotValidate() {
        // Invalid MealPreference, assuming an enum constraint, should not be valid
        Child c = new Child("Test Name", LocalDate.of(2022, 05, 21), Gender.FEMALE, MealPreference.valueOf("INVALID_MEAL"));
        Set<ConstraintViolation<Child>> violations = validator.validate(c);
        System.out.println("Validating child with invalid meal preference: " + c);
        System.out.println("Validation violations: " + violations.size());
        assertEquals(1, violations.size());
        System.out.println("Violation message: " + violations.iterator().next().getMessage());
        assertEquals("Invalid MealPreference", violations.iterator().next().getMessage());
    }*/

    /**
     *
     */


    @AfterEach
    public void afterEach() {
    }

    /**
     *
     */
    @AfterAll
    public static void afterAll() {
    }
}