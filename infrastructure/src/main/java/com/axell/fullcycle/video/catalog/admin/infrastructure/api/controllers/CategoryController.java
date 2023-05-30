package com.axell.fullcycle.video.catalog.admin.infrastructure.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.axell.fullcycle.video.catalog.admin.domain.pagination.Pagination;
import com.axell.fullcycle.video.catalog.admin.infrastructure.api.CategoryApi;

@RestController
public class CategoryController implements CategoryApi {
    @Override
    public ResponseEntity<?> createCategory() {
        return null;
    }

    @Override
    public Pagination<?> listCategories(String search, int page, int perPage, String sort, String direction) {
        return null;
    }
}
