package dev.wkwk.tasks.domain.service;

import dev.wkwk.tasks.domain.entity.Task;
import dev.wkwk.tasks.domain.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public List<Task> findAll(String userId) {
        return this.taskRepository.findByUserId(userId);
    }

    @Override
    public Task findById(String id, String userId) {
        Optional<Task> result = this.taskRepository.findByIdAndUserId(id, userId);
        return result.orElseThrow(() -> new RuntimeException("task not found"));
    }

    @Override
    public void create(Task task) {
        UUID uuid = UUID.randomUUID();
        task.setId(uuid.toString());

        this.taskRepository.save(task);
    }

    @Override
    public void update(Task task) {
        // ユーザー確認は手抜き
        if (this.taskRepository.findByIdAndUserId(task.getId(), task.getUserId()).isPresent()) {
            this.taskRepository.save(task);
        }
    }
}
