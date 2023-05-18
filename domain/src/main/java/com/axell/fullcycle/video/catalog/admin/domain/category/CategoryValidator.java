package com.axell.fullcycle.video.catalog.admin.domain.category;

import com.axell.fullcycle.video.catalog.admin.domain.validation.Error;
import com.axell.fullcycle.video.catalog.admin.domain.validation.ValidationHandler;
import com.axell.fullcycle.video.catalog.admin.domain.validation.Validator;

public class CategoryValidator extends Validator {
    private final Category category;

    public CategoryValidator(Category category, ValidationHandler handler) {
        super(handler);
        this.category = category;
    }

    @Override
    public void validate() {
        if (category.getName() == null)
            validationHandler().append(new Error("`name` should not be null"));
    }
}
