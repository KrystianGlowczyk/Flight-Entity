package com.demo;

import java.util.Arrays;

public class CargoEntity {

	private int flightId;
	private Baggage[] listBaggage;
	private Cargo[] listCargo;

	public CargoEntity() {
		// TODO Auto-generated constructor stub
	}

	public CargoEntity(int flightId, Baggage[] listBaggage, Cargo[] listCargo) {
		super();
		this.flightId = flightId;
		this.listBaggage = listBaggage;
		this.listCargo = listCargo;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public Baggage[] getListBaggage() {
		return listBaggage;
	}

	public void setListBaggage(Baggage[] listBaggage) {
		this.listBaggage = listBaggage;
	}

	public Cargo[] getListCargo() {
		return listCargo;
	}

	public void setListCargo(Cargo[] listCargo) {
		this.listCargo = listCargo;
	}

	@Override
	public String toString() {
		return "CargoEntity [flightId=" + flightId + ", listBaggage=" + Arrays.toString(listBaggage) + ", listCargo="
				+ Arrays.toString(listCargo) + "]";
	}

	public int sumBaggage() {
		int sum = 0;

		for (int i = 0; i < listBaggage.length; i++) {
			sum += listBaggage[i].getPieces();
		}

		return sum;
	}

	public double sumWeightBaggageKg() {
		double sumKg = 0;

		for (int i = 0; i < listBaggage.length; i++) {
			sumKg += listBaggage[i].weightInKg();
		}

		return sumKg;
	}

	public double sumWeightBaggageLb() {
		double sumLb = 0;

		for (int i = 0; i < listBaggage.length; i++) {
			sumLb += listBaggage[i].weightInLb();
		}

		return sumLb;
	}

	public double sumWeightCargoKg() {
		double sumKg = 0;

		for (int i = 0; i < listCargo.length; i++) {
			sumKg += listCargo[i].weightInKg();
		}

		return sumKg;
	}

	public double sumWeightCargoLb() {
		double sumLb = 0;

		for (int i = 0; i < listCargo.length; i++) {
			sumLb += listCargo[i].weightInLb();
		}

		return sumLb;
	}

	public double totalWeightKg() {
		double totalKg = sumWeightBaggageKg() + sumWeightCargoKg();

		return totalKg;
	}

	public double totalWeightLb() {
		double totalLb = sumWeightBaggageLb() + sumWeightCargoLb();

		return totalLb;
	}

}
