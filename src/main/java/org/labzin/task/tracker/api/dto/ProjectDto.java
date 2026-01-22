package org.labzin.task.tracker.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class ProjectDto {

    @NotNull
    private Long id;

    @NotNull
    private String name;

    @NotNull
    @JsonProperty("created_at")
    Instant createdAt;
}
