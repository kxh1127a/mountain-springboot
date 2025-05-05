package com.example.mountain.controller;

import com.example.mountain.model.MountainCreateRequest;
import com.example.mountain.service.MountainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mountain")
public class MountainController {
    private final MountainService mountainService;

    @PostMapping("/new")
    public MountainCreateRequest setMountain(@RequestBody MountainCreateRequest request) {
        return mountainService.setMountain(request);
    }
}
