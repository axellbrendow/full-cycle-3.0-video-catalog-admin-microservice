package com.axell.fullcycle.video.catalog.admin.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CategoryTest {
    @Test
    public void testNewCategory() {
        Assertions.assertNotNull(new Category());
    }
}