FROM openjdk:17
ADD target/Gem-Auction-0.0.1-SNAPSHOT.jar Gem-Auction-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/Gem-Auction-0.0.1-SNAPSHOT.jar"]