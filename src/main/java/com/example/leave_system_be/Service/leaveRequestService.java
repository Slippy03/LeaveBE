package com.example.leave_system_be.Service;

import com.example.leave_system_be.Entity.leaveRequestEntity;
import com.example.leave_system_be.Repository.leaveRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class leaveRequestService {
    @Autowired
    private leaveRequestRepository leaveRequestRepository;

    public leaveRequestEntity createLeaveRequest(leaveRequestEntity leaveRequestEntity){
        try {
            return leaveRequestRepository.save(leaveRequestEntity);
        }catch (Exception e){
            throw new RuntimeException("Error while saving leave request entity",e);
        }

    }
}
