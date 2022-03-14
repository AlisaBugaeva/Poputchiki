call mvn clean package
call docker build . --rm -t abugaeva/poputchiki-app:1.0
#call docker push abugaeva/poputchiki-app:1.0