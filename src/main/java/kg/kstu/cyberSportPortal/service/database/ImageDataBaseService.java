package kg.kstu.cyberSportPortal.service.database;

import kg.kstu.cyberSportPortal.entity.Image;
import kg.kstu.cyberSportPortal.service.base.CrudService;

import java.util.List;

public interface ImageDataBaseService extends CrudService<Image> {
    List<Image> saveAll(List<Image> images);
}
