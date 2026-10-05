package com.tuempresa.proyecto.service;

import com.tuempresa.proyecto.model.ElasticResponse;
import com.tuempresa.proyecto.model.OficioJudicialDoc;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class ElasticSearchService {

    private final RestTemplate restTemplate;
    private final String elasticUrl = "http://localhost:9200/tu_nombre_de_indice/_search";

    public ElasticSearchService() {
        this.restTemplate = new RestTemplate();
    }

    public ElasticResponse<OficioJudicialDoc> buscarOficiosJudiciales(String fileId, int orderId, String orderTypeId) {
        
        // 1. Construcción del cuerpo JSON de la Query idéntica a Bruno
        Map<String, Object> queryBody = Map.of(
            "query", Map.of(
                "bool", Map.of(
                    "must", List.of(
                        Map.of("term", Map.of("judicial_file_id", Map.of("value", fileId))),
                        Map.of("term", Map.of("court_order_id", Map.of("value", orderId))),
                        Map.of("term", Map.of("court_order_type_id", Map.of("value", orderTypeId)))
                    )
                )
            )
        );

        // 2. Configuración de cabeceras requeridas para Spring 5
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(queryBody, headers);

        // 3. Ejecución de la llamada HTTP POST mapeando al tipo genérico
        ResponseEntity<ElasticResponse<OficioJudicialDoc>> response = restTemplate.exchange(
                elasticUrl,
                HttpMethod.POST,
                entity,
                new ParameterizedTypeReference<ElasticResponse<OficioJudicialDoc>>() {}
        );

        return response.getBody();
    }
}
