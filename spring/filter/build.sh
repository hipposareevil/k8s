#!/bin/bash

version="0.0.2"

mvn install

docker build --build-arg JAR_FILE=filter-${version}.jar -t hipposareevil/filter:${version} .
