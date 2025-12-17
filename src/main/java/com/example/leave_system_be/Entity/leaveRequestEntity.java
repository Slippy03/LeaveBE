package com.example.leave_system_be.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "leave_requests")
public class leaveRequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id ;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private usersEntity users;

    @ManyToOne
    @JoinColumn(name = "leave_type_id", nullable = false)
    private leaveTypeEntity leaveType;

    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    Date startDate;

    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    Date endDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private LeaveStatusEnum status = LeaveStatusEnum.PENDING;

    @Column(name = "reason")
    String reason;

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public LeaveStatusEnum getStatus() {
        return status;
    }

    public void setStatus(LeaveStatusEnum status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
