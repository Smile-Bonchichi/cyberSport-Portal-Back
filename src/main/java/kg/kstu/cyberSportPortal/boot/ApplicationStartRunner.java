package kg.kstu.cyberSportPortal.boot;

import kg.kstu.cyberSportPortal.entity.Category;
import kg.kstu.cyberSportPortal.entity.Description;
import kg.kstu.cyberSportPortal.enums.CategoryType;
import kg.kstu.cyberSportPortal.service.database.CategoryDataBaseService;
import kg.kstu.cyberSportPortal.service.database.DescriptionDataBaseService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApplicationStartRunner implements CommandLineRunner {
    final DescriptionDataBaseService descriptionDataBaseService;

    final CategoryDataBaseService categoryDataBaseService;

    @Autowired
    public ApplicationStartRunner(DescriptionDataBaseService descriptionDataBaseService,
                                  CategoryDataBaseService categoryDataBaseService) {
        this.descriptionDataBaseService = descriptionDataBaseService;
        this.categoryDataBaseService = categoryDataBaseService;
    }

    @Override
    public void run(String... args) throws Exception {
        descriptionDataBaseService.saveOrUpdate(
                Description.builder()
                        .description("")
                        .build()
        );

        saveGamerCategory();
        saveGameCategory();
        saveNewsCategory();
        saveTeamsCategory();
    }

    private void saveGamerCategory() {
        categoryDataBaseService.saveOrUpdate(
                Category.builder()
                        .categoryType(CategoryType.GAMER)
                        .name("Новичок")
                        .build()
        );

        categoryDataBaseService.saveOrUpdate(
                Category.builder()
                        .categoryType(CategoryType.GAMER)
                        .name("ADMIN")
                        .build()
        );

        categoryDataBaseService.saveOrUpdate(
                Category.builder()
                        .categoryType(CategoryType.GAMER)
                        .name("PRO")
                        .build()
        );

        categoryDataBaseService.saveOrUpdate(
                Category.builder()
                        .categoryType(CategoryType.GAMER)
                        .name("Киберспортсмен")
                        .build()
        );
    }

    private void saveGameCategory() {
        categoryDataBaseService.saveOrUpdate(
                Category.builder()
                        .categoryType(CategoryType.GAME)
                        .name("Аркады")
                        .build()
        );

        categoryDataBaseService.saveOrUpdate(
                Category.builder()
                        .categoryType(CategoryType.GAME)
                        .name("Командные бои")
                        .build()
        );
    }

    private void saveNewsCategory() {
        categoryDataBaseService.saveOrUpdate(
                Category.builder()
                        .categoryType(CategoryType.NEWS)
                        .name("Кибер-спортсмен")
                        .build()
        );

        categoryDataBaseService.saveOrUpdate(
                Category.builder()
                        .categoryType(CategoryType.NEWS)
                        .name("Выигрыш-проигрыш")
                        .build()
        );

        categoryDataBaseService.saveOrUpdate(
                Category.builder()
                        .categoryType(CategoryType.NEWS)
                        .name("Игры")
                        .build()
        );

        categoryDataBaseService.saveOrUpdate(
                Category.builder()
                        .categoryType(CategoryType.NEWS)
                        .name("обновления")
                        .build()
        );

        categoryDataBaseService.saveOrUpdate(
                Category.builder()
                        .categoryType(CategoryType.NEWS)
                        .name("Турниры")
                        .build()
        );

        categoryDataBaseService.saveOrUpdate(
                Category.builder()
                        .categoryType(CategoryType.NEWS)
                        .name("Новые игры")
                        .build()
        );
    }

    private void saveTeamsCategory() {
        categoryDataBaseService.saveOrUpdate(
                Category.builder()
                        .categoryType(CategoryType.TEAM)
                        .name("CS-GO")
                        .build()
        );

        categoryDataBaseService.saveOrUpdate(
                Category.builder()
                        .categoryType(CategoryType.TEAM)
                        .name("Dota 2")
                        .build()
        );

        categoryDataBaseService.saveOrUpdate(
                Category.builder()
                        .categoryType(CategoryType.TEAM)
                        .name("League of Legends")
                        .build()
        );

        categoryDataBaseService.saveOrUpdate(
                Category.builder()
                        .categoryType(CategoryType.TEAM)
                        .name("PLAYERUNKNOWN'S BATTLEGROUNDS")
                        .build()
        );

        categoryDataBaseService.saveOrUpdate(
                Category.builder()
                        .categoryType(CategoryType.TEAM)
                        .name("Arena of Valor")
                        .build()
        );
    }
}