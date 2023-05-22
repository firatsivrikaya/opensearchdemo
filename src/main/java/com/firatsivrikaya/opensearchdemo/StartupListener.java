package com.firatsivrikaya.opensearchdemo;

import lombok.SneakyThrows;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.opensearch.indices.CreateIndexRequest;
import org.opensearch.client.opensearch.indices.CreateIndexResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class StartupListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private OpenSearchClient openSearchClient;

    @SneakyThrows
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        String index = "sample-index";
        CreateIndexRequest createIndexRequest = new CreateIndexRequest.Builder().index(index).build();
        CreateIndexResponse createIndexResponse = openSearchClient.indices().create(createIndexRequest);
    }
}
