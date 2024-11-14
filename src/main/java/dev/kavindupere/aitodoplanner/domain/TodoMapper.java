package dev.kavindupere.aitodoplanner.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class TodoMapper {

    static Todo toToDo(TodoEntity entity) {
        return Todo.builder()
        .code(entity.getCode())
        .title(entity.getTitle())
        .description(entity.getDescription())
        .completed(entity.isCompleted())
        .build();
    }

    static TodoEntity toEntity(Todo todo) {
        return TodoEntity.builder()
                .code(todo.code())
                .title(todo.title())
                .description(todo.description())
                .completed(todo.completed())
                .build();
    }
}
