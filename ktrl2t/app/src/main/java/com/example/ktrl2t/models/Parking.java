package com.example.ktrl2t.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.UUID;

public class Parking implements Parcelable {

	private UUID uuid;
	private String regNum, owner, mark, model, fuel;
	boolean used;
	public Parking(String regNum, String owner, String mark, String model, String fuel, boolean used) {
		this.uuid = UUID.randomUUID();
		this.regNum = regNum;
		this.owner = owner;
		this.mark = mark;
		this.model = model;
		this.fuel = fuel;
		this.used = used;
	}

	public String getRegNum() {
			return regNum;
	}

	public void setRegNum(String regNum) {
			this.regNum = regNum;
	}

	public String getOwner() {
			return owner;
	}

	public void setOwner(String owner) {
			this.owner = owner;
	}

	public String getMark() {
			return mark;
	}

	public void setMark(String mark) {
			this.mark = mark;
	}

	public String getModel() {
			return model;
	}

	public void setModel(String model) {
			this.model = model;
	}

	public String getFuel() {
			return fuel;
	}

	public void setFuel(String fuel) {
			this.fuel = fuel;
	}

	public boolean isUsed() {
			return used;
	}

	public void setUsed(boolean used) {
			this.used = used;
	}


	protected Parking(Parcel in) {
		uuid = (UUID) in.readSerializable();
		regNum = in.readString();
		owner = in.readString();
		mark = in.readString();
		model = in.readString();
		fuel = in.readString();
		used = in.readBoolean();
	}

	public static final Creator<Parking> CREATOR = new Creator<Parking>() {
		@Override
		public Parking createFromParcel(Parcel in) {
				return new Parking(in);
		}

		@Override
		public Parking[] newArray(int size) {
				return new Parking[size];
		}
	};

	public void changeUsed() {
			used = !used;
	}


	@Override
	public int describeContents() {
			return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeSerializable(uuid);
		dest.writeString(regNum);
		dest.writeString(owner);
		dest.writeString(mark);
		dest.writeString(model);
		dest.writeString(fuel);
		dest.writeBoolean(used);
	}
}
