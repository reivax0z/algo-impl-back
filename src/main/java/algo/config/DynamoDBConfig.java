package algo.config;

import com.amazonaws.regions.Region;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.util.StringUtils;

@Configuration
@EnableDynamoDBRepositories(basePackages = "algo.repository")
public class DynamoDBConfig {

	@Value("${amazon.dynamodb.endpoint}")
	private String dBEndpoint;

  	@Value("${region}")
  	private String region;

	@Bean
	public AmazonDynamoDB amazonDynamoDB() {
		final AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
				.withRegion(region)
				.build();

		if (!StringUtils.isNullOrEmpty(dBEndpoint)) {
			client.setEndpoint(dBEndpoint);
		}

		return client;
	}
}
