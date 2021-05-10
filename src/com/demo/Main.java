package com.demo;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		var listFE = fillFE();
		var listCE = fillCE();
		var scanner = new Scanner(System.in);

		menu();
		System.out.println("\nSelect option 1 or 2: ");
		var x = scanner.nextInt();

		switch (x) {
		case 1:
			selectOne(listFE, listCE);

			break;
		case 2:
			selectTwo(listFE, listCE);
			break;
		}

//		String date = "2015-01-25";
//		int flightNr = 4394;
//
//		String date = "2015-01-25";
//		String ATA = "YYZ";

	}

	public static void menu() {
		System.out.println("Option 1:");
		System.out.println("For requested Flight Number and date will respond with following :");
		System.out.println("a. Cargo Weight for requested Flight");
		System.out.println("b. Baggage Weight for requested Flight");
		System.out.println("c. Total Weight for requested Flight");

		System.out.println("\nOption 2:");
		System.out.println("For requested IATA Airport Code and date will respond with following :");
		System.out.println("a. Number of flights departing from this airport");
		System.out.println("b. Number of flights arriving to this airport");
		System.out.println("c. Total number (pieces) of baggage arriving to this airport,");
		System.out.println("d. Total number (pieces) of baggage departing from this airport");
	}

	public static void selectOne(List<FlightEntity> listFE, List<CargoEntity> listCE) {

		var scanner = new Scanner(System.in);
		int flightNr;
		String date;
		System.out.println("Please enter your flight number:");
		flightNr = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Please enter date(YYYY-MM-DD): ");
		date = scanner.nextLine();
		FlightNumberAndData(listFE, listCE, date, flightNr);
	}

	public static void selectTwo(List<FlightEntity> listFE, List<CargoEntity> listCE) {
		var scanner = new Scanner(System.in);
		String date;
		String Iata;
		System.out.println("Enter the IATA code:");
		Iata = scanner.nextLine();
		Iata = Iata.toUpperCase();
		System.out.println("Enter date(YYYY-MM-DD):");
		date = scanner.nextLine();
		IataAndData(listFE, listCE, date, Iata);

	}

	static void FlightNumberAndData(List<FlightEntity> listFE, List<CargoEntity> listCE, String date, int flightNr) {

		var cargoKg = 0.0;
		var cargoLb = 0.0;
		var baggageKg = 0.0;
		var baggageLb = 0.0;
		var totalKg = 0.0;
		var totalLb = 0.0;
		var flag = false;

		LocalDate LDate, ZDate;
		LDate = LocalDate.parse(date);

		for (FlightEntity x : listFE) {

			var fId = x.getFlightId();
			var tmpFlightNr = x.getFlightNumber();
			var tmpDate = x.getDepartureDate();
			ZDate = tmpDate.toLocalDate();

			if (LDate.equals(ZDate) && (tmpFlightNr == flightNr)) {

				for (CargoEntity y : listCE) {
					if (y.getFlightId() == fId) {
						flag = true;
						cargoKg += y.sumWeightCargoKg();
						cargoLb += y.sumWeightCargoLb();
						baggageKg += y.sumWeightBaggageKg();
						baggageLb += y.sumWeightBaggageLb();
						totalKg += y.totalWeightKg();
						totalLb += y.totalWeightLb();

						System.out.format("For Flight with flight nr: %d:", flightNr);
						System.out.print("\n\nCargo Weight for requested Flight: ");
						System.out.format("%.2f kg (%.2f lb) ", cargoKg, cargoLb);
						System.out.print("\n\nBaggage Weight for requested Flight: ");
						System.out.format("%.2f kg (%.2f lb) ", baggageKg, baggageLb);
						System.out.print("\n\nTotal Weight for requested Flight: ");
						System.out.format("%.2f kg (%.2f lb) ", totalKg, totalLb);
					}

				}

			}

		}
		if (!flag) {
			System.out.format("On that day there is no flight with the flight numer of %d", flightNr);
		}

	}

	static void IataAndData(List<FlightEntity> listFE, List<CargoEntity> listCE, String date, String ATA) {

		LocalDate LDate, ZDate;
		LDate = LocalDate.parse(date);
		var countArrival = 0;
		var countDeparture = 0;
		var sumBaggageArr = 0;
		var sumBaggageDep = 0;

		for (FlightEntity x : listFE) {
			var fId = x.getFlightId();

			var tmpDate = x.getDepartureDate();
			ZDate = tmpDate.toLocalDate();

			var tmpATA = x.getArrivalAirportIATACode();
			var tmpATAD = x.getDepartureAirportIATACode();

			if (LDate.equals(ZDate)) {
				if (tmpATA.equals(ATA)) {
					countArrival++;

					for (CargoEntity y : listCE) {
						if (y.getFlightId() == fId) {
							sumBaggageArr += y.sumBaggage();
						}
					}

				} else if (tmpATAD.equals(ATA)) {
					countDeparture++;

					for (CargoEntity y : listCE) {
						if (y.getFlightId() == fId) {
							sumBaggageDep += y.sumBaggage();
						}
					}
				}

			}

		}

		System.out.println("Number of flights departing from this airport: " + countDeparture);
		System.out.println("Number of flights arriving to this airport: " + countArrival);
		System.out.println("Total number (pieces) of baggage arriving to this airport: " + sumBaggageArr);
		System.out.println("Total number (pieces) of baggage departing from this airport: " + sumBaggageDep);

	}

	static List<CargoEntity> fillCE() {

		Cargo[] cargo0 = { new Cargo(0, 836, "lb", 70), new Cargo(1, 567, "lb", 548), new Cargo(2, 290, "kg", 765),
				new Cargo(3, 106, "kg", 270), new Cargo(4, 983, "kg", 746) };

		Cargo[] cargo1 = { new Cargo(0, 895, "kg", 845), new Cargo(1, 936, "lb", 949), new Cargo(2, 663, "kg", 109),
				new Cargo(3, 674, "lb", 499) };

		Cargo[] cargo2 = { new Cargo(0, 204, "kg", 707), new Cargo(1, 496, "lb", 614), new Cargo(2, 941, "lb", 333),
				new Cargo(3, 177, "kg", 186) };

		Cargo[] cargo3 = { new Cargo(0, 842, "lb", 591), new Cargo(1, 673, "lb", 833), new Cargo(2, 679, "kg", 784),
				new Cargo(3, 819, "kg", 644), new Cargo(4, 402, "lb", 165) };

		Cargo[] cargo4 = { new Cargo(0, 203, "kg", 845), new Cargo(1, 800, "kg", 949), new Cargo(2, 320, "kg", 109) };

		Baggage[] baggage0 = { new Baggage(0, 527, "lb", 459), new Baggage(1, 296, "kg", 540),
				new Baggage(2, 131, "lb", 45), new Baggage(3, 306, "lb", 202), new Baggage(4, 912, "kg", 777),
				new Baggage(5, 459, "lb", 300), new Baggage(6, 113, "lb", 126) };

		Baggage[] baggage1 = { new Baggage(0, 978, "kg", 304), new Baggage(1, 906, "kg", 435),
				new Baggage(2, 50, "lb", 143), new Baggage(3, 125, "lb", 330), new Baggage(4, 215, "lb", 634),
				new Baggage(5, 178, "lb", 376), new Baggage(6, 323, "kg", 225) };

		Baggage[] baggage2 = { new Baggage(0, 841, "kg", 967), new Baggage(1, 691, "lb", 763),
				new Baggage(2, 471, "lb", 866), new Baggage(3, 30, "lb", 602), new Baggage(4, 299, "lb", 307),
				new Baggage(5, 93, "lb", 579), new Baggage(6, 421, "lb", 856) };

		Baggage[] baggage3 = { new Baggage(0, 813, "lb", 102), new Baggage(1, 996, "lb", 829),
				new Baggage(2, 989, "lb", 321) };

		Baggage[] baggage4 = { new Baggage(0, 787, "lb", 12), new Baggage(1, 280, "lb", 350),
				new Baggage(2, 807, "kg", 944), new Baggage(3, 17, "kg", 783), new Baggage(4, 375, "lb", 433),
				new Baggage(5, 265, "lb", 720) };

		CargoEntity ce0 = new CargoEntity(0, baggage0, cargo0);
		CargoEntity ce1 = new CargoEntity(1, baggage1, cargo1);
		CargoEntity ce2 = new CargoEntity(2, baggage2, cargo2);
		CargoEntity ce3 = new CargoEntity(3, baggage3, cargo3);
		CargoEntity ce4 = new CargoEntity(4, baggage4, cargo4);

		List<CargoEntity> listCE = new ArrayList<CargoEntity>();
		listCE.add(ce0);
		listCE.add(ce1);
		listCE.add(ce2);
		listCE.add(ce3);
		listCE.add(ce4);

		return listCE;

	}

	static List<FlightEntity> fillFE() {

		FlightEntity fe0 = new FlightEntity(0, 4394, "YYZ", "GDN", ZonedDateTime.parse("2015-01-25T12:48:14-01:00"));
		FlightEntity fe1 = new FlightEntity(1, 5651, "YYT", "KRK", ZonedDateTime.parse("2017-06-14T03:34:33-02:00"));
		FlightEntity fe2 = new FlightEntity(2, 4165, "YYZ", "KRK", ZonedDateTime.parse("2016-06-22T02:48:15-02:00"));
		FlightEntity fe3 = new FlightEntity(3, 4939, "SEA", "MIT", ZonedDateTime.parse("2019-08-13T09:07:34-02:00"));
		FlightEntity fe4 = new FlightEntity(4, 9919, "ANC", "MIT", ZonedDateTime.parse("2017-06-19T07:43:04-02:00"));

		List<FlightEntity> listFE = new ArrayList<FlightEntity>();
		listFE.add(fe0);
		listFE.add(fe1);
		listFE.add(fe2);
		listFE.add(fe3);
		listFE.add(fe4);

		return listFE;
	}

}
