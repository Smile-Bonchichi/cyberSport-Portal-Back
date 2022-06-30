package kg.kstu.cyberSportPortal.service.impl;

import kg.kstu.cyberSportPortal.dto.request.userData.UserDataDtoRequest;
import kg.kstu.cyberSportPortal.dto.response.userData.UserDataDtoResponse;
import kg.kstu.cyberSportPortal.entity.*;
import kg.kstu.cyberSportPortal.exception.ImageSaveException;
import kg.kstu.cyberSportPortal.mapper.CategoryMapper;
import kg.kstu.cyberSportPortal.service.UserDataService;
import kg.kstu.cyberSportPortal.service.database.*;
import kg.kstu.cyberSportPortal.service.util.CategoryParserService;
import kg.kstu.cyberSportPortal.service.util.ImageLoadingInCloudinaryService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDataServiceImpl implements UserDataService {
    final UserDataBaseService userDataBaseService;

    final UserDataDataBaseService userDataDataBaseService;

    final ImageDataBaseService imageDataBaseService;

    final DescriptionDataBaseService descriptionDataBaseService;

    final CategoryParserService categoryParserService;

    final ImageLoadingInCloudinaryService imageLoadingInCloudinaryService;

    @Autowired
    public UserDataServiceImpl(UserDataBaseService userDataBaseService,
                               UserDataDataBaseService userDataDataBaseService,
                               ImageDataBaseService imageDataBaseService,
                               DescriptionDataBaseService descriptionDataBaseService,
                               CategoryParserService categoryParserService,
                               ImageLoadingInCloudinaryService imageLoadingInCloudinaryService) {
        this.userDataBaseService = userDataBaseService;
        this.userDataDataBaseService = userDataDataBaseService;
        this.imageDataBaseService = imageDataBaseService;
        this.descriptionDataBaseService = descriptionDataBaseService;
        this.categoryParserService = categoryParserService;
        this.imageLoadingInCloudinaryService = imageLoadingInCloudinaryService;
    }

    @Override
    public UserDataDtoResponse writeNewUserData(UserDataDtoRequest userDataDtoRequest) {
        User user = userDataBaseService.getByLogin(SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName()
        );

        UserData userData = userDataDataBaseService.findByUserId(user.getId());

        if (!userDataDtoRequest.getDescription().isEmpty()) {
            Description description = userData.getDescription();
            description.setDescription(userDataDtoRequest.getDescription());
            descriptionDataBaseService.saveOrUpdate(description);
        }

        if (userDataDtoRequest.getImage() != null) {
            Image image = userData.getImage();
            try {
                String url = imageLoadingInCloudinaryService.saveInCloudinary(userDataDtoRequest.getImage());

                if (image != null) {
                    image.setUrl(url);
                } else {
                    image = Image.builder()
                            .url(url)
                            .build();
                }
            } catch (Exception e) {
                throw new ImageSaveException("Ошибка при загрузке файла в облочное хранилище", HttpStatus.SERVICE_UNAVAILABLE);
            }
            imageDataBaseService.saveOrUpdate(image);
        }

        userData.setCategories(categoryParserService.addUpdateCategory(userDataDtoRequest.getCategoryId()));
        userDataDataBaseService.saveOrUpdate(userData);

        return UserDataDtoResponse.builder()
                .categories(CategoryMapper.INSTANCE.toCategoriesDto(userData.getCategories()))
                .newDescription(userData.getDescription().getDescription())
                .newImageUrl(userData.getImage() != null ? userData.getImage().getUrl() : null)
                .build();
    }
}
