package com.axell.fullcycle.video.catalog.admin.infrastructure.configuration.usecases;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.axell.fullcycle.video.catalog.admin.application.category.create.CreateCategoryUseCase;
import com.axell.fullcycle.video.catalog.admin.application.category.create.DefaultCreateCategoryUseCase;
import com.axell.fullcycle.video.catalog.admin.application.category.delete.DefaultDeleteCategoryUseCase;
import com.axell.fullcycle.video.catalog.admin.application.category.delete.DeleteCategoryUseCase;
import com.axell.fullcycle.video.catalog.admin.application.category.retrieve.get.DefaultGetCategoryByIdUseCase;
import com.axell.fullcycle.video.catalog.admin.application.category.retrieve.get.GetCategoryByIdUseCase;
import com.axell.fullcycle.video.catalog.admin.application.category.retrieve.list.DefaultListCategoriesUseCase;
import com.axell.fullcycle.video.catalog.admin.application.category.retrieve.list.ListCategoriesUseCase;
import com.axell.fullcycle.video.catalog.admin.application.category.update.DefaultUpdateCategoryUseCase;
import com.axell.fullcycle.video.catalog.admin.application.category.update.UpdateCategoryUseCase;
import com.axell.fullcycle.video.catalog.admin.domain.category.CategoryRepository;

@Configuration
public class CategoryUseCaseConfig {
    private final CategoryRepository repository;

    public CategoryUseCaseConfig(final CategoryRepository repository) {
        this.repository = repository;
    }

    @Bean
    public CreateCategoryUseCase createCategoryUseCase() {
        return new DefaultCreateCategoryUseCase(repository);
    }

    @Bean
    public UpdateCategoryUseCase updateCategoryUseCase() {
        return new DefaultUpdateCategoryUseCase(repository);
    }

    @Bean
    public GetCategoryByIdUseCase getCategoryByIdUseCase() {
        return new DefaultGetCategoryByIdUseCase(repository);
    }

    @Bean
    public ListCategoriesUseCase listCategoriesUseCase() {
        return new DefaultListCategoriesUseCase(repository);
    }

    @Bean
    public DeleteCategoryUseCase deleteCategoryUseCase() {
        return new DefaultDeleteCategoryUseCase(repository);
    }
}
