package com.adiyehezkeli.ex3threads;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class AsyncTaskActivity extends AppCompatActivity
{
    AsyncTaskClass asyncTask;
    Activity parentContext;
    TextView textView;
//
//    public AsyncTaskActivity(Activity context, TextView v)
//    {
//        parentContext = context;
//        textView = v;
//    }
//
//    public AsyncTaskActivity()
//    {
//
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);
        textView = findViewById(R.id.threads_textView);
    }

    public void asyncTaskCreate(View view)
    {
        asyncTask = new AsyncTaskClass(textView, parentContext);
    }

    public void asyncTaskStart(View view)
    {
        if (asyncTask != null)
        {
            asyncTask.execute();
        }
    }

    public void asyncTaskCancel(View view)
    {
        if (asyncTask != null)
        {
            asyncTask.cancel(true);
        }
    }
}
