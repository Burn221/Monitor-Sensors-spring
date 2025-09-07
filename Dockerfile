FROM maven:3.9.9-eclipse-temurin-17 AS builder
WORKDIR /opt/app

# по желанию: кэш зависимостей
COPY pom.xml .
RUN mvn -q -DskipTests dependency:go-offline

COPY src ./src
# собираем и кладём JAR в target/app.jar (берём не-original jar)
RUN mvn -q -DskipTests package \
 && cp $(ls target/*.jar | grep -v original | head -n 1) target/app.jar

FROM eclipse-temurin:17-jre-jammy
WORKDIR /opt/app
EXPOSE 8080

COPY --from=builder /opt/app/target/app.jar /opt/app/app.jar
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar /opt/app/app.jar"]