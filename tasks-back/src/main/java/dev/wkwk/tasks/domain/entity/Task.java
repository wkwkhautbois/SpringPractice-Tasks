package dev.wkwk.tasks.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "task")
public class Task {
    @Id
    private String id;

    @NotBlank
    private String userId;

    @NotBlank
    private String title;

    private String description;

    private LocalDate deadline;
}
