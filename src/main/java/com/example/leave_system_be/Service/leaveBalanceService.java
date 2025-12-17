package com.example.leave_system_be.Service;

import com.example.leave_system_be.Entity.leaveBalanceEntity;
import com.example.leave_system_be.Repository.leaveBalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class leaveBalanceService {
    @Autowired
    private leaveBalanceRepository leaveBalanceRepository;

    public leaveBalanceEntity createLeaveBalance(leaveBalanceEntity leaveBalanceEntity){
        try {
            return leaveBalanceRepository.save(leaveBalanceEntity);
        }catch (Exception e){
            throw new RuntimeException("Error while saving leave request entity",e);
        }

    }
}
