package dev.kavindupere.aitodoplanner.domain;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("dev")
@Component
class DbInit implements ApplicationRunner {

    private TodoRepository todoRepository;

    public DbInit(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Generate 20 random Todos with title, description and completed
        for (int i = 0; i < 20; i++) {
            TodoEntity todo = new TodoEntity();
            todo.setCode(String.format("%s", i + 1));
            todo.setTitle("Todo " + i);
            todo.setDescription("Description " + i);
            todo.setCompleted(Math.random() < 0.5);
            todoRepository.save(todo);
        }
    }

}
