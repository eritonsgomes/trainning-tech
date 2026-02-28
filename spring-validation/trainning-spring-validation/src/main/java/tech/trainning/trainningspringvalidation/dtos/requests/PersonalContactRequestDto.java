package tech.trainning.trainningspringvalidation.dtos.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import tech.trainning.trainningspringvalidation.enums.GenderEnum;

import java.math.BigDecimal;
import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record PersonalContactRequestDto(
        String uuid,
        String name,
        String phoneNumber,
        String email,
        LocalDate birthDate,
        GenderEnum gender,
        BigDecimal height
) {
}
