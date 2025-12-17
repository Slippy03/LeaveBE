package com.example.leave_system_be.Controller;


import com.example.leave_system_be.Entity.leaveBalanceEntity;
import com.example.leave_system_be.Entity.leaveRequestEntity;
import com.example.leave_system_be.Entity.leaveTypeEntity;
import com.example.leave_system_be.Entity.usersEntity;
import com.example.leave_system_be.Repository.leaveBalanceRepository;
import com.example.leave_system_be.Repository.leaveRequestRepository;
import com.example.leave_system_be.Repository.usersRepository;
import com.example.leave_system_be.Service.leaveBalanceService;
import com.example.leave_system_be.Service.leaveRequestService;
import com.example.leave_system_be.Service.leaveTypeService;
import com.example.leave_system_be.Service.usersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/all")
public class allController {
    @Autowired
    private usersService usersService;
    @Autowired
    private leaveTypeService leaveTypeService;
    @Autowired
    private leaveRequestService leaveRequestService;
    @Autowired
    private leaveBalanceService leaveBalanceService;
    @Autowired
    private usersRepository usersRepository;
    @Autowired
    private leaveRequestRepository leaveRequestRepository;
    @Autowired
    private leaveBalanceRepository leaveBalanceRepository;


    @PostMapping("/createUser")
    public ResponseEntity<usersEntity> createUser(@RequestBody usersEntity usersEntity) {
        return ResponseEntity.ok(usersService.createUser(usersEntity));
    }

    @GetMapping("/getUser")
    public List<usersEntity> getAllUser() {
        return usersRepository.findAll();
    }

    @PostMapping("/createLeaveType")
    public ResponseEntity<leaveTypeEntity> createLeaveType(@RequestBody leaveTypeEntity leaveTypeEntity) {
        return ResponseEntity.ok(leaveTypeService.createLeaveType(leaveTypeEntity));
    }

    @PostMapping("/createLeaveRequest")
    public ResponseEntity<leaveRequestEntity> createLeaveRequest(@RequestBody leaveRequestEntity leaveRequestEntity) {
        return ResponseEntity.ok(leaveRequestService.createLeaveRequest(leaveRequestEntity));
    }

    @GetMapping("/getLeaveRequest")
    public List<leaveRequestEntity> getAllRequest() {
        return leaveRequestRepository.findAll();
    }

    @PostMapping("/createLeaveBalance")
    public ResponseEntity<leaveBalanceEntity> createLeaveBalance(@RequestBody leaveBalanceEntity leaveBalanceEntity) {
        return ResponseEntity.ok(leaveBalanceService.createLeaveBalance(leaveBalanceEntity));
    }

    @GetMapping("/getLeaveBalance")
    public List<leaveBalanceEntity> getLeaveBalance() {
        return leaveBalanceRepository.findAll();
    }

    @PutMapping("/updateLeaveRequest/{id}")
    public ResponseEntity<leaveRequestEntity> updateLeaveRequest(
            @PathVariable Long id,
            @RequestBody leaveRequestEntity leaveRequestDetails
    ) {
        leaveRequestEntity leaveRequest = leaveRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("LeaveRequest not found with id: " + id));

        if (leaveRequestDetails.getUsers() != null) {
            leaveRequest.setUsers(leaveRequestDetails.getUsers());
        }

        if (leaveRequestDetails.getLeaveType() != null) {
            leaveRequest.setLeaveType(leaveRequestDetails.getLeaveType());
        }

        if (leaveRequestDetails.getStartDate() != null) {
            leaveRequest.setStartDate(leaveRequestDetails.getStartDate());
        }

        if (leaveRequestDetails.getEndDate() != null) {
            leaveRequest.setEndDate(leaveRequestDetails.getEndDate());
        }

        if (leaveRequestDetails.getStatus() != null) {
            leaveRequest.setStatus(leaveRequestDetails.getStatus());
        }

        if (leaveRequestDetails.getReason() != null) {
            leaveRequest.setReason(leaveRequestDetails.getReason());
        }

        return ResponseEntity.ok(leaveRequestRepository.save(leaveRequest));
    }


    @PutMapping("/updateLeaveBalance/{id}")
    public ResponseEntity<leaveBalanceEntity> updateLeaveBalance(
            @PathVariable Long id,
            @RequestBody leaveBalanceEntity leaveBalanceDetails) {

        leaveBalanceEntity leaveBalance = leaveBalanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("LeaveBalance not found with id: " + id));

        if (leaveBalanceDetails.getUsers() != null) {
            leaveBalance.setUsers(leaveBalanceDetails.getUsers());
        }

        if (leaveBalanceDetails.getLeaveType() != null) {
            leaveBalance.setLeaveType(leaveBalanceDetails.getLeaveType());
        }

        if (leaveBalanceDetails.getYear() != null) {
            leaveBalance.setYear(leaveBalanceDetails.getYear());
        }

        if (leaveBalanceDetails.getRemainingDays() != null) {
            leaveBalance.setRemainingDays(leaveBalanceDetails.getRemainingDays());
        }

        return ResponseEntity.ok(leaveBalanceRepository.save(leaveBalance));
    }
}
