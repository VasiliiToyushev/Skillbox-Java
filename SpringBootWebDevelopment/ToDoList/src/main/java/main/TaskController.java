package main;

import main.model.Task;
import main.model.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;


    @GetMapping("/tasks/")
    public List<Task> list() {
        Iterable<Task> taskIterable = taskRepository.findAll();
        List<Task> tasks = new ArrayList<>();
        taskIterable.forEach(task -> tasks.add(task));
        return tasks;
    }
    @PostMapping(value = "/tasks/",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Task> addTask (@RequestBody Task task) {
        taskRepository.save(task);
        return ResponseEntity.status (HttpStatus.CREATED).body(task);
    }
    @GetMapping("/tasks/{id}")
    public ResponseEntity get(@PathVariable int id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (!optionalTask.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new  ResponseEntity(optionalTask.get(), HttpStatus.OK);
    }

    @PatchMapping(value = "/tasks/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Task> patch(@RequestBody Task task, @PathVariable int id){
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (!optionalTask.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        Task patchTask = optionalTask.get();

        if (!(task.getTitle() == null))patchTask.setTitle(task.getTitle());

        if (!(task.getDescription() == null))patchTask.setDescription(task.getDescription());

        if (!(task.isDone() == false))patchTask.setDone(task.isDone());


        taskRepository.save(patchTask);
        return new  ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity delete(@PathVariable int id){
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (!optionalTask.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        taskRepository.delete(optionalTask.get());
        return new ResponseEntity(HttpStatus.OK);
    }
    @DeleteMapping("/tasks")
    public ResponseEntity<String> deleteAllTasks() {
            taskRepository.deleteAll();
            return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
