package tech.trainning.trainningspringvalidation.errors;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Builder
public class ConstraintViolationMessage {

    private String fieldName;
    private List<String> messages;

    public ConstraintViolationMessage(String fieldName, List<String> messages) {
        this.fieldName = fieldName;
        this.messages = createMessages(messages);
    }

    private List<String> createMessages(List<String> messages) {
        if (Objects.isNull(messages)) {
            return new ArrayList<>();
        }

        return messages;
    }

    public void addMessage(String message) {
        var messages = new ArrayList<>(this.messages);
        messages.add(message);
        this.messages = messages;
    }
}