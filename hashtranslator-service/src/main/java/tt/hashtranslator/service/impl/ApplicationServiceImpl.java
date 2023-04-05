package tt.hashtranslator.service.impl;

import java.util.HashMap;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import tt.hashtranslator.document.Application;
import tt.hashtranslator.document.ApplicationStatus;
import tt.hashtranslator.dto.HashApplication;
import tt.hashtranslator.repository.ApplicationRepository;
import tt.hashtranslator.service.ApplicationService;
import tt.hashtranslator.service.TranslationService;

@Service
@RequiredArgsConstructor
@Slf4j
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final TranslationService translationService;

    @Override
    public Mono<Application> handleApplication(HashApplication hashApplication) {
        var application = Application.builder()
            .hashes(new HashMap<>())
            .status(ApplicationStatus.ACCEPTED)
            .build();

        return applicationRepository.save(application)
            .doOnSuccess(createdApplication ->
                processApplication(hashApplication.getHashes(), createdApplication));
    }

    @Override
    public Mono<Application> getApplication(String id) {
        return applicationRepository.findById(id);
    }

    private void processApplication(List<String> hashes, Application application) {

        translationService.translateHashes(hashes)
            .doOnNext(ent -> application.getHashes().put(ent.getKey(), ent.getValue()))
            .doOnComplete(() -> application.setStatus(ApplicationStatus.COMPLETE))
            .doOnError(e -> application.setStatus(ApplicationStatus.ERROR))
            .subscribe(
                entry -> log.info("Hash translated: {} -> {}", entry.getKey(), entry.getValue()),
                err -> log.error(err.getMessage()),
                () -> applicationRepository.save(application).subscribe()
            );
    }
}
