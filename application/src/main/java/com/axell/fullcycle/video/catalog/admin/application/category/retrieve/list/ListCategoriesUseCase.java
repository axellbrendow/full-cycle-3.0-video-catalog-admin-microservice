package com.axell.fullcycle.video.catalog.admin.application.category.retrieve.list;

import com.axell.fullcycle.video.catalog.admin.application.UseCase;
import com.axell.fullcycle.video.catalog.admin.domain.category.CategorySearchQuery;
import com.axell.fullcycle.video.catalog.admin.domain.pagination.Pagination;

public abstract class ListCategoriesUseCase extends UseCase<CategorySearchQuery, Pagination<CategoryListOutput>> {
}
