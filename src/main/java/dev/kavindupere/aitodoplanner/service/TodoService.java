package dev.kavindupere.aitodoplanner.service;

import java.util.List;
import java.util.Optional;

import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;

import dev.kavindupere.aitodoplanner.data.Todo;
import dev.kavindupere.aitodoplanner.data.TodoRepository;

@BrowserCallable
@AnonymousAllowed
class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public Todo save(Todo todo) {
        return findById(todo.getId()).map(t -> {
            t.setTitle(todo.getTitle());
            t.setDescription(todo.getDescription());
            t.setCompleted(todo.isCompleted());
            return todoRepository.save(t);
        }).orElse(todoRepository.save(todo));
    }

    private Optional<Todo> findById(Long id) {
        return todoRepository.findById(id);
    }

}
