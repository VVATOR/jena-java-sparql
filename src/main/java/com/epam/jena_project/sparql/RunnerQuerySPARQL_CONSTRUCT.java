package com.epam.jena_project.sparql;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import static com.epam.jena_project.constants.Constant.*;


public class RunnerQuerySPARQL_CONSTRUCT {
	

	public RunnerQuerySPARQL_CONSTRUCT() {
		super();
	}

	public static void main(final String[] args) throws Exception {

		Model model = ModelFactory.createDefaultModel();

		// model.read(LOCATION_DATASET_WINE_GET); //read model from Apache Jena dataset
		model.read(FILE_WINE_RDF); // read model from file
		
		String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
				+ "	PREFIX wine: <http://www.w3.org/TR/2003/PR-owl-guide-20031209/wine#> "
				+ " PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				+ " PREFIX owl: <http://www.w3.org/2002/07/owl#> "
				+ " PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
				+ " CONSTRUCT {"
				+ "			   ?subject      wine:hasSugar   ?object ;"
				+ "			  				 wine:hasColor   wine:White."
				+ " } WHERE { "
				+ " 		   ?subject    	 ?predicate      ?object."
				+ " 		   ?subject      wine:hasSugar   ?object ; "
				+ " }";
		
		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, model);
		Model constructModel = qexec.execConstruct();
		
		System.out.println("Construct result = " + constructModel.toString());  
		constructModel.write(System.out,"Turtle");	
	}
}
