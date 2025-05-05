package com.example.mountain.service;

import com.example.mountain.entity.Mountain;
import com.example.mountain.model.MountainCreateRequest;
import com.example.mountain.repository.MountainRepository;
import org.springframework.stereotype.Service;

@Service
public class MountainService {
    private final MountainRepository mountainRepository;

    public MountainService(MountainRepository mountainRepository) {
        this.mountainRepository = mountainRepository;
    }


    public MountainCreateRequest setMountain(MountainCreateRequest request) {
        Mountain mountain = new Mountain();
        mountain.setName(request.getName());
        mountainRepository.save(mountain);

        request.setId(mountain.getId());
        return request;
    }
}
