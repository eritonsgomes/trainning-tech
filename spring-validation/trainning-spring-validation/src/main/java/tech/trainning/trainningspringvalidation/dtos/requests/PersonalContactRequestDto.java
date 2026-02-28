package tech.trainning.trainningspringvalidation.dtos.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.UUID;
import tech.trainning.trainningspringvalidation.dtos.deserializers.DoubleDeserializer;
import tech.trainning.trainningspringvalidation.enums.GenderEnum;
import tech.trainning.trainningspringvalidation.validators.GenderEnumConstraint;
import tools.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record PersonalContactRequestDto(
        @UUID(message = "{validation.constraints.uuid}")
        String uuid,
        @NotBlank(message = "{validation.constraints.not-blank}")
        @Size(min = 1, max = 250, message = "{validation.constraints.size}")
        String name,
        @NotBlank(message = "{validation.constraints.not-blank}")
        @Size(min = 8, max = 9, message = "{validation.constraints.size}")
        @Pattern(regexp="^\\d{8,9}$", message = "{validation.constraints.pattern}")
        String phoneNumber,
        @NotBlank(message = "{validation.constraints.not-blank}")
        @Email(message = "{validation.constraints.email}")
        String email,
        @NotNull(message = "{validation.constraints.not-null}")
        @PastOrPresent(message = "{validation.constraints.past-or-present}")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        LocalDate birthDate,
        @GenderEnumConstraint
        GenderEnum gender,
        @NotNull(message = "{validation.constraints.not-null}")
        @Digits(integer = 1, fraction = 2, message = "{validation.constraints.digits}")
        @JsonDeserialize(using = DoubleDeserializer.class)
        Double height
) {
}
