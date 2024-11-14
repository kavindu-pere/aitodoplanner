package dev.kavindupere.aitodoplanner.data;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
class DbInit implements ApplicationRunner {

    private TodoRepository todoRepository;

    public DbInit(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Generate 20 random Todos with title, description and completed
        for (int i = 1; i <= 20; i++) {
            Todo todo = new Todo();
            todo.setTitle("Todo " + i);
            todo.setDescription("Description " + i);
            todo.setCompleted(Math.random() < 0.5);
            todoRepository.save(todo);
        }
    }

}
