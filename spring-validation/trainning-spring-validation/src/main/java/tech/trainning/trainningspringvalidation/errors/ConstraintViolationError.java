package tech.trainning.trainningspringvalidation.errors;


import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@Getter
public class ConstraintViolationError extends AbstractError<List<ConstraintViolationMessage>> {

    public ConstraintViolationError(
            Instant timestamp, Integer status, String error, List<ConstraintViolationMessage> errors, String path
    ) {
        super(timestamp, status, error, errors, path);
    }

    public void addError(String message) {
        var error = ConstraintViolationMessage.builder()
                .messages(List.of(message))
                .build();

        errors.add(error);
    }

    public void addError(String fieldName, String message) {
        var errorFound = findByFieldName(fieldName);

        if (errorFound.isPresent()) {
            var error = errorFound.get();
            error.addMessage(message);
        } else {
            var error = ConstraintViolationMessage.builder()
                    .fieldName(fieldName)
                    .messages(List.of(message))
                    .build();

            this.errors.add(error);
        }
    }

    public Optional<ConstraintViolationMessage> findByFieldName(String fieldName) {
        return this.errors.stream().filter(err ->
                err.getFieldName().equals(fieldName)
        ).findFirst();
    }

}
