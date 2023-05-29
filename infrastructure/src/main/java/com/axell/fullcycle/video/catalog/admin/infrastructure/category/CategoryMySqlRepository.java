package com.axell.fullcycle.video.catalog.admin.infrastructure.category;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axell.fullcycle.video.catalog.admin.domain.category.Category;
import com.axell.fullcycle.video.catalog.admin.domain.category.CategoryId;
import com.axell.fullcycle.video.catalog.admin.domain.category.CategoryRepository;
import com.axell.fullcycle.video.catalog.admin.domain.category.CategorySearchQuery;
import com.axell.fullcycle.video.catalog.admin.domain.pagination.Pagination;
import com.axell.fullcycle.video.catalog.admin.infrastructure.category.persistence.CategoryJpaEntity;
import com.axell.fullcycle.video.catalog.admin.infrastructure.category.persistence.CategoryJpaRepository;

@Service
public class CategoryMySqlRepository implements CategoryRepository {
    private final CategoryJpaRepository repository;

    public CategoryMySqlRepository(CategoryJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Category create(Category category) {
        return repository.save(CategoryJpaEntity.from(category)).toDomainCategory();
    }

    @Override
    public Category update(Category category) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Optional<Category> findById(CategoryId id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Pagination<Category> findAll(CategorySearchQuery query) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public void deleteById(CategoryId id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }
}
