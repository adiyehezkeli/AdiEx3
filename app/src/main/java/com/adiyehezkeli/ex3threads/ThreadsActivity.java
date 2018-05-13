package com.adiyehezkeli.ex3threads;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ThreadsActivity extends AppCompatActivity
{
    ThreadClass myThread;
    TextView txt;
    long time;

    @SuppressLint("ResourceType")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threads);
    }

    public void threadsCreate(View view)
    {
        setContentView(R.layout.activity_threads);
        txt = findViewById(R.id.threads_textView);
        myThread = new ThreadClass("thread", txt, this);
    }

    public void threadsStart(View view)
    {
        if (myThread != null)
        {
            myThread.start();
        }
    }

    public void threadsCancel(View view)
    {
        if (myThread != null)
        {
            myThread.interrupt();
        }
    }
}

