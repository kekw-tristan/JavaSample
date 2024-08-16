# Build Image - referencable by build
FROM maven:3.9.7-eclipse-temurin-17-focal as build
WORKDIR /workspace/app

# COPY Module POMs
COPY storage/pom.xml storage/pom.xml
COPY api/pom.xml api/pom.xml

# COPY Parent POM
COPY pom.xml pom.xml
# Execute maven dependencies
RUN mvn dependency:go-offline

# COPY sources
COPY storage/src storage/src
COPY api/src api/src

# Jar packen
RUN mvn package -DskipTests

# Final image
FROM eclipse-temurin:17-jre-ubi9-minimal
ARG DEPENDENCY=/workspace/app/api/target

# Copy build results
WORKDIR /app
COPY --from=build ${DEPENDENCY}/lib ./lib
COPY --from=build ${DEPENDENCY}/lat-api.jar .

# Specify listening port
EXPOSE 8080

ENTRYPOINT ["java", "-cp", "lat-api.jar:lib/*", "de.fherfurt.lat.api.WebApplication"]