package com.demo;

public class Baggage {

	private int id;
	private int weight;
	private String weightUnit;
	private int pieces;

	public Baggage() {
		// TODO Auto-generated constructor stub
	}

	public Baggage(int id, int weight, String weightUnit, int pieces) {
		super();
		this.id = id;
		this.weight = weight;
		this.weightUnit = weightUnit;
		this.pieces = pieces;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getWeightUnit() {
		return weightUnit;
	}

	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}

	public int getPieces() {
		return pieces;
	}

	public void setPieces(int pieces) {
		this.pieces = pieces;
	}

	@Override
	public String toString() {
		return "Baggage [id=" + id + ", weight=" + weight + ", weightUnit=" + weightUnit + ", pieces=" + pieces + "]";
	}

	public double weightInKg() {
		double kg = 0;

		if (this.weightUnit == "kg") {

			kg = (double) (weight * pieces);

		} else if (this.weightUnit == "lb") {
			kg = (double) (weight * pieces) * 0.4535;
		}

		return kg;
	}

	public double weightInLb() {
		double lb = 0;

		if (this.weightUnit == "lb") {

			lb = (double) (weight * pieces);

		} else if (this.weightUnit == "kg") {
			lb = (double) (weight * pieces) * 2.204;
		}

		return lb;
	}

}
