package tt.authorization.service.impl;

import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import tt.authorization.dto.ApplicationDto;
import tt.authorization.dto.HashApplicationDto;
import tt.authorization.service.TranslationService;

@Service
@RequiredArgsConstructor
public class TranslationServiceImpl implements TranslationService {

    private final WebClient webClient;
    private final Environment environment;

    @Override
    public Mono<ApplicationDto> createRequest(HashApplicationDto hashApplicationDto) {
        var translationServiceUrl =
            Objects.requireNonNull(environment.getProperty("TRANSLATION_SERVICE_URL"));

        return webClient
            .post()
            .uri(translationServiceUrl, uriBuilder ->
                uriBuilder
                    .path("api/v1/applications")
                    .build())
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromValue(hashApplicationDto))
            .retrieve()
            .bodyToMono(ApplicationDto.class);
    }

    @Override
    public Mono<ApplicationDto> getApplication(String id) {
        var translationServiceUrl =
            Objects.requireNonNull(environment.getProperty("TRANSLATION_SERVICE_URL"));

        return webClient
            .get()
            .uri(translationServiceUrl, uriBuilder ->
                uriBuilder
                    .path("api/v1/applications/")
                    .path(id)
                    .build())
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(ApplicationDto.class);
    }
}
