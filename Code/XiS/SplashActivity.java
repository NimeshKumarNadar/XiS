package com.example.xis;

import android.net.ConnectivityManager;
import android.os.Handler;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import cn.pedant.SweetAlert.SweetAlertDialog;


public class SplashActivity extends AppCompatActivity {
    private Handler mWaitHandler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!checkInternet()){
            new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("Error")
                    .setCustomImage(R.drawable.baseline_crisis_alert_24)
                    .setContentText("No Internet Connection!")
                    .setConfirmText("OPEN SETTINGS")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                            sweetAlertDialog.dismissWithAnimation();
                            startActivityForResult(new Intent(Settings.ACTION_SETTINGS),0);
                        }
                    })
                    .show();
        }else {
            Splash();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mWaitHandler.removeCallbacksAndMessages(null);
    }

    public boolean checkInternet(){
        boolean mobileNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        try {
            mobileNetworkInfo = connectivityManager.getActiveNetworkInfo().isConnected();
        } catch (NullPointerException e){
            mobileNetworkInfo = false;
        }
        return mobileNetworkInfo;
    }

    public void Splash(){
        mWaitHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent not_signed_in = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(not_signed_in);

                finish();
            }
        }, 1500);
    }
}
