package org.ljy.awscloudetc;

import ca.pjer.logback.AwsLogsAppender;
import org.ljy.awscloudetc.api.cloudwatch.AwsLogsAppenderCustom;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AwsCloudEtcApplication {

    public static void main(String[] args) {


        SpringApplication.run(AwsCloudEtcApplication.class, args);



    }



}
