#!/bin/bash

mvn install

docker build --build-arg JAR_FILE=simple-0.0.1.jar -t hipposareevil/simple:0.0.1 .
