package dev.wkwk.tasks.domain.service;

import dev.wkwk.tasks.domain.entity.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    List<Task> findAll(String userId);

    Task findById(String id, String userId);

    void create(Task task);

    void update(Task task);
}
