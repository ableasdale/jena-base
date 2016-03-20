package com.xmlmachines.jena.workingexamples;

import com.xmlmachines.jena.util.SparqlEndpoints;
import com.xmlmachines.jena.util.SparqlQueries;
import org.apache.jena.query.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Working
 *
 * Created by ableasdale on 20/03/2016.
 */
public class AndAnotherJenaTest {

    public static void main(String[] args) {

        Logger LOG = LoggerFactory.getLogger(AndAnotherJenaTest.class);

        Query query = QueryFactory.create(SparqlQueries.SELECT_DISTINCT_CONCEPTS);

        try (QueryExecution qexec = QueryExecutionFactory.sparqlService(SparqlEndpoints.DBPEDIA_SPARQL_ENDPOINT, query)) {
            ResultSet results = qexec.execSelect();
            for (; results.hasNext(); ) {
                QuerySolution qs = results.nextSolution();
                LOG.info(qs.get("Concept").toString());
            }
        }

    }
}

