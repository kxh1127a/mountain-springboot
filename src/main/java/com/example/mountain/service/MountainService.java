package com.example.mountain.service;

import com.example.mountain.entity.Mountain;
import com.example.mountain.model.MountainCreateRequest;
import com.example.mountain.model.MountainItem;
import com.example.mountain.model.MountainNameUpdateRequest;
import com.example.mountain.model.MountainResponse;
import com.example.mountain.repository.MountainRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

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

    public List<MountainItem> getMountains() {
        List<Mountain> target = mountainRepository.findAll();
        List<MountainItem> result = new LinkedList<>();

        target.forEach(item -> {
            MountainItem addItem = new MountainItem();
            addItem.setMountainInfo(item.getId()+"번 id는 "+item.getName()+" mountain 입니다.");
            result.add(addItem);
        });

        return result;
    }

    public MountainResponse getMountain(long id) {
        Mountain target = mountainRepository.findById(id).orElseThrow();

        MountainResponse result = new MountainResponse();
        result.setMountainResult("id " + id +" : "+ target.getName() + " mountain");

        return result;
    }

    public void putMountainByName(MountainNameUpdateRequest request, long id) {
        Mountain target = mountainRepository.findById(id).orElseThrow();
        target.setName(request.getName());
        mountainRepository.save(target);
    }

    public void delMountain(long id) {
        mountainRepository.deleteById(id);
    }

    public long getMountainId(String mountainName) {
        List<Mountain> target = mountainRepository.findAll();
        long result = 0;

        for (Mountain item : target) {
            if (item.getName().equals(mountainName)) {
                result = item.getId();
            }
        }

        return result;
    }
}
