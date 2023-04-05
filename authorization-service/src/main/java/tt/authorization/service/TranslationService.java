package tt.authorization.service;

import reactor.core.publisher.Mono;
import tt.authorization.dto.ApplicationDto;
import tt.authorization.dto.HashApplicationDto;

public interface TranslationService {

   Mono<ApplicationDto> createRequest(HashApplicationDto hashApplicationDto);
   Mono<ApplicationDto> getApplication(String id);
}
