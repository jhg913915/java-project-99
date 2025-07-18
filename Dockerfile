FROM gradle:8.10.0-jdk21

WORKDIR /

COPY / .

RUN gradle installDist

EXPOSE 8080

CMD ./build/install/app/bin/app