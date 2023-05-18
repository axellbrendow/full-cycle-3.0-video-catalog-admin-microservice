package com.axell.fullcycle.video.catalog.admin.application.category.create;

import java.util.Objects;

import com.axell.fullcycle.video.catalog.admin.domain.category.Category;
import com.axell.fullcycle.video.catalog.admin.domain.category.CategoryRepository;
import com.axell.fullcycle.video.catalog.admin.domain.validation.handler.ThrowsValidationHandler;

public class DefaultCreateCategoryUseCase extends CreateCategoryUseCase {
    private final CategoryRepository repository;

    public DefaultCreateCategoryUseCase(CategoryRepository repository) {
        this.repository = Objects.requireNonNull(repository);
    }

    @Override
    public CreateCategoryOutput execute(final CreateCategoryCommand input) {
        final var category = Category.newCategory(input.name(), input.description(), input.isActive());
        category.validate(new ThrowsValidationHandler());
        return CreateCategoryOutput.from(repository.create(category));
    }
}
