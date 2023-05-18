package com.axell.fullcycle.video.catalog.admin.application.category.create;

import com.axell.fullcycle.video.catalog.admin.domain.category.Category;
import com.axell.fullcycle.video.catalog.admin.domain.category.CategoryId;

public record CreateCategoryOutput(
        CategoryId id) {
    public static CreateCategoryOutput from(final Category category) {
        return new CreateCategoryOutput(category.getId());
    }
}
