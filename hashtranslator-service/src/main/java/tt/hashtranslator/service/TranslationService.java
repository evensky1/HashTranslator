package tt.hashtranslator.service;

import reactor.core.publisher.Mono;

public interface TranslationService {

    Mono<String> translateHash(String hash);
}
