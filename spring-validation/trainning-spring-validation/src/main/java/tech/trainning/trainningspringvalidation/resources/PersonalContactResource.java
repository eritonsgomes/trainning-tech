package tech.trainning.trainningspringvalidation.resources;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.trainning.trainningspringvalidation.dtos.requests.PersonalContactRequestDto;
import tech.trainning.trainningspringvalidation.dtos.responses.PersonalContactResponseDto;
import tech.trainning.trainningspringvalidation.services.PersonalContactService;

@Controller
@RequestMapping(value = "/contacts")
@RequiredArgsConstructor
public class PersonalContactResource {

    private final PersonalContactService service;

    @PostMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<PersonalContactResponseDto> createContact(
            @RequestBody PersonalContactRequestDto request
    ) {
        return ResponseEntity.ok(service.createResponse(request));
    }

}