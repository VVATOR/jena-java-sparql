package com.epam.jena_project.javaToRDF;

public class RunnerSerializeJavaObjectToRDF {

	public static void main(final String[] args) {
		Cat person = new Cat("Barsik", "16.06.1991");
		System.out.println(person.serialize("RDF/XML"));
	}
}
