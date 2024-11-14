package dev.kavindupere.aitodoplanner.domain;

import java.util.List;

import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;

import lombok.RequiredArgsConstructor;

@BrowserCallable
@AnonymousAllowed
@RequiredArgsConstructor
class TodoService {

    private final TodoRepository todoRepository;


    public List<Todo> findAll() {
        return todoRepository.findAll().stream()
            .map(TodoMapper::toToDo)
            .toList();
    }

    public Todo save(Todo todo) {
        var e = TodoMapper.toEntity(todo);
        todoRepository.findByCode(todo.code())
            .ifPresentOrElse(
                existing -> e.setId(existing.getId()),
                () -> e.setId(null)
            );
        return TodoMapper.toToDo(todoRepository.save(e));        
    }

    

}
