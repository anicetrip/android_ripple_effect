package com.dashucun.rippleeffectdemo1;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private RippleView rippleView;
    private boolean isRippleActive = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rippleView = findViewById(R.id.rippleView);
    }

    public void onOuterLayoutClick(View view) {
        if (isRippleActive) {
            rippleView.stopRipple();
        } else {
            rippleView.startRipple();
        }
        isRippleActive = !isRippleActive;
    }
}
