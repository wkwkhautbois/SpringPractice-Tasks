package dev.wkwk.tasks.web.task;

import dev.wkwk.tasks.domain.entity.Task;
import dev.wkwk.tasks.domain.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.security.Principal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tasks")
@Slf4j
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> findAll(@AuthenticationPrincipal(expression = "attributes['unique_name']") String userId) {
        return this.taskService.findAll(userId);
    }

    @GetMapping("{id}")
    public Task findOne(@AuthenticationPrincipal(expression = "attributes['unique_name']") String userId,
                        @PathVariable("id") String id) {
        return this.taskService.findById(id, userId);
    }

    @PostMapping
    public ResponseEntity<Task> create(@AuthenticationPrincipal(expression = "attributes['unique_name']") String userId,
                                       @RequestBody Task task, UriComponentsBuilder uriComponentsBuilder) {
        task.setUserId(userId);
        this.taskService.create(task);
        URI uri = uriComponentsBuilder.path("/tasks/{id}").build().expand(task.getId()).toUri();
        return ResponseEntity.created(uri).body(task);
    }

    @PutMapping("{id}")
    public ResponseEntity<Task> update(@AuthenticationPrincipal(expression = "attributes['unique_name']") String userId,
                                       @RequestBody Task task, UriComponentsBuilder uriComponentsBuilder) {
        if (!userId.equals(task.getUserId())) {
            throw new RuntimeException("invalid user");
        }
        this.taskService.update(task);
        return ResponseEntity.noContent().build();
    }
}
