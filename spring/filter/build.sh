#!/bin/bash

mvn install

docker build --build-arg JAR_FILE=filter-0.0.1.jar -t hipposareevil/filter:0.0.1 .
