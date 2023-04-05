package tt.hashtranslator.rest;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import tt.hashtranslator.document.Application;
import tt.hashtranslator.dto.HashApplication;
import tt.hashtranslator.service.ApplicationService;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mono<Application> createApplication(@RequestBody HashApplication hashApplication) {

        return applicationService.handleApplication(hashApplication);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Application> getApplication(@PathVariable("id") String id) {

        return applicationService.getApplication(id);
    }
}
