package org.ljy.awscloudetc.api.cloudwatch;

import ca.pjer.logback.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
public class AwsLogsAppenderCustom extends AwsLogsAppender {

    public void setLogStreamName(String logStreamName){

        if (logStreamName != null) {
            if (logStreamName.contains("[date]")) {
                LocalDateTime localDateTime = LocalDateTime.now();
                // ✅ DateTimeFormatter 사용하여 "yyyy-MM-dd" 형식 적용
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                logStreamName = logStreamName.replace("[date]", localDateTime.format(formatter));
            }
            super.setLogStreamName(logStreamName);  // 🔹 부모 클래스의 setLogStreamName() 호출
        }
    }
}