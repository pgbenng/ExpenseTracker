package server.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AuthResponse(
        @JsonProperty("accessToken") String token,
        @JsonProperty("tokenType") String type
) {
}
