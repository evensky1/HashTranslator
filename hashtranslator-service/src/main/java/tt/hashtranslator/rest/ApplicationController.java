package tt.hashtranslator.rest;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import tt.hashtranslator.dto.HashApplication;
import tt.hashtranslator.service.ApplicationService;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<List<String>> createApplication(@RequestBody HashApplication hashApplication) {

        return applicationService.handleApplication(hashApplication);
    }

}
