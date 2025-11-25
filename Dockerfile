# ----------------------------------------
# ETAPA 1: Construcción (Build)
# ----------------------------------------
# Usamos una imagen de Maven con Java 17 para compilar el proyecto
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

# Copiamos todos los archivos del proyecto al contenedor
COPY . .

# Ejecutamos el comando de compilación (saltando los tests para agilizar el despliegue)
RUN mvn clean package -DskipTests

# ----------------------------------------
# ETAPA 2: Ejecución (Run)
# ----------------------------------------
# Usamos una imagen ligera de Java 17 para ejecutar la app
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copiamos el archivo .jar generado en la etapa anterior
# IMPORTANTE: El nombre 'citas-0.0.1-SNAPSHOT.jar' coincide con tu pom.xml (artifactId + version)
COPY --from=build /app/target/citas-0.0.1-SNAPSHOT.jar app.jar

# Exponemos el puerto 8080 (donde corre Spring Boot por defecto)
EXPOSE 8080

# Comando para iniciar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]