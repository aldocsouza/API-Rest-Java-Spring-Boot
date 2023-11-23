package api.practice.project.aldo.dtos;

import jakarta.validation.constraints.NotBlank;


public record ClientRecordDto(@NotBlank String name) {
}
