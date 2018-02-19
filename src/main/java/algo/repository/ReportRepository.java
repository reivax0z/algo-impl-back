package algo.repository;

import algo.model.Report;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@EnableScan
public interface ReportRepository extends CrudRepository<Report, String> {

    List<Report> findByTypeAndSampleSize(String type,
                                         Integer sampleSize);
}
