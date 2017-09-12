package com.epam.jena_project.sparql;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;

import static com.epam.jena_project.constants.Constant.*;

public class RunnerQuerySPARQL_SELECT {

	public RunnerQuerySPARQL_SELECT() {
		super();
	}

	public static void main(String[] args) throws Exception {
		Model model = ModelFactory.createDefaultModel();

		// model.read(LOCATION_DATASET_WINE_GET); //read model from Apache Jena dataset
		model.read(FILE_WINE_RDF); // read model from file

		String queryString = ""
				+ " PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "				

				+ " SELECT ?subject ?predicate ?object  "
				+ " WHERE "
				+ " { "
				+ "  ?subject ?predicate ?object."
				+ "  ?subject rdf:type ?object. "
				+ " }"
				+ " ORDER BY ?subject";
		
		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, model);
		    
		ResultSet results = qexec.execSelect();    		

		for (; results.hasNext();) {
			QuerySolution soln = results.nextSolution();
			RDFNode subject = soln.get("subject");
		    RDFNode predicate = soln.get("predicate");
			RDFNode object = soln.get("object");
			System.out.println(subject + "  " + predicate + "  " + object+"\n");
		}
	}
}
