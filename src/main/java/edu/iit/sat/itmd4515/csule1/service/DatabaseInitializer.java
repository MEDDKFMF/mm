/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.csule1.service;

import edu.iit.sat.itmd4515.csule1.domain.Attendance;
import edu.iit.sat.itmd4515.csule1.domain.AttendanceStatus;
import edu.iit.sat.itmd4515.csule1.domain.CareGiver;
import edu.iit.sat.itmd4515.csule1.domain.Child;
import edu.iit.sat.itmd4515.csule1.domain.Gender;
import edu.iit.sat.itmd4515.csule1.domain.MealPreference;
import edu.iit.sat.itmd4515.csule1.domain.MedicalRecord;
import edu.iit.sat.itmd4515.csule1.domain.Parent;
import edu.iit.sat.itmd4515.csule1.security.Group;
import edu.iit.sat.itmd4515.csule1.security.GroupService;
import edu.iit.sat.itmd4515.csule1.security.User;
import edu.iit.sat.itmd4515.csule1.security.UserService;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author chinmayi
 */
@Startup
@Singleton
public class DatabaseInitializer {

    private static final Logger LOG = Logger.getLogger(DatabaseInitializer.class.getName());
    
    @EJB private MedicalRecordService medicalRecordService;
    @EJB private ChildService childService;
    @EJB private ParentService parentService;
    @EJB private CareGiverService careGiverService;
    @EJB private AttendanceService attendanceService;
    
    @EJB 
    GroupService groupServc;
    @EJB 
    UserService userServc;
    
    /**
     *
     */
    public DatabaseInitializer() {
       
    }
    
    //lifecycle of ejb
    @PostConstruct
    private void postConstruct() {
        LOG.info("Entering into DatabaseInitializer postConstruct() method");
        
        
        //******* creating security groups *****
      
        
        Group customerGroup = new Group("CUST_GROUP", "Represents a group of customers. This group is part of a mock security system, not managed directly by this application.");
        Group employeeGroup = new Group("EMP_GROUP", "Represents internal staff members. This group is part of a mock security system, not managed directly by this application.");
        Group adminGroup = new Group("ADMIN_GROUP", "Represents system administrators. These users are super users and have broader system access.");

        groupServc.create(adminGroup);
        groupServc.create(customerGroup);
        groupServc.create(employeeGroup);
        
        User admin = new User("admin", "admin");
        admin.addToGroup(adminGroup);
        userServc.create(admin);
                
        User careGiver1 = new User("silvi", "silvi");
        careGiver1.addToGroup(employeeGroup);
        careGiver1.addToGroup(adminGroup);
        userServc.create(careGiver1);
        
        User careGiver2 = new User("anna", "anna");
        careGiver2.addToGroup(employeeGroup);
        careGiver2.addToGroup(customerGroup);
        userServc.create(careGiver2);
        
        User careGiver3 = new User("dimple", "dimple");
        careGiver3.addToGroup(employeeGroup);
        userServc.create(careGiver3);
        
        User parent1 = new User("steve", "steve");
        parent1.addToGroup(customerGroup);
        userServc.create(parent1);
        
        User parent2 = new User("christin", "christin");
        parent2.addToGroup(customerGroup);
        userServc.create(parent2);
        
        User parent3 = new User("levis", "levis");
        parent3.addToGroup(customerGroup);
        userServc.create(parent3);
        
        
        

        //******* creating security groups ends*****
          
          
        MedicalRecord medicalRecord1 = new MedicalRecord("Pollen", "Asthma");
        MedicalRecord medicalRecord2 = new MedicalRecord("Aspirin", "Eczema");
        MedicalRecord medicalRecord3 = new MedicalRecord("Mold", "ADHD");
        MedicalRecord medicalRecord4 = new MedicalRecord("Seafood", "Asthma");
       
        medicalRecordService.create(medicalRecord1);
        medicalRecordService.create(medicalRecord2);
        medicalRecordService.create(medicalRecord3);
        medicalRecordService.create(medicalRecord4);
        
        Child childAline = new Child("Aline", LocalDate.of(2019, 11, 5), Gender.FEMALE, MealPreference.GLUTEN_FREE);
        childAline.setMedicalRecord(medicalRecord1);
        Child childRayan = new Child("Rayan", LocalDate.of(2017, 5, 21), Gender.MALE, MealPreference.LACTOSE_FREE);
        childRayan.setMedicalRecord(medicalRecord2);
        Child childSara = new Child("Sara", LocalDate.of(2020, 10, 19), Gender.FEMALE, MealPreference.STANDARD);
        childSara.setMedicalRecord(medicalRecord3);
        Child childHenry = new Child("Henry", LocalDate.of(2018, 12, 3), Gender.MALE, MealPreference.VEGAN);
        childHenry.setMedicalRecord(medicalRecord4);
         
        childService.create(childAline);
        childService.create(childRayan);
        childService.create(childSara);
        childService.create(childHenry);
         
        Parent parentSteve = new Parent("Steve", "312456894", "steve91@gmail.com");
        Parent parentChristin = new Parent("Christin", "5125689447", "christ11@gmail.com");
        Parent parentLevis = new Parent("Levis", "7159689447", "lev19@gmail.com");
        Parent parentAnna = new Parent("Anna", "8859689447", "anna98@gmail.com");
       
        //add Anna
        parentAnna.setUser(careGiver2);
         parentAnna.addChild(childHenry);
        //add to steve
        parentSteve.addChild(childAline);
        parentSteve.setUser(parent1);
        
        //add to christin
        parentChristin.addChild(childSara);
        parentChristin.addChild(childHenry);
        parentChristin.setUser(parent2);
        
         //add to levis
        parentLevis.addChild(childRayan);
        parentLevis.setUser(parent3);
        
        
        parentService.create(parentSteve);
        parentService.create(parentChristin);
        parentService.create(parentLevis);
        parentService.create(parentAnna);
        
         
         
        CareGiver careGiverSilvi = new CareGiver("Silvi", 5L);
        careGiverSilvi.addChildToCareGiver(childAline);
        careGiverSilvi.setUser(careGiver1);// set silvi username to caregiver silvi
         
        CareGiver careGiverAnna = new CareGiver("Anna", 6L);
        careGiverAnna.addChildToCareGiver(childRayan);
        careGiverAnna.addChildToCareGiver(childSara);
        careGiverAnna.setUser(careGiver2);
         
        CareGiver careGiverDimple = new CareGiver("Dimple", 9L);
        careGiverDimple.addChildToCareGiver(childHenry);
        careGiverDimple.setUser(careGiver3);
         
        careGiverService.create(careGiverSilvi);
        careGiverService.create(careGiverAnna);
        careGiverService.create(careGiverDimple);
         
        Attendance attendance1 = new Attendance(LocalDate.of(2025, 3, 12), AttendanceStatus.PRESENT);
        attendance1.markAttendance(childAline, careGiverSilvi);
       
        Attendance attendance2 = new Attendance(LocalDate.of(2025, 3, 12), AttendanceStatus.ABSENT);
        attendance2.markAttendance(childRayan, careGiverAnna);
       
        Attendance attendance3 = new Attendance(LocalDate.of(2025, 3, 13), AttendanceStatus.PRESENT);
        attendance3.markAttendance(childAline, careGiverDimple);
         
        Attendance attendance4 = new Attendance(LocalDate.of(2025, 3, 13), AttendanceStatus.LATE);    
        attendance4.markAttendance(childRayan, careGiverDimple);
        
        Attendance attendance5 = new Attendance(LocalDate.of(2025, 3, 13), AttendanceStatus.PRESENT);    
        attendance5.markAttendance(childHenry, careGiverDimple);
        
        Attendance attendance6 = new Attendance(LocalDate.of(2025, 3, 15), AttendanceStatus.ABSENT);    
        attendance6.markAttendance(childSara, careGiverAnna);
         
        attendanceService.create(attendance1);
        attendanceService.create(attendance2);
        attendanceService.create(attendance3);
        attendanceService.create(attendance4);
        attendanceService.create(attendance5);
        attendanceService.create(attendance6);
         
         LOG.info("Sample Data Representation and Entity Relationships Output");
         
         Iterator<Child> childIterator = childService.readAll().iterator();
       
            while (childIterator.hasNext()) {
                
            Child ch = childIterator.next();

            LOG.info("--------------------*****************************-------------------------------------------");
            LOG.info(ch.toString());

            LOG.info("\n\t Unidirectional relationship to MedicalRecord: " + ch.getMedicalRecord().toString());

            // Bidirectional Relationship with caregiver
            LOG.info("\n\t Bidirectional relationship to  caregiver:");
                for(CareGiver cg: ch.getCareGiver()){
                    LOG.info("\t\t" + cg.toString());
                }
            
            // Unidirectional Relationship with Attendance 
            LOG.info("\n\t Unidirectional Relationship with Attendance :");
            List<Attendance> attendanceRecords = attendanceService.findByChild(ch);
            for (Attendance attendance : attendanceRecords) {
                 LOG.info("Date: " + attendance.getDate() +
                       " | Status: " + attendance.getStatus());}
            
             // Bidirectional Relationship with parent
            LOG.info("\n\t Bidirectional relationship to  Parent: " +  ch.getParent().getName());
            
            LOG.info("--------------------*****************************------------------------------------------");
           
            }
           
    }
            

}