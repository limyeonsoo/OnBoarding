package com.sds.mvcOnboarding.controller;

import com.sds.mvcOnboarding.domain.Task;
import com.sds.mvcOnboarding.service.TodoCreateAttributes;
import com.sds.mvcOnboarding.service.TodoModifyAttributes;
import com.sds.mvcOnboarding.service.TodoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class TodoControllerTest {

    @InjectMocks
    private TodoController underTest;

    @Mock
    private TodoService todoService;

    @Test
    void create() {
        // given
        final var taskId = 456;
        given(todoService.create(any())).willReturn(taskId);

        // when
        final int member_id = 123;
        final var content = "createTest";
        final var request = new TaskCreateRequest(
                member_id,
                content
        );
        final var actual = underTest.create(request);

        // then
        assertEquals(taskId, actual.getId());

        final var todoCreateAttributesCaptor = ArgumentCaptor.forClass(TodoCreateAttributes.class);
        then(todoService).should().create(todoCreateAttributesCaptor.capture());
        final var captorValue = todoCreateAttributesCaptor.getValue();
        assertEquals(request.content(), captorValue.getContent());
        assertEquals(request.member_id(), captorValue.getMember_id());
    }

    @Test
    void retrieve() {
        // given
        final var task = new Task(
                1,
                2,
                "testContent",
                "testStatus",
                -1,
                -1
        );
        given(todoService.retrieve(anyInt())).willReturn(task);

        // when
        final int id = 123;
        final var actual = underTest.retrieve(id);

        // then
        assertEquals(task.getId(), actual.getId());
        assertEquals(task.getMember_id(), actual.getMember_id());
        assertEquals(task.getContent(), actual.getContent());
        assertEquals(task.getStatus(), actual.getStatus());
        assertEquals(task.getCreate_date(), actual.getCreate_date());
        assertEquals(task.getModify_date(), actual.getModify_date());

        then(todoService).should().retrieve(id);
    }

    @Test
    void retrieveAll() {
        // given
        final var task1 = new Task(
                1,
                2,
                "testContent",
                "testStatus",
                -1,
                -1
        );
        final var task2 = new Task(
                2,
                3,
                "testContent1",
                "testStatus1",
                -11,
                -11
        );
        given(todoService.retrieveAll()).willReturn(List.of(task1, task2));

        // when
        final var actual = underTest.retrieveAll();

        // then
        assertEquals(task1.getId(), actual.get(0).getId());
        assertEquals(task1.getMember_id(), actual.get(0).getMember_id());
        assertEquals(task2.getId(), actual.get(1).getId());
        assertEquals(task2.getMember_id(), actual.get(1).getMember_id());

        then(todoService).should(times(1)).retrieveAll();
    }

    @Test
    void modify_content_and_status() {
        // given
        final var task = new Task(
          123,
                456,
                "testContent",
                "testStatus",
                0L,
                0L
        );
        given(todoService.modify(any())).willReturn(task);

        // when
        final var id = 1234;
        final var request = new TaskModifyRequest("testContent", "testStatus");
        final var actual = underTest.modify(id, request);

        // then
        assertEquals(task.getId(), actual.getId());
        assertEquals(task.getMember_id(), actual.getMember_id());
        assertEquals(task.getContent(), actual.getContent());
        assertEquals(task.getStatus(), actual.getStatus());
        assertEquals(task.getCreate_date(), actual.getCreate_date());
        assertEquals(task.getModify_date(), actual.getModify_date());

        final var todoModifyAttributesCaptor = ArgumentCaptor.forClass(TodoModifyAttributes.class);
        then(todoService).should().modify(todoModifyAttributesCaptor.capture());
        final var captorValue = todoModifyAttributesCaptor.getValue();
        assertEquals(request.getContent(), captorValue.getContent());
        assertEquals(request.getStatus(), captorValue.getStatus());
    }

    @Test
    void delete() {
        // given

        // when
        final var id = 1234;
        underTest.delete(id);

        // then
        then(todoService).should().delete(id);
    }
}
