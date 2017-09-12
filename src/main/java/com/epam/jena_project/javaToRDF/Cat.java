package com.epam.jena_project.javaToRDF;

import java.io.StringWriter;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.sparql.vocabulary.FOAF;

public class Cat {
	String name;
	String birthday;

	public Cat(String name, String birthday) {
		super();
		this.name = name;
		this.birthday = birthday;
	}

	public String getIRI() {
		return "http://serialize-java-object-to-rdf.com/" + name;
	}

	public String serialize(final String syntax) {
		Model model = ModelFactory.createDefaultModel();

		Resource resource = model.createResource(getIRI());
		// add the property
		resource.addProperty(FOAF.name, name);
		resource.addProperty(FOAF.birthday, birthday);

		StringWriter out = new StringWriter();
		model.write(out, syntax);
		return out.toString();
	}
}
