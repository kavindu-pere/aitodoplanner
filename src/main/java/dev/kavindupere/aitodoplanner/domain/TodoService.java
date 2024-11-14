package dev.kavindupere.aitodoplanner.domain;

import java.util.List;

import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;

@BrowserCallable
@AnonymousAllowed
class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> findAll() {
        return todoRepository.findAll().stream()
            .map(TodoMapper::toToDo)
            .toList();
    }

    public Todo save(Todo todo) {
        var e = TodoMapper.toEntity(todo);
        return TodoMapper.toToDo(todoRepository.save(e));        
    }

    

}
