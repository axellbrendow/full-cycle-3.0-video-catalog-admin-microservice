package com.axell.fullcycle.video.catalog.admin.application;

public abstract class InputOnlyUseCase<Input> {
    public abstract void execute(Input input);
}
