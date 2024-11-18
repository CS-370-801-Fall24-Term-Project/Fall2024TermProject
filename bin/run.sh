#!/bin/bash

ROOT_DIR=$(pwd)

function buildAndRunClient() {
    cd $ROOT_DIR/weather/client/weather-client
    npm run start &
}

function buildAndRunServer() {
    cd $ROOT_DIR/weather/weather
    mvn spring-boot:run &
}

buildAndRunClient
buildAndRunServer

wait
