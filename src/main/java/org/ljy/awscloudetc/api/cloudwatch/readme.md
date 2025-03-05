1. AwsLogsAppender 를상속받아 AwsLogsAppenderCustom 클래스 생성
2. 위 AwsLogsAppenderCustom 클래스에서 logStreamName 에 [date] 의 문자열이있을시에 날짜로 replace 
3. dockerfile 로 이미지화 하고 , run 할때에 aws 의 credentials 가 필요하기떄문에 mount 한다. 
4. 여러 이미지 ( 인스턴스 ) : logstream  [ 1:N ]구조로 잘 들어가는것 확인했음
5. screenshot 폴더 _log 적재결과.png 확인


docker build -t <ImageName>:latest .
docker run -v $HOME/.aws:/root/.aws -e <변수key>=<변수value> <ImageName>