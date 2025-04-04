package dynamo.to_do.todo;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Todo getTodoById(String id) {
        return todoRepository.findById(id);
    }

    public Todo updateTodo(String id, Todo updatedTodo) {
        Todo existingTodo = todoRepository.findById(id);
        if (existingTodo != null) {
            existingTodo.setHeading(updatedTodo.getHeading());
            existingTodo.setDescription(updatedTodo.getDescription());
            existingTodo.setDate(updatedTodo.getDate());
            existingTodo.setTime(updatedTodo.getTime());
            existingTodo.setCompleted(updatedTodo.isCompleted());
            return todoRepository.save(existingTodo);
        }
        return null;
    }

    public void deleteTodo(String id) {
        todoRepository.delete(id);
    }
}