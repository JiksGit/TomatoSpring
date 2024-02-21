package tomato.classifier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tomato.classifier.entity.Disease;

public interface DiseaseRepository extends JpaRepository<Disease, String> {
}
