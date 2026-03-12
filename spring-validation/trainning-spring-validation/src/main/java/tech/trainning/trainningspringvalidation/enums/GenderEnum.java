package tech.trainning.trainningspringvalidation.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@AllArgsConstructor
@Getter
public enum GenderEnum {

    MALE("M", "Male"),
    FEMALE("F", "Female"),
    UNKNOWN("UNK", "Unknown"),
    UNSPECIFIED("UNS", "Unspecified");

    private final String key;
    private final String value;

    @JsonCreator
    public static GenderEnum fromKey(String key) {
        for (GenderEnum gender: values()) {
            String currentGender = gender.getKey().toUpperCase();

            if (currentGender.equals(key)) {
                return gender;
            }
        }

        return null;
    }

    private static String getJSONParserErrorMessage(String key) {
        String message = "O GenderEnum não foi encontrado";

        if (Objects.nonNull(key) && !key.isBlank()) {
            message = "O GenderEnum ({0}) não foi encontrado";
        }

        return message;
    }

    @JsonValue
    public String getKey() {
        return key;
    }

}
