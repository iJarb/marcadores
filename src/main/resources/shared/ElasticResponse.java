package com.tuempresa.proyecto.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

// --- 1. OBJETO RAÍZ DE LA RESPUESTA DE ELASTICSEARCH ---
public class ElasticResponse<T> {
    private final int took;
    private final boolean timedOut;
    private final HitsContainer<T> hits;

    @JsonCreator
    public ElasticResponse(
            @JsonProperty("took") int took,
            @JsonProperty("timed_out") boolean timedOut,
            @JsonProperty("hits") HitsContainer<T> hits) {
        this.took = took;
        this.timedOut = timedOut;
        this.hits = hits;
    }

    public int getTook() { return took; }
    public boolean isTimedOut() { return timedOut; }
    public HitsContainer<T> getHits() { return hits; }
}

// --- 2. CONTENEDOR DE HITS ---
public class HitsContainer<T> {
    private final List<ElasticHit<T>> hits;

    @JsonCreator
    public HitsContainer(@JsonProperty("hits") List<ElasticHit<T>> hits) {
        this.hits = hits;
    }

    public List<ElasticHit<T>> getHits() { return hits; }
}

// --- 3. ENVOLTORIO INDIVIDUAL DEL DOCUMENTO (CONTIENE EL _ID) ---
public class ElasticHit<T> {
    private final String id;
    private final T source;

    @JsonCreator
    public ElasticHit(
            @JsonProperty("_id") String id,
            @JsonProperty("_source") T source) {
        this.id = id;
        this.source = source;
    }

    public String getId() { return id; } // Aquí obtendrás tu "buzon_correo/id_mail"
    public T getSource() { return source; }
}

// --- 4. DOCUMENTO DE TU EXCEL (OFICIO JUDICIAL) ---
public class OficioJudicialDoc {
    private final String judicialFileId;
    private final Integer courtOrderId;
    private final String courtOrderTypeId;
    private final List<OrganismoStr> organismStr;

    @JsonCreator
    public OficioJudicialDoc(
            @JsonProperty("judicial_file_id") String judicialFileId,
            @JsonProperty("court_order_id") Integer courtOrderId,
            @JsonProperty("court_order_type_id") String courtOrderTypeId,
            @JsonProperty("organism_str") List<OrganismoStr> organismStr) {
        this.judicialFileId = judicialFileId;
        this.courtOrderId = courtOrderId;
        this.courtOrderTypeId = courtOrderTypeId;
        this.organismStr = organismStr;
    }

    public String getJudicialFileId() { return judicialFileId; }
    public Integer getCourtOrderId() { return courtOrderId; }
    public String getCourtOrderTypeId() { return courtOrderTypeId; }
    public List<OrganismoStr> getOrganismStr() { return organismStr; }
}

// --- 5. SUBESTRUCTURA DE ORGANISMO ---
public class OrganismoStr {
    private final String puOrganismId;
    private final String puOrganismScopeId;

    @JsonCreator
    public OrganismoStr(
            @JsonProperty("pu_organism_id") String puOrganismId,
            @JsonProperty("pu_organism_scope_id") String puOrganismScopeId) {
        this.puOrganismId = puOrganismId;
        this.puOrganismScopeId = puOrganismScopeId;
    }

    public String getPuOrganismId() { return puOrganismId; }
    public String getPuOrganismScopeId() { return puOrganismScopeId; }
}
