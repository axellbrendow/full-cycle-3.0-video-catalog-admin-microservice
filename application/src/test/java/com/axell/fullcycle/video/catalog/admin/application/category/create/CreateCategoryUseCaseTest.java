package com.axell.fullcycle.video.catalog.admin.application.category.create;

import java.util.Objects;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.AdditionalAnswers;
import org.mockito.Mockito;

import com.axell.fullcycle.video.catalog.admin.domain.category.CategoryRepository;

public class CreateCategoryUseCaseTest {
    @Test
    public void givenAValidCommand_whenCallCreateCategory_shouldReturnCategoryId() {
        final var expectedName = "Movies";
        final var expectedDescription = "Most watched category";
        final var expectedIsActive = true;

        final var command = CreateCategoryCommand.with(expectedName, expectedDescription, expectedIsActive);

        final var repository = Mockito.mock(CategoryRepository.class);
        Mockito.when(repository.create(Mockito.any()))
                .thenAnswer(AdditionalAnswers.returnsFirstArg());

        final var useCase = new DefaultCreateCategoryUseCase(repository);

        final var output = useCase.execute(command);

        Assertions.assertNotNull(output);
        Assertions.assertNotNull(output.id());

        Mockito.verify(repository, Mockito.times(1))
                .create(Mockito.argThat(category -> {
                    return Objects.equals(expectedName, category.getName())
                            && Objects.equals(expectedDescription, category.getDescription())
                            && Objects.equals(expectedIsActive, category.isActive())
                            && Objects.nonNull(category.getId())
                            && Objects.nonNull(category.getCreatedAt())
                            && Objects.nonNull(category.getUpdatedAt())
                            && Objects.isNull(category.getDeletedAt());
                }));
    }
}
