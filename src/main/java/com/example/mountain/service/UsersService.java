package com.example.mountain.service;

import com.example.mountain.entity.Users;
import com.example.mountain.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;

    public Users getUsersInfo(Long id) {
        return usersRepository.findById(id).orElseThrow();
    }

}
