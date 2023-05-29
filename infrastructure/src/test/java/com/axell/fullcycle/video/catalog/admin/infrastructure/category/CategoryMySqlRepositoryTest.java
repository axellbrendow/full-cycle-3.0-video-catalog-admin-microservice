package com.axell.fullcycle.video.catalog.admin.infrastructure.category;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.axell.fullcycle.video.catalog.admin.domain.category.CategoryRepository;
import com.axell.fullcycle.video.catalog.admin.infrastructure.MySqlRepositoryTest;

@MySqlRepositoryTest
public class CategoryMySqlRepositoryTest {
    @Autowired
    private CategoryMySqlRepository mySqlRepository;

    @Autowired
    private CategoryRepository repository;

    @Test
    public void testInjectedDependencies() {
        Assertions.assertNotNull(mySqlRepository);
        Assertions.assertNotNull(repository);
    }
}
