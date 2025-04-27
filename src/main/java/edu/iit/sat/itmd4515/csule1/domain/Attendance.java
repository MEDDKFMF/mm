/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.csule1.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;
/**
 *
 * @author chinmayi
 */

@Entity
@Table(name = "ATTENDANCE")
@NamedQuery(name="Attendance.findAll", query="select a from Attendance a")
@NamedQuery(name = "Attendance.findByChild", query = "SELECT a FROM Attendance a WHERE a.child = :child")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Date is required")
    @Column(name = "ATTENDANCE_DATE", nullable = false)
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Status is required")
    private AttendanceStatus status;

    
    @ManyToOne//unidirectional
    @JoinColumn(name = "child_id") 
    private Child child;
     
    @ManyToOne//bidirectional
    @JoinColumn(name="caregiver_id")
    private CareGiver careGiver;

    /**
     * Get the value of child
     *
     * @return the value of child
     */
    public Child getChild() {
        return child;
    }

    /**
     * Set the value of child
     *
     * @param child new value of child
     */
    public void setChild(Child child) {
        this.child = child;
    }

    /**
     *
     * @param ch
     * @param cg
     */
    public void markAttendance(Child ch, CareGiver cg) {
        this.child = ch;
        this.careGiver = cg;
       // this.status=attStatus;
       
        if (!cg.getAttendanceRecords().contains(this)) {
            cg.getAttendanceRecords().add(this);
        }
    }
     
    /**
     *
     * @param attstatus
     */
    public void updateAttendanceStatus(AttendanceStatus attstatus) {
      
         this.status = attstatus;
    }

    
 

    /**
     * Get the value of careGiver
     *
     * @return the value of careGiver
     */
    public CareGiver getCareGiver() {
        return careGiver;
    }

    /**
     * Set the value of careGiver
     *
     * @param careGiver new value of careGiver
     */
    public void setCareGiver(CareGiver careGiver) {
        this.careGiver = careGiver;
    }

    /**
     *Default no args constructor for attendance entity
     */
    public Attendance() {}

    /**
     *
     * @param date
     * @param status
     */
    public Attendance(LocalDate date, AttendanceStatus status) {
        this.date = date;
        this.status = status;
       
    }

    /**
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     *
     * @param date
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     *
     * @return
     */
    public AttendanceStatus getStatus() {
        return status;
    }

    /**
     *
     * @param status
     */
    public void setStatus(AttendanceStatus status) {
        this.status = status;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Attendance that = (Attendance) obj;
        return Objects.equals(id, that.id);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Attendance{" + "id=" + id + ", date=" + date + ", status=" + status + ", careGiver=" + careGiver + '}';
    }

  
}

