package com.example.leave_system_be.Repository;

import com.example.leave_system_be.Entity.leaveRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface leaveRequestRepository extends JpaRepository<leaveRequestEntity, Long> {
}
