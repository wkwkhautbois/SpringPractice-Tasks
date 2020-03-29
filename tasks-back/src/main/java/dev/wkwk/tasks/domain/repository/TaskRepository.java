package dev.wkwk.tasks.domain.repository;

import dev.wkwk.tasks.domain.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, String> {

    List<Task> findByUserId(String userId);

    Optional<Task> findByIdAndUserId(String id, String userId);
}
