package com.bbva.smre.lib.rf10.local;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.bbva.smre.lib.rf10.helpers.LogerUtils;
import com.bbva.smre.lib.rf10.interfaces.IElasticHelper;
import com.bbva.smre.lib.rf10.values.SMRERF10Constants;
import com.bbva.smre.lib.rf10.values.SMRERF10Errors;
import com.bbva.smre.lib.rf10.values.ElasticQueries;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

/**
 * Servicio para consultar documentos en un Elasticsearch local utilizando Spring 4.
 */
public class ElasticSearchRepository implements IElasticHelper{

	private static final String INDEX_NAME = "i_smre_es_posit_coord_court_order_ai";
	
    // Configuración del endpoint local y el índice objetivo
    private static final String ELASTICSEARCH_URL       = "http://localhost:9200/"+INDEX_NAME+"/_search";
    private static final String ELASTICSEARCH_INDEX_URL = "http://localhost:9200/"+INDEX_NAME+"/_doc/";
    
    private final RestTemplate restTemplate;

    /**
     * Constructor que inyecta o inicializa el RestTemplate de Spring 4.
     */
    public ElasticSearchRepository() {
        this.restTemplate = new RestTemplate();
    }

    /**
     * Consulta un documento por el campo exacto idMAil (tipo keyword) y devuelve la respuesta en JSON.
     * 
     * @param idMail Valor del identificador de correo a buscar.
     * @return Cadena de texto en formato JSON con la respuesta de Elasticsearch.
     */
    public String getDocFromElastic(String idMail) {
    	if(idMail==null) {
    		return SMRERF10Errors.ERROR_ELASTIC;
    	}
        // 1. Configurar las cabeceras HTTP para enviar y recibir JSON
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // 2. Construir el cuerpo de la query DSL de Elasticsearch usando un filtro exacto (term)
        
        String jsonQuery = String.format(ElasticQueries.ELA_SEARCH_BY_ID, idMail);
        LogerUtils.textLog("Consulta JSON para Elasticsearch: {}", jsonQuery);
        
        // 3. Crear la entidad HTTP combinando las cabeceras y el cuerpo del JSON
        HttpEntity<String> entity = new HttpEntity<>(jsonQuery, headers);
        
        try {
            // 4. Realizar la petición POST al Elasticsearch local esperando un String (JSON)
            ResponseEntity<String> response = restTemplate.postForEntity(ELASTICSEARCH_URL, entity, String.class);
            
            // 5. Retornar el cuerpo de la respuesta que ya viene en formato JSON
            return response.getBody();
            
        } catch (RestClientException e) {
        	LogerUtils.textError("Error al consultar Elasticsearch: {}", e.getMessage());
            // Manejo básico de errores de conexión o de sintaxis en la consulta
            return SMRERF10Errors.ERROR_ELASTIC;
        }
    }

    public String genDocToElastic(String idMail) {
		if(idMail==null) {
			return SMRERF10Errors.ERROR_ELASTIC;
		}
		
		String jsonDoc = String.format(ElasticQueries.ELA_I, 
				"2026-06-03T16:54:00Z",
				"XE74158");
		
		return addDocToElastic(idMail, jsonDoc);
	}
    
    /**
     * Añade un documento a Elasticsearch con un ID específico.
     * 
     * @param id Identificador único del documento.
     * @param jsonDoc Contenido del documento en formato JSON.
     * @return Respuesta de Elasticsearch en formato JSON.
     */
    private String addDocToElastic(String id, String jsonDoc) {
        if (id == null || jsonDoc == null) {
            return SMRERF10Errors.ERROR_ELASTIC;
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(jsonDoc, headers);
        String url = ELASTICSEARCH_INDEX_URL + id;

        try {
            LogerUtils.textLog("Indexando documento en Elastic: URL={}", url);
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PUT, entity, String.class);
            return response.getBody();

        } catch (RestClientException e) {
            LogerUtils.textError("Error al indexar documento en Elasticsearch: {}", e.getMessage());
            return SMRERF10Errors.ERROR_ELASTIC;
        }
    }
    
    public void toTest() {
		String idMail = "test-mail-id-123";
		String response = genDocToElastic(idMail);
		LogerUtils.textLog("Respuesta al indexar documento: {}", response);
		
		String elasticResponse = getDocFromElastic(idMail);
		LogerUtils.textLog("Respuesta al consultar documento: {}", elasticResponse);
		addDocToElastic(null,null);
		addDocToElastic(idMail,null);
		addDocToElastic(idMail, "{\"field\":\"value\"}");
		genDocToElastic(null);
		getDocFromElastic(null);
	}
    
    
}