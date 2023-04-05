package tt.hashtranslator.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import tt.hashtranslator.document.Application;

@Repository
public interface ApplicationRepository extends ReactiveMongoRepository<Application, String> {

}
