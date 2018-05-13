package com.adiyehezkeli.ex3threads;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Activity thisContext;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        thisContext = this;
    }

    public void AsyncTaskActivity(View view)
    {
        Intent intent = new Intent(this, AsyncTaskActivity.class);
        startActivity(intent);
    }

    public void ThreadsActivity(View view)
    {
        Intent intent = new Intent(this, ThreadsActivity.class);
        startActivity(intent);
    }
}
