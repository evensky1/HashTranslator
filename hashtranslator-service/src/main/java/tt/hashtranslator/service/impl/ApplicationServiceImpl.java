package tt.hashtranslator.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tt.hashtranslator.dto.HashApplication;
import tt.hashtranslator.service.ApplicationService;
import tt.hashtranslator.service.TranslationService;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final TranslationService translationService;

    @Override
    public Mono<List<String>> handleApplication(HashApplication hashApplication) {
        return Flux.fromIterable(hashApplication.getHashes())
            .flatMap(translationService::translateHash)
            .collectList();
    }
}
