package tt.hashtranslator.service.impl;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import java.util.Map.Entry;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tt.hashtranslator.service.TranslationService;

@Service
@RequiredArgsConstructor
public class TranslationServiceImpl implements TranslationService {

    private final WebClient webClient;
    private final Environment environment;

    @Override
    public Flux<Entry<String, String>> translateHashes(List<String> hashes) {

        return Flux.fromIterable(hashes).flatMap(this::translateHash);
    }

    private Mono<Entry<String, String>> translateHash(String hash) {
        return webClient
            .get()
            .uri("https://md5decrypt.net/en/Api/api.php", uriBuilder ->
                uriBuilder
                    .queryParam("hash", hash)
                    .queryParam("hash_type", environment.getProperty("HASH_TYPE"))
                    .queryParam("email", environment.getProperty("EMAIL"))
                    .queryParam("code", environment.getProperty("SECRET_KEY"))
                    .build())
            .retrieve()
            .bodyToMono(String.class)
            .map(res -> new SimpleEntry<>(hash, res));
    }
}
