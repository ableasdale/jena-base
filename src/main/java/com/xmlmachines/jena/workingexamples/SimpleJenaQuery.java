package com.xmlmachines.jena.workingexamples;

import com.xmlmachines.jena.util.SparqlEndpoints;
import com.xmlmachines.jena.util.SparqlQueries;
import org.apache.jena.query.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ableasdale on 19/03/2016.
 */
public class SimpleJenaQuery {
    public static void main(String[] args) {

        Logger LOG = LoggerFactory.getLogger(SimpleJenaQuery.class);

        //QuerySolutionMap initialBinding = new QuerySolutionMap();
        //initialBinding.add("name", personResource);
        //qe = QueryExecutionFactory.create(query, dataset, initialBinding);

        Query query = QueryFactory.create(SparqlQueries.LINKED_GEODATA_SELECT);
        QueryExecution qexec = QueryExecutionFactory.sparqlService(SparqlEndpoints.LINKED_GEODATA_SPARQL_ENDPOINT, query);


        LOG.info(ResultSetFormatter.asText(qexec.execSelect()));
    }
}

