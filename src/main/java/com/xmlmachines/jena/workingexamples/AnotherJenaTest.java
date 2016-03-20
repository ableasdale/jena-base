package com.xmlmachines.jena.workingexamples;

import com.xmlmachines.jena.util.SparqlEndpoints;
import com.xmlmachines.jena.util.SparqlQueries;
import org.apache.jena.query.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ableasdale on 20/03/2016.
 */
public class AnotherJenaTest {

    private static Logger LOG = LoggerFactory.getLogger(AnotherJenaTest.class);

    public static void main(String[] args) {
        LOG.info("test");
        String queryString =
                "PREFIX p: <http://dbpedia.org/property/>" +
                        "PREFIX dbpedia: <http://dbpedia.org/resource/>" +
                        "PREFIX category: <http://dbpedia.org/resource/Category:>" +
                        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
                        "PREFIX skos: <http://www.w3.org/2004/02/skos/core#>" +
                        "PREFIX geo: <http://www.georss.org/georss/>" +

                        "SELECT DISTINCT ?m ?n ?p ?d" +
                        "WHERE {" +
                        " ?m rdfs:label ?n." +
                        " ?m skos:subject ?c." +
                        " ?c skos:broader category:Churches_in_Paris." +
                        " ?m p:abstract ?d." +
                        " ?m geo:point ?p" +
                        " FILTER ( lang(?n) = 'fr' )" +
                        " FILTER ( lang(?d) = 'fr' )" +
                        " }";

        Query query = QueryFactory.create(SparqlQueries.SELECT_DISTINCT_CONCEPTS);
        QueryExecution qexec = QueryExecutionFactory.sparqlService(SparqlEndpoints.DBPEDIA_SPARQL_ENDPOINT, query);


        LOG.info(ResultSetFormatter.asText(qexec.execSelect()));
//after it goes standard query execution and result processing which can
// be found in almost any Jena/SPARQL tutorial.
//        try {
//            ResultSet results = qexec.execSelect();
//            for (; results.hasNext();) {
//                LOG.info("x");
//
//                // Result processing is done here.
//            }
//        }
//        finally {
//            qexec.close();
//        }
//    }
    }
}
