package com.example.leave_system_be.Entity;


import jakarta.persistence.*;


@Entity
@Table(name = "leave_types")

public class leaveTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id ;

    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private LeaveTypeEnum leaveTypeEnum;

    @Column(name = "description")
    String description;


    @Column(name = "max_days")
    Integer maxDays;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LeaveTypeEnum getLeaveTypeEnum() {
        return leaveTypeEnum;
    }

    public void setLeaveTypeEnum(LeaveTypeEnum leaveTypeEnum) {
        this.leaveTypeEnum = leaveTypeEnum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Integer getMaxDays() {
        return maxDays;
    }

    public void setMaxDays(Integer maxDays) {
        this.maxDays = maxDays;
    }
}
