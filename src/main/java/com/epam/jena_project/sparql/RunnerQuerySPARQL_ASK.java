package com.epam.jena_project.sparql;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

import static com.epam.jena_project.constants.Constant.*;

public class RunnerQuerySPARQL_ASK {
	public RunnerQuerySPARQL_ASK() {
		super();
	}

	public static void main(final String[] args) throws Exception {

		Model model = ModelFactory.createDefaultModel();

		// model.read(LOCATION_DATASET_WINE_GET); //read model from Apache Jena dataset
		model.read(FILE_WINE_RDF); // read model from file

		String queryString = " PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ " ASK  WHERE { ?subject rdf:type ?object }";

		Query query = QueryFactory.create(queryString);
		QueryExecution qExec = QueryExecutionFactory.create(query, model);
		boolean b = qExec.execAsk();
		System.out.println("Ask result = " + ((b) ? "TRUE" : "FALSE"));
	}
}
