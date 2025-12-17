package com.example.leave_system_be.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "leave_balances")
public class leaveBalanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private usersEntity users;

    @ManyToOne
    @JoinColumn(name = "leave_type_id", nullable = false)
    private leaveTypeEntity leaveType;

    @Column(name="year")
    Integer year;

    @Column(name="remaining_days")
    Integer remainingDays;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public usersEntity getUsers() {
        return users;
    }

    public void setUsers(usersEntity users) {
        this.users = users;
    }

    public leaveTypeEntity getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(leaveTypeEntity leaveType) {
        this.leaveType = leaveType;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getRemainingDays() {
        return remainingDays;
    }

    public void setRemainingDays(Integer remainingDays) {
        this.remainingDays = remainingDays;
    }
}
