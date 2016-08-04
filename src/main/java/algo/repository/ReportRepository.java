package algo.repository;

import algo.model.ClientType;
import algo.model.Report;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReportRepository extends MongoRepository<Report, String> {

    List<Report> findByTypeAndSampleSize(ClientType type,
                                         Integer sampleSize);
}
