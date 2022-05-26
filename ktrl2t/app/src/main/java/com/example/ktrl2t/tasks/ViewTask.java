package com.example.ktrl2t.tasks;

import android.os.Handler;
import android.util.Log;
import com.example.ktrl2t.listeners.OnModifiedParkingListener;
import com.example.ktrl2t.models.Parking;
import java.util.ArrayList;

public class ViewTask implements Runnable {

	private Handler handler;
	private OnModifiedParkingListener listener;
	private ArrayList<Parking> parking;

	public ViewTask(Handler handler, OnModifiedParkingListener listener, ArrayList<Parking> parking) {
		this.listener = listener;
		this.parking = parking;
		this.handler = handler;
	}

	@Override
	public void run() {
		for (Parking parking : new ArrayList<>(parking)) {
			Log.i("insert", parking.getRegNum());
			parking.changeUsed();
			if (!parking.isUsed())
			listener.onUpdateParking(parking);
		}
		handler.postDelayed(this,3000);
	}
}
