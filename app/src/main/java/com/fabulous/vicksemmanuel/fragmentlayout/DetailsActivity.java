package com.fabulous.vicksemmanuel.fragmentlayout;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by vicksemmanuel on 1/12/2018.
 */

public class DetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){
            finish();
            return;
        }
        if(savedInstanceState==null){
            DetailsFragment details=new DetailsFragment();
            details.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(android.R.id.content,details).commit();
        }
    }
}
