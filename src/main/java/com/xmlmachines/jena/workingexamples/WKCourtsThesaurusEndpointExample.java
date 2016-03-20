package com.xmlmachines.jena.workingexamples;

import com.xmlmachines.jena.util.SparqlEndpoints;
import com.xmlmachines.jena.util.SparqlQueries;
import org.apache.jena.query.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ableasdale on 20/03/2016.
 */
public class WKCourtsThesaurusEndpointExample {
    public static void main(String[] args) {
        Logger LOG = LoggerFactory.getLogger(WKCourtsThesaurusEndpointExample.class);
        String queryString = "PREFIX skos:<http://www.w3.org/2004/02/skos/core#>\n" +
                "SELECT DISTINCT ?Concept ?prefLabel\n" +
                "WHERE\n" +
                "{ ?Concept ?x skos:Concept .\n" +
                "{ ?Concept skos:prefLabel ?prefLabel . FILTER (regex(str(?prefLabel), '^a.*', 'i'))  }\n" +
                "} ORDER BY ?prefLabel LIMIT 50 OFFSET 0";

        String moreComplexQuery = "PREFIX skos:<http://www.w3.org/2004/02/skos/core#>\n" +
                "SELECT ?prefLabel ?altLabel ?scopeNote\n" +
                "WHERE\n" +
                "{\n" +
                "?s skos:prefLabel ?prefLabel .\n" +
                "?s skos:altLabel ?altLabel .\n" +
                "?s skos:scopeNote ?scopeNote .\n" +
                " } LIMIT 50 OFFSET 0";

        Query query = QueryFactory.create(moreComplexQuery);
        //Query query = QueryFactory.create(SparqlQueries.SELECT_DISTINCT_CONCEPTS);
        QueryExecution qexec = QueryExecutionFactory.sparqlService(SparqlEndpoints.COURTS_THESAURUS_SPARQL_ENDPOINT, query);
        LOG.info(ResultSetFormatter.asText(qexec.execSelect()));
    }
}
