package org.labzin.task.tracker.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {

    @NotNull
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Instant createdAt;

    @NotNull
    private String description;
}
