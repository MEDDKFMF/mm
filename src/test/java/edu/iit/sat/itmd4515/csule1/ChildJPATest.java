/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.csule1;

import edu.iit.sat.itmd4515.csule1.domain.CareGiver;
import edu.iit.sat.itmd4515.csule1.domain.Child;
import edu.iit.sat.itmd4515.csule1.domain.Gender;
import edu.iit.sat.itmd4515.csule1.domain.MealPreference;
import edu.iit.sat.itmd4515.csule1.domain.MedicalRecord;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.time.LocalDate;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author chinmayi
 */
public class ChildJPATest {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction tx;

    /**
     *
     */
    @BeforeAll
    public static void beforeAll() {
        emf = Persistence.createEntityManagerFactory("itmd4515testPU");
    }

    /**
     *
     */
    @BeforeEach
    public void beforeEach() {
        em = emf.createEntityManager();
        tx = em.getTransaction();

        // Creating a test child entity to ensure consistent test data
        Child c = new Child("Aline Test Rayan", LocalDate.of(2022, 05, 21), Gender.FEMALE, MealPreference.GLUTEN_FREE);

        tx.begin();
        em.persist(c);
        tx.commit();

    }

    /**
     *
     */
    @Test
    public void createTest() {

        // create a record, then read the record back and assert that it was
        // succssfuly written to the database.  then clean up any test data
        Child c = new Child("Brian", LocalDate.of(2021, 12, 16), Gender.MALE, MealPreference.LACTOSE_FREE);
        tx.begin();
        em.persist(c);
        tx.commit();

        Child readChildBackFromDb = em.find(Child.class, c.getId());

        assertNotNull(readChildBackFromDb);
        assertTrue(readChildBackFromDb.getId() > 0);
        assertTrue(readChildBackFromDb.getMealPreference() == MealPreference.LACTOSE_FREE);

        // clean up my test method's test data, if I am not using beforeEach test data
        tx.begin();
        em.remove(c);
        tx.commit();

    }

    /**
     *
     */
    @Test
    public void readTest() {
        // Create and persist a new child entity
        Child c = new Child("Emma", LocalDate.of(2020, 8, 10), Gender.FEMALE, MealPreference.VEGETARIAN);
        tx.begin();
        em.persist(c);
        tx.commit();

        System.out.println("Created Child: " + c);

        // Retrieve the record from the database
        Child retrievedChild = em.find(Child.class, c.getId());

        // Check if the child was found in the database
        if (retrievedChild != null) {
            System.out.println("Child found in DB: " + retrievedChild);
            // Assertions to verify data correctness
            assertEquals("Emma", retrievedChild.getName());
            assertEquals(Gender.FEMALE, retrievedChild.getGender());
            assertEquals(MealPreference.VEGETARIAN, retrievedChild.getMealPreference());
        } else {
            System.out.println("Child NOT found in DB!");
        }

        // Assertions to verify the child was found in DB
        assertNotNull(retrievedChild, "Read operation failed: Child not found in DB.");

        // Clean up test data
        tx.begin();
        em.remove(retrievedChild);
        tx.commit();

        System.out.println("Cleanup: Child removed from database.");
    }

    /**
     *
     */
    @Test
    public void updateTest() {

        // Create a record, retrieve it from the database, and verify that it was successfully saved.
        Child c = new Child("Brian", LocalDate.of(2021, 12, 16), Gender.MALE, MealPreference.LACTOSE_FREE);
        tx.begin();
        em.persist(c);
        tx.commit();

        assertTrue(c.getId() > 0);
        assertTrue(c.getMealPreference() == MealPreference.LACTOSE_FREE);

        System.out.println("***** Before update: ****** " + c.toString());
        // Modify specific fields of the record, merge the changes using EntityManager,
        // retrieve the updated record from the database, and verify the updates were successful.
        //Update Name
        c.setName("Brian Updated");
        tx.begin();
        em.merge(c);
        tx.commit();

        //Update MealPreference from LACTOSE_FREE to VEGAN
        tx.begin();
        c.setMealPreference(MealPreference.VEGAN);
        tx.commit();

        // Retrieve the record from the database to verify its existence and accuracy.
        Child readBackFromDatabase = em.find(Child.class, c.getId());
        assertNotNull(readBackFromDatabase);
        assertEquals("Brian Updated", readBackFromDatabase.getName());
        assertEquals(MealPreference.VEGAN, readBackFromDatabase.getMealPreference());

        System.out.println("***** After update: ****** " + readBackFromDatabase.toString());

        // Remove test data created in this method to maintain a clean test environment, unless using beforeEach test data.
        tx.begin();
        em.remove(c);
        tx.commit();

    }

    /**
     *
     */
    @Test
    public void deleteTest() {

        // Create and persist a new child entity
        Child c = new Child("Dakota", LocalDate.of(2019, 3, 25), Gender.FEMALE, MealPreference.VEGAN);
        tx.begin();
        em.persist(c);
        tx.commit();

        System.out.println("Created Child for Deletion: " + c);

        // Ensure the record exists before deletion
        Child retrievedChild = em.find(Child.class, c.getId());
        assertNotNull(retrievedChild, "Delete operation failed: Child not found before deletion.");

        System.out.println("Found Child Before Deletion: " + retrievedChild);

        // Delete the record
        tx.begin();
        em.remove(retrievedChild);
        tx.commit();

        System.out.println("Child Deleted: " + c.getId());

        // Verify the record no longer exists
        Child deletedChild = em.find(Child.class, c.getId());
        assertNull(deletedChild, "Delete operation failed: Child still exists after deletion.");

    }

    //uniDirectional OnetoOne Child MedicalRecord Test
    //1. One Uni-directional relationship test case

    /**
     *
     */
    
    @Test
    public void uniDirectOnetoOneChildMedRecordTest() {
        // Create a MedicalRecord instance with sample allergies and medical conditions
        MedicalRecord medRec = new MedicalRecord("Pollen", "Asthma");
        // Create a Child instance with name, birth date, gender, and meal preference
        Child child = new Child("Nancy", LocalDate.of(2019, 3, 25), Gender.FEMALE, MealPreference.VEGAN);
       // Set the medical record for the child (Unidirectional relationship)
        child.setMedicalRecord(medRec);

        tx.begin();
        em.persist(medRec);
        em.persist(child);
        tx.commit();

        Child readChildBackFromDatabase = em.find(Child.class, child.getId());
        assertEquals("Pollen", readChildBackFromDatabase.getMedicalRecord().getAllegeries());
        assertEquals("Asthma", readChildBackFromDatabase.getMedicalRecord().getMedicalConditions());
        
        
    }

//    2. One Bi-directional relationship test case

    /**
     *
     */
    @Test
    public void biDirectionalManytoManyChildCareGiverTest() {
        CareGiver cg = new CareGiver("Lucas",6L);//owning relationship
        Child c = new Child("Steve", LocalDate.of(2017, 10, 14), Gender.MALE, MealPreference.STANDARD);//non owning relationship
        //Case:1 Manage relationship

        //Case:2 Manage relationship from non owning side
        //c.getCareGiver().add(cg);//Relation entry not made in database in caregiver_child table is empty
        //Case:3 Managing relationship only from the owning side and not from inverse side
        //cg.getChildren().add(c);
        //case:4 Managing both sides of the relationship and update DB from owning side i.e caregiver side
        // cg.getChildren().add(c);
        //  c.getCareGiver().add(cg);
        //case:5 Show case Helper Methods 
        cg.addChildToCareGiver(c);

        tx.begin();
        em.persist(cg);//owning relationship
        em.persist(c);//non owning relationship
        tx.commit();

        //Navigating the relationships
        System.out.println("Navigating Many to many from the owning side: " + cg.getChildren().toString());
        System.out.println("Navigating Many to many from the inverse side: " + c.getCareGiver().toString());

        CareGiver readCareGiverBackFromDatabase = em.find(CareGiver.class, cg.getId());
        Child readChildBackFromDatabase = em.find(Child.class, c.getId());
        assertTrue(readCareGiverBackFromDatabase.getChildren().size() == 1);
        assertTrue(readChildBackFromDatabase.getCareGiver().size() == 1);

        //to clean up data sequentially  in our case Lucas and Steve data
        tx.begin();
        //first unset relationships
        cg.removeChildFromCareGiver(c);
        //remove non owning entities
        em.remove(c);
        //remove owning entities
        em.remove(cg);
        tx.commit();

    }

    /**
     *
     */
    @AfterEach
    public void afterEach() {
        //         Retrieve the test child entity created in beforeEach()
        // verify it was successfully stored, 
        // and then remove any test data to maintain a clean state.
        Child c = em.createQuery("select c from Child c where c.name='Aline Test Rayan'", Child.class).getSingleResult();

        // Begin transaction to remove the entity
        tx.begin();
        em.remove(c);
        tx.commit();

        // Close EntityManager to free up resources
        em.close();

    }

    /**
     *
     */
    @AfterAll
    public static void afterAll() {
        emf.close();
    }

}
