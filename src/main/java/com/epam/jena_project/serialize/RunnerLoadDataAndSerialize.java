package com.epam.jena_project.serialize;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

import static com.epam.jena_project.constants.Constant.*;

public class RunnerLoadDataAndSerialize {

	enum ModelFormat {
		TURTLE("Turtle", "ttl"), 
		RDF_XML("RDF/XML", "rdf"), 
		N_TRIPLES("N-Triples", "nt"), 
		JSON_LD("JSON-LD","jsonld"), 
		RDF_JSON("RDF/JSON","rj"), 
		TRIG("TriG", "trig"), 
		N_QUADS("N-Quads", "nq"), 
		TRIX("TriX", "trix");

		private String name;
		private String fileExtension;

		public String getName() {
			return name;
		}

		public String getFileExtension() {
			return fileExtension;
		}

		private ModelFormat(final String name,final String fileExtension) {
			this.name = name;
			this.fileExtension = fileExtension;
		}
	}

	public static void main(final String[] args) {
		Model model = ModelFactory.createDefaultModel();

		// model.read(LOCATION_DATASET_WINE_GET); //model from Jena dataset
		model.read(FILE_WINE_RDF, "RDF/XML"); // model from file


		File f = new File(FOLDER_OUTPUT_NAME);
		f.mkdir();
		String prefixOutputFile = "result-";
		for (ModelFormat format : ModelFormat.values()) {
			writeModelToFileDependOfType(model, f + "/" + prefixOutputFile + format, format);
		}
	}

	private static void writeModelToFileDependOfType(final Model model, final String outputFile,
			final ModelFormat modelFormat) {
		String filename = outputFile + DOT + modelFormat.getFileExtension();
		System.out.println("\nWrite Model to " + filename + " (format: " + modelFormat.getName() + ")");
		FileOutputStream outputStream;
		try {
			outputStream = new FileOutputStream(filename);
			model.write(outputStream, modelFormat.getName());
		} catch (FileNotFoundException e) {
			System.err.println(e);
		}
	}

}
