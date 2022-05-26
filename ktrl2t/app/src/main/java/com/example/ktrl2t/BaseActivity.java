package com.example.ktrl2t;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
	protected static final String ARG_PARKING = "Parking";
	protected static final int RETURN_CODE_EDIT = 1;
}
