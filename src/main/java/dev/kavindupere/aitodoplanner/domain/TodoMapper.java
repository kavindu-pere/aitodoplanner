package dev.kavindupere.aitodoplanner.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class TodoMapper {

    static Todo toToDo(TodoEntity entity) {
        return new Todo(
            entity.getCode(),
            entity.getTitle(),
            entity.getDescription(),
            entity.isCompleted()
        );
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
