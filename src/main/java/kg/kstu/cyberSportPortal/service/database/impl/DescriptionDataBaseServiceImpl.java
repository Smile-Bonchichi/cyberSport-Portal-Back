package kg.kstu.cyberSportPortal.service.database.impl;

import kg.kstu.cyberSportPortal.entity.Description;
import kg.kstu.cyberSportPortal.repository.DescriptionRepository;
import kg.kstu.cyberSportPortal.service.base.impl.CrudServiceImpl;
import kg.kstu.cyberSportPortal.service.database.DescriptionDataBaseService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DescriptionDataBaseServiceImpl extends CrudServiceImpl<Description> implements DescriptionDataBaseService {
    final DescriptionRepository descriptionRepository;

    @Autowired
    public DescriptionDataBaseServiceImpl(DescriptionRepository descriptionRepository) {
        super(descriptionRepository);
        this.descriptionRepository = descriptionRepository;
    }
}
