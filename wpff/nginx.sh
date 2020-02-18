helm install ingressit stable/nginx-ingress --set controller.service.ports.http=8888 --set controller.service.ports.https=444
