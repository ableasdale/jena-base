package com.xmlmachines.jena.workingexamples;

import com.xmlmachines.jena.util.SparqlEndpoints;
import com.xmlmachines.jena.util.SparqlQueries;
import org.apache.jena.query.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ableasdale on 20/03/2016.
 */
public class ImageSnippetsEndpointExample {
    public static void main(String[] args) {
        Logger LOG = LoggerFactory.getLogger(ImageSnippetsEndpointExample.class);
        Query query = QueryFactory.create(SparqlQueries.SELECT_DISTINCT_CONCEPTS);
        QueryExecution qexec = QueryExecutionFactory.sparqlService(SparqlEndpoints.IMAGESNIPPETS_SPARQL_ENDPOINT, query);
        LOG.info(ResultSetFormatter.asText(qexec.execSelect()));
    }

}
