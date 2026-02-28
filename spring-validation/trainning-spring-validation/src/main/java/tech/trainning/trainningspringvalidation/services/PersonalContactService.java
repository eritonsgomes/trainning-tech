package tech.trainning.trainningspringvalidation.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.trainning.trainningspringvalidation.dtos.requests.PersonalContactRequestDto;
import tech.trainning.trainningspringvalidation.dtos.responses.PersonalContactResponseDto;

import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonalContactService {

    public Integer randomId() {
        Random r = new Random();
        int min = 1;
        int max = Integer.MAX_VALUE;

        return r.nextInt((max - min) + 1) + min;
    }

    public UUID randomUUID() {
        return UUID.randomUUID();
    }

    public PersonalContactResponseDto createResponse(PersonalContactRequestDto request) {
        return PersonalContactResponseDto.builder()
                .uuid(this.randomUUID())
                .name(request.name())
                .email(request.email())
                .phoneNumber(request.phoneNumber())
                .birthDate(request.birthDate())
                .height(request.height())
                .build();
    }

}
