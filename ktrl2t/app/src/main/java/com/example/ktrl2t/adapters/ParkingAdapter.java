package com.example.ktrl2t.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ktrl2t.R;
import com.example.ktrl2t.listeners.OnClickParkingListener;
import com.example.ktrl2t.models.Parking;
import com.example.ktrl2t.viewmodels.ParkingViewHolder;
import java.util.ArrayList;

public class ParkingAdapter extends RecyclerView.Adapter<ParkingViewHolder> {

    private ArrayList<Parking> parkings;
    private final OnClickParkingListener listener;

    public ParkingAdapter(OnClickParkingListener listener, ArrayList<Parking> parkings) {
        this.parkings = new ArrayList<>(parkings);
        this.listener = listener;
    }


    @NonNull
    @Override
    public ParkingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_holder_parking, parent, false);
        return new ParkingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParkingViewHolder holder, int position) {
        Parking parking = (Parking) parkings.toArray()[position];
        holder.setRegNum(parking.getRegNum());
        holder.setOwner(parking.getOwner());
        holder.setUsed(parking.isUsed());
        holder.setDisplayAction(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClickDisplayParking(parking);
            }
        });
    }

    @Override
    public int getItemCount() {
        return parkings.size();
    }

    public ArrayList<Parking> getItems() {
        return this.parkings;
    }

    public void addParking(Parking parking) {
        parkings.add(parking);
        notifyDataSetChanged();
    }

    public void updateParking(Parking parking) {
        parkings.remove(parking);
        parkings.add(parking);
        notifyDataSetChanged();
    }
}
