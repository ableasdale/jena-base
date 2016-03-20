package com.xmlmachines.jena.workingexamples;

import com.xmlmachines.jena.util.SparqlEndpoints;
import com.xmlmachines.jena.util.SparqlQueries;
import org.apache.jena.query.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ableasdale on 20/03/2016.
 */
public class IBMRJKBExplorerEndpointExample {

    public static void main(String[] args) {
        Logger LOG = LoggerFactory.getLogger(IBMRJKBExplorerEndpointExample.class);

        String queryString = "PREFIX id:   <http://ibm.rkbexplorer.com/id/>\n" +
                "PREFIX rdf:  <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                "PREFIX akt:  <http://www.aktors.org/ontology/portal#>\n" +
                "PREFIX owl:  <http://www.w3.org/2002/07/owl#>\n" +
                "PREFIX akt:  <http://www.aktors.org/ontology/portal#>\n" +
                "PREFIX akts: <http://www.aktors.org/ontology/support#>\n" +
                "\n" +
                "SELECT * WHERE { ?s rdfs:label ?o } LIMIT 100";

        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.sparqlService(SparqlEndpoints.IBM_RKBEXPLORER_SPARQL_ENDPOINT, query);
        LOG.info(ResultSetFormatter.asText(qexec.execSelect()));
    }

}
