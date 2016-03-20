package com.xmlmachines.jena;

import com.xmlmachines.jena.util.Consts;
import com.xmlmachines.jena.util.SparqlQueries;
import org.apache.jena.query.*;
import org.apache.jena.sparql.engine.http.QueryEngineHTTP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * FAILS Sort of works - we're getting data over the wire - SPARQL Query works if you use the endpoint (Web Interface) but the service returns nothing
 *
 * Created by ableasdale on 20/03/2016.
 * Not getting anything back from the endpoint
 */
public class Soton {
    public static void main(String[] args) {
        Logger LOG = LoggerFactory.getLogger(Soton.class);

        //Query query = QueryFactory.create(SparqlQueries.SELECT_FIRST_TEN);
       // Query query = QueryFactory.create(SparqlQueries.THREE_SUBJECT_URIS);
        Query query = QueryFactory.create(SparqlQueries.FIVE_PREDICATE_URIS);
//        QueryExecution qexec = new QueryEngineHTTP(sparqlEndPoint, qString3) ;

        try (QueryExecution qexec = //new QueryEngineHTTP(Consts.SOUTHAMPTON_UNI_SPARQL_ENDPOINT, query)){
                     QueryExecutionFactory.sparqlService(Consts.SOUTHAMPTON_UNI_SPARQL_ENDPOINT, query)) {
            ResultSet results = qexec.execSelect();
            for (; results.hasNext(); ) {
                QuerySolution qs = results.nextSolution();
                //LOG.info(qs.get().toString());
            }
            LOG.info(ResultSetFormatter.asText(results));
        }

    }
}
