# Observability Lab

- **Goal** → apply observability on metrics and logs using prometheus, loki and grafana on a spring boot backend application
- **Application** **repository** → https://github.com/Mahmoud-Shereif/observability-lab.git
- **Lab architecture** →
- **Guidelines**:
    - Implement the lab on your local machine.
    - Try if possible to split every service on a separate docker-compose file.
- **Useful links**:
    1. **Prometheus and Node-Exporter**:
    [https://grafana.com/docs/grafana-cloud/quickstart/docker-compose-linux/#step-1-create-the-compose-file](https://grafana.com/docs/grafana-cloud/quickstart/docker-compose-linux/#step-1-create-the-compose-file)
    2. **Micrometer (Implemented in Spring boot app)**:
    [https://www.tutorialworks.com/spring-boot-prometheus-micrometer/](https://www.tutorialworks.com/spring-boot-prometheus-micrometer/)
    3. **Promtail, Loki and grafana**:
    https://github.com/shazforiot/Promtail-Loki-Grafana-using-Docker-Compose
    4. **Grafana dashboards to import**:
    [https://grafana.com/grafana/dashboards/1860-node-exporter-full/](https://grafana.com/grafana/dashboards/1860-node-exporter-full/)
    [https://grafana.com/grafana/dashboards/11378-justai-system-monitor/](https://grafana.com/grafana/dashboards/11378-justai-system-monitor/)
    [https://grafana.com/grafana/dashboards/12611-logging-universal-dashboard/](https://grafana.com/grafana/dashboards/12611-logging-universal-dashboard/)
- **Hints**:
    - Make the network of each service host
    - Take care with volumes’ paths in the docker-compose

- We should have two docker composes:
    1.  First docker compose
        1. spring boot application + micrometer 
        2. node exporter
        3. promtail
    2. Second docker compose
        1. prometheus
        2. loki
        3. grafana
    
1. Micrometer
    - add micrometer configurations
        
        [https://www.tutorialworks.com/spring-boot-prometheus-micrometer/](https://www.tutorialworks.com/spring-boot-prometheus-micrometer/)
        
    
2. Prometheus
    - add prometheus service in the second docker compose
        
        [https://grafana.com/docs/grafana-cloud/quickstart/docker-compose-linux/#step-1-create-the-compose-file](https://grafana.com/docs/grafana-cloud/quickstart/docker-compose-linux/#step-1-create-the-compose-file)
        
    - add prometheus.yml and specify the targets
        - should specify three targets
            1. prometheus itself
            2. node exporter
            3. spring boot app
        
        [https://grafana.com/docs/grafana-cloud/quickstart/docker-compose-linux/#step-2-create-the-prometheus-configuration-file](https://grafana.com/docs/grafana-cloud/quickstart/docker-compose-linux/#step-2-create-the-prometheus-configuration-file)
        
        [https://www.callicoder.com/spring-boot-actuator-metrics-monitoring-dashboard-prometheus-grafana/#2-prometheus-configuration-prometheusyml](https://www.callicoder.com/spring-boot-actuator-metrics-monitoring-dashboard-prometheus-grafana/#2-prometheus-configuration-prometheusyml)
        
    
3. Promtail
    - create promtail service in the first docker compose
    - add promtail.yml and specify the loki url that will push logs to
        
        [https://github.com/shazforiot/Promtail-Loki-Grafana-using-Docker-Compose](https://github.com/shazforiot/Promtail-Loki-Grafana-using-Docker-Compose)
        
4. Loki
    - create loki service in the second docker compose
    - add loki.yml
        
        [https://github.com/shazforiot/Promtail-Loki-Grafana-using-Docker-Compose](https://github.com/shazforiot/Promtail-Loki-Grafana-using-Docker-Compose)
        

1. Grafana
    - create grafana service in the second docker compose
        
        [https://github.com/shazforiot/Promtail-Loki-Grafana-using-Docker-Compose](https://github.com/shazforiot/Promtail-Loki-Grafana-using-Docker-Compose)
        

- create datasources
- create dashboards
- create alerts
