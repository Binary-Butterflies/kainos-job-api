FROM maven:latest
WORKDIR /code
COPY . /code
RUN mvn clean install -DskipTests=true
EXPOSE 8080

ARG TOKEN_LIFETIME
ARG JWT_ISSUER

ARG DB_HOST
ARG DB_PASSWORD
ARG DB_USERNAME
ARG DB_NAME

ARG AUTH_TEST_PASS_HASH
ARG AUTH_TEST_PASS_SALT

ARG PASS_SALT_LENGTH
ARG PASS_HASH_LENGTH
ARG PASS_HASH_ALGORITHM
ARG PASS_HASH_ITERATIONS

ARG TEST_USER_EMAIL
ARG TEST_USER_PASSWORD

ENV DB_HOST ${DB_HOST}
ENV DB_PASSWORD ${DB_PASSWORD}
ENV DB_USERNAME ${DB_USERNAME}
ENV DB_NAME ${DB_NAME}

ENV TOKEN_LIFETIME ${TOKEN_LIFETIME}
ENV JWT_ISSUER ${JWT_ISSUER}

ENV DB_HOST ${DB_HOST}
ENV DB_PASSWORD ${DB_PASSWORD}
ENV DB_USERNAME ${DB_USERNAME}
ENV DB_NAME ${DB_NAME}

ENV AUTH_TEST_PASS_HASH ${AUTH_TEST_PASS_HASH}
ENV AUTH_TEST_PASS_SALT ${AUTH_TEST_PASS_SALT}

ENV PASS_SALT_LENGTH ${PASS_SALT_LENGTH}
ENV PASS_HASH_LENGTH ${PASS_HASH_LENGTH}
ENV PASS_HASH_ALGORITHM ${PASS_HASH_ALGORITHM}
ENV PASS_HASH_ITERATIONS ${PASS_HASH_ITERATIONS}

ENV TEST_USER_EMAIL ${TEST_USER_EMAIL}
ENV TEST_USER_PASSWORD ${TEST_USER_PASSWORD}

CMD ["java","-jar", "/code/target/kainos-job-api-1.0-SNAPSHOT.jar", "server", "/code/config.yml"]