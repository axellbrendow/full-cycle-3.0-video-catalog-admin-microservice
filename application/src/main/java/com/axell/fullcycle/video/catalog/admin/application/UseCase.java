package com.axell.fullcycle.video.catalog.admin.application;

public abstract class UseCase<Input, Output> {
    public abstract Output execute(Input input);
}
