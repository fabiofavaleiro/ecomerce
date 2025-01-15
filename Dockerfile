# Usa a imagem oficial do JDK 17
FROM openjdk:17-jdk-slim
# Define o diretório de trabalho dentro do container
WORKDIR /app
# Copia o arquivo JAR gerado pela aplicação
COPY target/jdbc-project-1.0.jar app.jar
# Expõe a porta que a aplicação utiliza
EXPOSE 8080
# Comando para executar o JAR
ENTRYPOINT ["java", "-jar", "app.jar"]