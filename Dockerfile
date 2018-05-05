FROM java:8-jre
LABEL maintainer="Anmol Babu <anbabu@redhat.com>"

ADD target/hdd-java-istio-jar-with-dependencies.jar hdd-java-istio-jar-with-dependencies.jar
ENTRYPOINT ["java", "-jar", "hdd-java-istio-jar-with-dependencies.jar"]