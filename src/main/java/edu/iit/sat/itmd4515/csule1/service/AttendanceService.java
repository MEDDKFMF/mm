/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.csule1.service;

import edu.iit.sat.itmd4515.csule1.domain.Attendance;
import edu.iit.sat.itmd4515.csule1.domain.Child;
import jakarta.ejb.Stateless;
import java.util.List;

/**
 *
 * @author chinmayi
 */
@Stateless
public class AttendanceService extends AbstractService<Attendance> {

    /**
     *
     */
    public AttendanceService() {
        super(Attendance.class);
    }

    /**
     *
     * @return
     */
    public List<Attendance> readAll(){
    return super.readAll("Attendance.findAll");
    }
    
    // ✅ Fetch attendance records using NamedQuery (JPA)

    /**
     *
     * @param child
     * @return
     */
    public List<Attendance> findByChild(Child child) {
        return   getEm()
                .createNamedQuery("Attendance.findByChild", Attendance.class)
                .setParameter("child", child)
                .getResultList();
    }

}
