package com.operations;

//ENTITY/BEAN/MODEL/POJO
public class Product{
	//PROPERTIES
	private int id;
	private String name;
	private double price ;

	//CREATE A BLANK PRODUCT
	public Product() {

	}

	//CREATE A PRODUCT WITH FULL VALUES
	public Product(int id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	//GETTERS/ACCESSOR METHODS
	public int getId() {
		return id;
	}
	public double getPrice() {
		return price;
	}
	public String getName() {
		return name;
	}

	//SETTERS/MUTATOR METHODS
	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	public String toString() {
		String objectInfo="Product [";
		objectInfo+="id="+id;
		objectInfo+="name="+name;
		objectInfo+="Price="+price;
		objectInfo+="]";
		return objectInfo;
	}




	
	
}
