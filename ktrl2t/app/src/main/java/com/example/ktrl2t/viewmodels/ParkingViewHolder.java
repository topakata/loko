package com.example.ktrl2t.viewmodels;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.ktrl2t.R;

public class ParkingViewHolder extends RecyclerView.ViewHolder {

	private final TextView regNum, owner, used;

	public ParkingViewHolder(@NonNull View itemView) {
		super(itemView);
		regNum = itemView.findViewById(R.id.regView);
		owner = itemView.findViewById(R.id.ownerView);
		used = itemView.findViewById(R.id.usedView);
	}

	public void setRegNum(String regNum) {
			this.regNum.setText(regNum);
	}

	public void setOwner(String owner) {
			this.owner.setText(owner);
	}

	public void setUsed(boolean used) {
		if (used)
			this.used.setText(R.string.full);
		else
			this.used.setText(R.string.empty);
	}

	public void setDisplayAction(View.OnClickListener listener) {
		this.itemView.setOnClickListener(listener);
	}
}
