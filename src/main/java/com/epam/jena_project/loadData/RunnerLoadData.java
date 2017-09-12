package com.epam.jena_project.loadData;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

import static com.epam.jena_project.constants.Constant.*;

public class RunnerLoadData {

	public static void main(final String[] args) {
		Model model = ModelFactory.createDefaultModel();

		// READ model from files different formats
		model.read(TEST_FILE_JSON_LD);
		model.write(System.out);

		model.read(TEST_FILE_N_QUADS);
		model.write(System.out);

		model.read(TEST_FILE_N_TRIPLES);
		model.write(System.out);

		model.read(TEST_FILE_RDF_JSON);
		model.write(System.out);

		model.read(TEST_FILE_RDF_XML);
		model.write(System.out);

		model.read(TEST_FILE_TRIG);
		model.write(System.out);

		model.read(TEST_FILE_TRIX);
		model.write(System.out);

		model.read(TEST_FILE_TURTLE);
		model.write(System.out);

		// READ model from Apache Dataset different formats
		model.read(LOCATION_DATASET_WINE_GET);
		model.write(System.out);
	}
}
