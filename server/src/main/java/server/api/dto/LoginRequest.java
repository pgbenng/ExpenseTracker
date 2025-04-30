package server.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
        @JsonProperty("email") @Email String email,
        @JsonProperty("password") @NotBlank String password
) {
}
