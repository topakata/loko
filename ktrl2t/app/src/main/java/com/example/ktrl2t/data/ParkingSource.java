package com.example.ktrl2t.data;

import com.example.ktrl2t.models.Parking;

import java.util.ArrayList;
import java.util.Random;

public class ParkingSource {
	private static final String descr = "Random description regarding the owner of the vehicle";
	public static ArrayList<Parking> generateParkings(int n) {
		ArrayList<Parking> parkings = new ArrayList<>();
		Random random = new Random();
		for (int i = 0; i < n; i++)
			parkings.add(new Parking("B034" + i + "KT", "Owner: " + i, "Mark: " + i
					,"Model: " + i,"Fuel: " + i, new Random().nextBoolean()));
		return parkings;
	}
}
