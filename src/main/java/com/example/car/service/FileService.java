package com.example.car.service;

import com.example.car.dto.FileImageDto;
import com.example.car.exception.StorageException;
import com.example.car.model.Car;
import com.example.car.store.FileSystemStore;
import com.example.car.web.UserSession;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Slf4j
@AllArgsConstructor
@Data
public class FileService {
    private final CarService carService;
    private final FileSystemStore fileSystemStore;
    private final UserSession session;

    public boolean upload(final MultipartFile file,
                          final FileImageDto imageDto) {
        Car car = session.getNewCar();
        boolean res = carService.addImage(car, imageDto);
        if (!res) {
            log.error("Not saved in DB");
            return false;
        }
        try {
            fileSystemStore.store(file, imageDto.getName());
        } catch (StorageException e) {
            fileSystemStore.deleteByName(imageDto.getName());
            log.error(e.getMessage(), e);
            return false;
        }
        return true;
    }

    public Resource download(final String name) {
        return fileSystemStore.loadAsResource(name);
    }

    public void deleteByName(final String name) {
        fileSystemStore.deleteByName(name);
    }
}
