package tt.hashtranslator.service;

import reactor.core.publisher.Mono;
import tt.hashtranslator.document.Application;
import tt.hashtranslator.dto.HashApplication;

public interface ApplicationService {

    Mono<Application> handleApplication(HashApplication hashApplication);
    Mono<Application> getApplication(String id);
}
