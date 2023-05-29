package com.axell.fullcycle.video.catalog.admin.infrastructure.category;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.axell.fullcycle.video.catalog.admin.domain.category.Category;
import com.axell.fullcycle.video.catalog.admin.infrastructure.MySqlRepositoryTest;
import com.axell.fullcycle.video.catalog.admin.infrastructure.category.persistence.CategoryJpaRepository;

@MySqlRepositoryTest
public class CategoryMySqlRepositoryTest {
    @Autowired
    private CategoryMySqlRepository mySqlRepository;

    @Autowired
    private CategoryJpaRepository jpaRepository;

    @Test
    public void givenAValidCategory_whenCallsCreate_shouldReturnANewCategory() {
        final var expectedName = "Movies";
        final var expectedDescription = "Most watched category";
        final var expectedIsActive = true;

        final var category = Category.newCategory(expectedName, expectedDescription, expectedIsActive);

        Assertions.assertEquals(0, jpaRepository.count());

        final var actualCategory = mySqlRepository.create(category);

        Assertions.assertEquals(1, jpaRepository.count());
        Assertions.assertEquals(category.getId(), actualCategory.getId());
        Assertions.assertEquals(expectedName, actualCategory.getName());
        Assertions.assertEquals(expectedDescription, actualCategory.getDescription());
        Assertions.assertEquals(expectedIsActive, actualCategory.isActive());
        Assertions.assertEquals(category.getCreatedAt(), actualCategory.getCreatedAt());
        Assertions.assertEquals(category.getUpdatedAt(), actualCategory.getUpdatedAt());
        Assertions.assertEquals(category.getDeletedAt(), actualCategory.getDeletedAt());
        Assertions.assertNull(actualCategory.getDeletedAt());

        final var persistedCategory = jpaRepository.findById(category.getId().getValue()).get();

        Assertions.assertEquals(1, jpaRepository.count());
        Assertions.assertEquals(category.getId().getValue(), persistedCategory.getId());
        Assertions.assertEquals(expectedName, persistedCategory.getName());
        Assertions.assertEquals(expectedDescription, persistedCategory.getDescription());
        Assertions.assertEquals(expectedIsActive, persistedCategory.isActive());
        Assertions.assertEquals(category.getCreatedAt(), persistedCategory.getCreatedAt());
        Assertions.assertEquals(category.getUpdatedAt(), persistedCategory.getUpdatedAt());
        Assertions.assertEquals(category.getDeletedAt(), persistedCategory.getDeletedAt());
        Assertions.assertNull(persistedCategory.getDeletedAt());
    }
}
