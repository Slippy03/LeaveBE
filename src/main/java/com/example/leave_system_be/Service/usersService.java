package com.example.leave_system_be.Service;

import com.example.leave_system_be.Entity.usersEntity;
import com.example.leave_system_be.Repository.usersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class usersService {
    @Autowired
    private usersRepository usersRepository;



    public usersEntity createUser(usersEntity usersEntity){
        try {
        return usersRepository.save(usersEntity);
        }catch (Exception e){
            throw new RuntimeException("Error while saving user entity",e);
        }

    }
}
