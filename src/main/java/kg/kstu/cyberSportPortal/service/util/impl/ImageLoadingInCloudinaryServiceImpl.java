package kg.kstu.cyberSportPortal.service.util.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kg.kstu.cyberSportPortal.service.util.ImageLoadingInCloudinaryService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.util.Map;
import java.util.Objects;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ImageLoadingInCloudinaryServiceImpl implements ImageLoadingInCloudinaryService {

    final Environment environment;

    @Autowired
    public ImageLoadingInCloudinaryServiceImpl(Environment environment) {
        this.environment = environment;
    }

    @Override
    public String saveInCloudinary(MultipartFile image) throws Exception {
        File file = Files.createTempFile(
                System.currentTimeMillis() + "",
                Objects.requireNonNull(image.getOriginalFilename()).substring(image.getOriginalFilename().length() - 4)
        ).toFile();

        Cloudinary cloudinary = new Cloudinary(environment.getProperty("spring.cloudinary.url"));
        Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());

        return (String) uploadResult.get("url");
    }
}
