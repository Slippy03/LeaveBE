package com.example.leave_system_be.Service;

import com.example.leave_system_be.Entity.leaveTypeEntity;
import com.example.leave_system_be.Repository.leaveTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class leaveTypeService {
    @Autowired
    private leaveTypeRepository leaveTypeRepository;

    public leaveTypeEntity createLeaveType(leaveTypeEntity leaveTypeEntity){
        try {
            return leaveTypeRepository.save(leaveTypeEntity);
        }catch (Exception e){
            throw new RuntimeException("Error while saving leave type entity",e);
        }

    }
}
