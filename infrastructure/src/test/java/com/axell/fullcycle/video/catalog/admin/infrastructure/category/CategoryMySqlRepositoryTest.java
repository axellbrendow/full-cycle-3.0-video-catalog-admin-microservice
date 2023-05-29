package com.axell.fullcycle.video.catalog.admin.infrastructure.category;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.axell.fullcycle.video.catalog.admin.domain.category.Category;
import com.axell.fullcycle.video.catalog.admin.domain.category.CategoryId;
import com.axell.fullcycle.video.catalog.admin.infrastructure.MySqlRepositoryTest;
import com.axell.fullcycle.video.catalog.admin.infrastructure.category.persistence.CategoryJpaEntity;
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

    @Test
    public void givenAValidCategory_whenCallsUpdate_shouldReturnCategoryUpdated() {
        final var expectedName = "Movies";
        final var expectedDescription = "Most watched category";
        final var expectedIsActive = true;

        final var category = Category.newCategory("Movie", null, expectedIsActive);

        Assertions.assertEquals(0, jpaRepository.count());

        jpaRepository.saveAndFlush(CategoryJpaEntity.from(category));

        Assertions.assertEquals(1, jpaRepository.count());

        final var invalidEntity = jpaRepository.findById(category.getId().getValue()).get();
        Assertions.assertEquals("Movie", invalidEntity.getName());
        Assertions.assertNull(invalidEntity.getDescription());
        Assertions.assertEquals(expectedIsActive, invalidEntity.isActive());

        final var updatedCategory = category.clone().update(expectedName, expectedDescription, expectedIsActive);

        final var actualCategory = mySqlRepository.update(updatedCategory);

        Assertions.assertEquals(1, jpaRepository.count());
        Assertions.assertEquals(category.getId(), actualCategory.getId());
        Assertions.assertEquals(expectedName, actualCategory.getName());
        Assertions.assertEquals(expectedDescription, actualCategory.getDescription());
        Assertions.assertEquals(expectedIsActive, actualCategory.isActive());
        Assertions.assertEquals(category.getCreatedAt(), actualCategory.getCreatedAt());
        Assertions.assertTrue(actualCategory.getUpdatedAt().isAfter(category.getUpdatedAt()));
        Assertions.assertEquals(category.getDeletedAt(), actualCategory.getDeletedAt());
        Assertions.assertNull(actualCategory.getDeletedAt());

        final var persistedCategory = jpaRepository.findById(category.getId().getValue()).get();

        Assertions.assertEquals(1, jpaRepository.count());
        Assertions.assertEquals(category.getId().getValue(), persistedCategory.getId());
        Assertions.assertEquals(expectedName, persistedCategory.getName());
        Assertions.assertEquals(expectedDescription, persistedCategory.getDescription());
        Assertions.assertEquals(expectedIsActive, persistedCategory.isActive());
        Assertions.assertEquals(category.getCreatedAt(), persistedCategory.getCreatedAt());
        Assertions.assertTrue(persistedCategory.getUpdatedAt().isAfter(category.getUpdatedAt()));
        Assertions.assertEquals(category.getDeletedAt(), persistedCategory.getDeletedAt());
        Assertions.assertNull(persistedCategory.getDeletedAt());
    }

    @Test
    public void givenAPrePersistedCategoryAndValidCategoryId_whenTryToDeleteIt_shouldDeleteCategory() {
        final var category = Category.newCategory("Movies", null, true);

        Assertions.assertEquals(0, jpaRepository.count());

        jpaRepository.saveAndFlush(CategoryJpaEntity.from(category));

        Assertions.assertEquals(1, jpaRepository.count());

        mySqlRepository.deleteById(category.getId());

        Assertions.assertEquals(0, jpaRepository.count());
    }

    @Test
    public void givenAnInvalidCategoryId_whenTryToDeleteIt_shouldIgnore() {
        Assertions.assertEquals(0, jpaRepository.count());

        mySqlRepository.deleteById(CategoryId.from("invalid"));

        Assertions.assertEquals(0, jpaRepository.count());
    }

    @Test
    public void givenAPrePersistedCategoryAndValidCategoryId_whenCallsFindById_shouldReturnCategory() {
        final var expectedName = "Movies";
        final var expectedDescription = "Most watched category";
        final var expectedIsActive = true;

        final var category = Category.newCategory(expectedName, expectedDescription, expectedIsActive);

        Assertions.assertEquals(0, jpaRepository.count());

        jpaRepository.saveAndFlush(CategoryJpaEntity.from(category));

        Assertions.assertEquals(1, jpaRepository.count());

        final var actualCategory = mySqlRepository.findById(category.getId()).get();

        Assertions.assertEquals(1, jpaRepository.count());
        Assertions.assertEquals(category.getId(), actualCategory.getId());
        Assertions.assertEquals(expectedName, actualCategory.getName());
        Assertions.assertEquals(expectedDescription, actualCategory.getDescription());
        Assertions.assertEquals(expectedIsActive, actualCategory.isActive());
        Assertions.assertEquals(category.getCreatedAt(), actualCategory.getCreatedAt());
        Assertions.assertEquals(category.getUpdatedAt(), actualCategory.getUpdatedAt());
        Assertions.assertEquals(category.getDeletedAt(), actualCategory.getDeletedAt());
        Assertions.assertNull(actualCategory.getDeletedAt());
    }

    @Test
    public void givenValidCategoryIdNotStored_whenCallsFindById_shouldReturnEmpty() {
        Assertions.assertEquals(0, jpaRepository.count());

        final var actualCategory = mySqlRepository.findById(CategoryId.from("empty"));

        Assertions.assertTrue(actualCategory.isEmpty());
    }
}
