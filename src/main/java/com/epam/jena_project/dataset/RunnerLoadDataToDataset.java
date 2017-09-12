package com.epam.jena_project.dataset;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.jena.query.DatasetAccessor;
import org.apache.jena.query.DatasetAccessorFactory;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;


import static com.epam.jena_project.constants.Constant.*;

public class RunnerLoadDataToDataset {

	public static void main(final String[] args) throws FileNotFoundException {
		System.out.println("Load data to exist dataset");
		
		DatasetAccessor accessor = DatasetAccessorFactory.createHTTP(LOCATION_DATASET_WINE_DATA);

		InputStream in = new FileInputStream(new File(FILE_WINE_RDF));

		Model m = ModelFactory.createDefaultModel();
		String base = "http://load-from-java-code.com/";
		m.read(in, base, "RDF/XML");

		// put model data to apache jena Dataset
		accessor.putModel(m);
		System.out.println("Data is loaded!");

	}

}
