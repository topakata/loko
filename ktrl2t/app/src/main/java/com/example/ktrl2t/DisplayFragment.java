package com.example.ktrl2t;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.example.ktrl2t.models.Parking;
public class DisplayFragment extends DialogFragment {

	private static final String ARG_PARKING = "parking";
	private Parking parking;

	public DisplayFragment() {}

	public static DisplayFragment newInstance(Parking parking) {
		DisplayFragment fragment = new DisplayFragment();
		Bundle args = new Bundle();
		args.putParcelable(ARG_PARKING, parking);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null)
			parking = getArguments().getParcelable(ARG_PARKING);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
													 Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_display, container, false);
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		TextView regNum = view.findViewById(R.id.regView);
		regNum.setText(parking.getRegNum());

		TextView owner = view.findViewById(R.id.ownerView);
		owner.setText(parking.getOwner());

		TextView mark = view.findViewById(R.id.markView);
		mark.setText(parking.getMark());

		TextView model = view.findViewById(R.id.modelView);
		model.setText(parking.getModel());

		TextView fuel = view.findViewById(R.id.fuelView);
		fuel.setText(parking.getFuel());

		TextView used = view.findViewById(R.id.usedView);
		if (parking.isUsed())
			used.setText(R.string.full);
		else {
			regNum.setText(R.string.empty);
			owner.setText(R.string.empty);
			mark.setText(R.string.empty);
			model.setText(R.string.empty);
			fuel.setText(R.string.empty);
			used.setText(R.string.empty);
		}
	}
}