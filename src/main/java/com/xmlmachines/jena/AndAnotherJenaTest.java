package com.xmlmachines.jena;

import org.apache.jena.query.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ableasdale on 20/03/2016.
 */
public class AndAnotherJenaTest {

    public static void main(String[] args) {

        Logger LOG = LoggerFactory.getLogger(AndAnotherJenaTest.class);

        Query query = QueryFactory.create("select distinct ?Concept where {[] a ?Concept } LIMIT 100");
        
        try (QueryExecution qexec = QueryExecutionFactory.sparqlService("http://dbpedia.org/sparql", query)) {
            ResultSet results = qexec.execSelect();
            for (; results.hasNext(); ) {
                QuerySolution qs = results.nextSolution();
                LOG.info(qs.get("Concept").toString());
            }
        }

    }
}

