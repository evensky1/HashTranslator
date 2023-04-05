package tt.authorization.rest;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import tt.authorization.dto.ApplicationDto;
import tt.authorization.dto.HashApplicationDto;
import tt.authorization.service.TranslationService;

@RestController
@RequestMapping("api/v1/applications")
@AllArgsConstructor
@PreAuthorize("hasAuthority('USER')")
public class ApplicationController {

    private final TranslationService translationService;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mono<ApplicationDto> createApplication(
        @RequestBody HashApplicationDto hashApplicationDto) {

        return translationService.createRequest(hashApplicationDto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ApplicationDto> getApplication(@PathVariable("id") String id) {

        return translationService.getApplication(id);
    }
}
