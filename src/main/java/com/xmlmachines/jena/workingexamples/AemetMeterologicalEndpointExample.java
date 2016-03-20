package com.xmlmachines.jena.workingexamples;

import com.xmlmachines.jena.util.SparqlEndpoints;
import com.xmlmachines.jena.util.SparqlQueries;
import org.apache.jena.query.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AemetMeterologicalEndpointExample
 * AEMET metereological dataset
 *
 * Created by ableasdale on 20/03/2016.
 */
public class AemetMeterologicalEndpointExample {
    public static void main(String[] args) {
        Logger LOG = LoggerFactory.getLogger(AemetMeterologicalEndpointExample.class);
        Query query = QueryFactory.create(SparqlQueries.SELECT_DISTINCT_CONCEPTS);
        QueryExecution qexec = QueryExecutionFactory.sparqlService(SparqlEndpoints.AEMET_METEROLOGICAL_DATASET_SPARQL_ENDPOINT, query);
        LOG.info(ResultSetFormatter.asText(qexec.execSelect()));
    }
}
