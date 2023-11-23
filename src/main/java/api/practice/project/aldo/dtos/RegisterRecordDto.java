package api.practice.project.aldo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterRecordDto(@NotBlank String nome, @NotBlank String email, @NotNull Integer cpf) {
}
