package com.example.ktrl2t;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.View;
import com.example.ktrl2t.adapters.ParkingAdapter;
import com.example.ktrl2t.data.ParkingSource;
import com.example.ktrl2t.listeners.OnClickParkingListener;
import com.example.ktrl2t.listeners.OnModifiedParkingListener;
import com.example.ktrl2t.models.Parking;
import com.example.ktrl2t.tasks.ViewTask;

public class MainActivity extends BaseActivity implements OnClickParkingListener, OnModifiedParkingListener {
	private RecyclerView recyclerView;
	private HandlerThread thread;
	private Handler handler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		recyclerView = findViewById(R.id.recyclerView);
		ParkingAdapter parkingAdapter = new ParkingAdapter(this, ParkingSource.generateParkings(10));
		recyclerView.setAdapter(parkingAdapter);
		recyclerView.setLayoutManager(new LinearLayoutManager(this));
		executeThreads(parkingAdapter);
	}

	private void executeThreads(ParkingAdapter parkingAdapter) {
		thread = new HandlerThread("Update");
		thread.start();
		handler = new Handler(thread.getLooper());
		handler.postDelayed(new ViewTask(handler, this, parkingAdapter.getItems()), 3000);
	}

	@Override
	public void onClick(View view) {}

	@Override
	public void onClickDisplayParking(Parking parking) {
		DisplayFragment fragment = DisplayFragment.newInstance(parking);
		fragment.show(getSupportFragmentManager(), "");
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == RETURN_CODE_EDIT) {
			if (data != null) {
				Parking parking = data.getParcelableExtra(ARG_PARKING);
				if (recyclerView != null) {
					ParkingAdapter adapter = (ParkingAdapter) recyclerView.getAdapter();
				}
			}
		}
	}

	@Override
	public void onUpdateParking(Parking parking) {
		if(recyclerView != null) {
			ParkingAdapter adapter = (ParkingAdapter) recyclerView.getAdapter();
			if(adapter != null) {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						adapter.updateParking(parking);
					}
				});
			}
		}
	}
}