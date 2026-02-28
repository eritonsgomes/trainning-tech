package tech.trainning.trainningspringvalidation.dtos.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import tech.trainning.trainningspringvalidation.enums.GenderEnum;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record PersonalContactResponseDto(
        UUID uuid,
        String name,
        String phoneNumber,
        String email,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        LocalDate birthDate,
        GenderEnum gender,
        Double height
) {
}
