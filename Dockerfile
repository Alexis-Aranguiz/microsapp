# ----------------------------------------
# ETAPA 1: Construcción (Build)
# ----------------------------------------
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

# Copiamos todos los archivos del proyecto
COPY . .

# Compilamos el proyecto saltando los tests
RUN mvn clean package -DskipTests

# ----------------------------------------
# ETAPA 2: Ejecución (Run)
# ----------------------------------------
# CORRECCIÓN: Usamos 'eclipse-temurin' porque 'openjdk' fue eliminada
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app

# Copiamos el .jar generado (asegúrate que el nombre 'citas' coincide con tu pom.xml)
COPY --from=build /app/target/citas-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
