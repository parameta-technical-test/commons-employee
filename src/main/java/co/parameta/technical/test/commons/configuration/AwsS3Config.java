package co.parameta.technical.test.commons.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

/**
 * AWS S3 configuration class.
 * <p>
 * This configuration defines the {@link S3Client} bean used to interact with
 * Amazon S3 services. The AWS region is loaded from external configuration
 * to support different environments.
 */
@Configuration
public class AwsS3Config {

    /**
     * AWS region where the S3 bucket is located.
     */
    @Value("${aws.region}")
    private String region;

    /**
     * Creates and configures an {@link S3Client} instance.
     * <p>
     * The client is configured using the region provided through
     * application properties or environment variables.
     *
     * @return configured {@link S3Client}
     */
    @Bean
    public S3Client s3Client() {
        return S3Client.builder()
                .region(Region.of(region))
                .build();
    }

}
