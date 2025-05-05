package com.example.mountain.controller;

import com.example.mountain.model.MountainCreateRequest;
import com.example.mountain.model.MountainItem;
import com.example.mountain.model.MountainResponse;
import com.example.mountain.service.MountainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mountain")
public class MountainController {
    private final MountainService mountainService;

    @PostMapping("/new")
    public MountainCreateRequest setMountain(@RequestBody MountainCreateRequest request) {
        return mountainService.setMountain(request);
    }

    @GetMapping("/all")
    public List<MountainItem> getMountains() {
        return mountainService.getMountains();
    }

    @GetMapping("/{id}")
    public MountainResponse getMountain(@PathVariable long id) {
        return mountainService.getMountain(id);
    }
}
