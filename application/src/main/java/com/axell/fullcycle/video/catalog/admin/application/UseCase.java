package com.axell.fullcycle.video.catalog.admin.application;

import com.axell.fullcycle.video.catalog.admin.domain.category.Category;

public class UseCase {
    public Category execute() {
        return new Category();
    }
}