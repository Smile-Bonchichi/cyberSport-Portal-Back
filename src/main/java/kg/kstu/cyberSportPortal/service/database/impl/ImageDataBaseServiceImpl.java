package kg.kstu.cyberSportPortal.service.database.impl;

import kg.kstu.cyberSportPortal.entity.Image;
import kg.kstu.cyberSportPortal.repository.ImageRepository;
import kg.kstu.cyberSportPortal.service.base.impl.CrudServiceImpl;
import kg.kstu.cyberSportPortal.service.database.ImageDataBaseService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ImageDataBaseServiceImpl extends CrudServiceImpl<Image> implements ImageDataBaseService {
    final ImageRepository imageRepository;

    @Autowired
    public ImageDataBaseServiceImpl(ImageRepository imageRepository) {
        super(imageRepository);
        this.imageRepository = imageRepository;
    }

    @Override
    public List<Image> saveAll(List<Image> images) {
        return imageRepository.saveAll(images);
    }
}
