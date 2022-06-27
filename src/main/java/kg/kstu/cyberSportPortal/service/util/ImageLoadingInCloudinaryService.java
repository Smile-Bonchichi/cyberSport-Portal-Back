package kg.kstu.cyberSportPortal.service.util;

import org.springframework.web.multipart.MultipartFile;

public interface ImageLoadingInCloudinaryService {
    String saveInCloudinary(MultipartFile image) throws Exception;
}
