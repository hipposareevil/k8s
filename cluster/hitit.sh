#!/bin/bash

GREEN_ENDPOINT="https://simple-test.dausw2-1.k8s.platform.einstein.com/green"
BLUE_ENDPOINT="https://simple-test.dausw2-1.k8s.platform.einstein.com/blue"


hit() {
    endpoint="$1"
    echo "[Hitting '${endpoint}']"
    fortio load -quiet -k -qps 10 -c 10 -t 5s
}

hit $GREEN_ENDPOINT
hit $BLUE_ENDPOINT
