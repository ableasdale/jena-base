package com.xmlmachines.jena.util;

/**
 * Created by ableasdale on 20/03/2016.
 */
public class SparqlQueries {

    public static String SELECT_DISTINCT_CONCEPTS = "select distinct ?Concept where {[] a ?Concept} LIMIT 200";
    public static String SELECT_FIRST_TEN = "SELECT * WHERE {?s ?p ?o .} LIMIT 10";
    public static String THREE_SUBJECT_URIS =  "SELECT ?subject WHERE {?subject ?p ?o } LIMIT 3";
    public static String FIVE_PREDICATE_URIS = "SELECT ?predicate WHERE { ?s ?predicate ?o } LIMIT 5";

    public static String LINKED_GEODATA_SELECT = "Prefix lgdr:<http://linkedgeodata.org/triplify/> Prefix lgdo:<http://linkedgeodata.org/ontology/> Select * { ?s ?p ?o . } Limit 1000";
}
