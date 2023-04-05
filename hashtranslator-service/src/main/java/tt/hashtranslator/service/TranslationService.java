package tt.hashtranslator.service;

import java.util.List;
import java.util.Map.Entry;
import reactor.core.publisher.Flux;

public interface TranslationService {

    Flux<Entry<String, String>> translateHashes(List<String> hashes);
}
