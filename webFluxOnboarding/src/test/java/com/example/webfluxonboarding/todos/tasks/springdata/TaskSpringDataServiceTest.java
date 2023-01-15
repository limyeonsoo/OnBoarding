package com.example.webfluxonboarding.todos.tasks.springdata;

import com.example.webfluxonboarding.todos.tasks.Task;
import com.example.webfluxonboarding.todos.tasks.TaskAttributesInsert;
import com.example.webfluxonboarding.todos.tasks.TaskStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.UUID;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class TaskSpringDataServiceTest {

    @InjectMocks
    private TaskSpringDataService underTest;

    @Mock
    private TaskSpringDataRepository taskSpringDataRepository;
    @Mock
    private Supplier<UUID> uuidGenerator;

    @Test
    void insert() {
        // given
        final var id = UUID.fromString("5c325424-8bc9-4941-8f35-e9d1a38ab5bb");
        given(uuidGenerator.get()).willReturn(id);

        final var details = "TestTaskDetails";
        final var taskAttributesInsert = new TaskAttributesInsert(details);
        final var taskEntity = new TaskEntity(
                id,
                taskAttributesInsert.details(),
                TaskStatus.ACTIVE,
                true
        );
        given(taskSpringDataRepository.save(any())).willReturn(Mono.just(taskEntity));

        // when
        final var actual = underTest.insert(taskAttributesInsert);

        // then
        StepVerifier.create(actual)
                .assertNext(it -> assertThat(it).isEqualTo(new Task(
                        id,
                        details,
                        TaskStatus.ACTIVE
                )))
                .verifyComplete();

        final var taskEntityCaptor = ArgumentCaptor.forClass(TaskEntity.class);
        then(taskSpringDataRepository).should().save(taskEntityCaptor.capture());
        assertThat(taskEntityCaptor.getValue().getId()).isEqualTo(id);
        assertThat(taskEntityCaptor.getValue().getDetails()).isEqualTo(details);
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }

    @Test
    void patch() {
    }

    @Test
    void select() {
    }

    @Test
    void selectAll() {
    }
}