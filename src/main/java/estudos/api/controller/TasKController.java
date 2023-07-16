package estudos.api.controller;

import estudos.api.model.Task;
import estudos.api.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("tasks")
public class TasKController {
    @Autowired
    private TaskService service;

    @GetMapping()
    public ResponseEntity<List<Task>> findAllTasks(){
        return ResponseEntity.ok().body(this.service.getAll());
    }

    @PostMapping()
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.createTask(task));
    }
}
