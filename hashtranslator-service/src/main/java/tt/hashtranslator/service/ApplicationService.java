package tt.hashtranslator.service;

import java.util.List;
import reactor.core.publisher.Mono;
import tt.hashtranslator.dto.HashApplication;

public interface ApplicationService {

    Mono<List<String>> handleApplication(HashApplication hashApplication);
}
