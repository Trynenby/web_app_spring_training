package fr.lernejo.todo;

import org.springframework.web.bind.annotation.*;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/todo")
public class TodoListController {

    private final TodoRepository repository;

    public TodoListController(TodoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public void addTodo(@RequestBody TodoEntity todo) {
        repository.save(todo);
    }

    @GetMapping
    public Iterable<TodoEntity> getTodos() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
            .map(entity -> entity)
            .toList();
    }
}

