package com.adiyehezkeli.ex3threads;

import android.app.Activity;
import android.os.Message;

import android.os.Handler;
import android.widget.TextView;

import java.util.logging.LogRecord;

public class TextHandler extends Handler
{
    Activity parentActivity;
    private int CANCEL = -1;
    private int DONE = -2;

    TextHandler(Activity activity)
    {
        parentActivity = activity;
    }

    @Override
    public void handleMessage(Message msg)
    {
        parentActivity.setContentView(R.layout.activity_threads);
        TextView textview = parentActivity.findViewById(R.id.threads_textView);
        if (msg.what == DONE)
        {
            textview.setText(String.valueOf("Done!"));
        }

        else if (msg.what != CANCEL)
        {
            textview.setText(String.valueOf(msg.what));
        }
    }
}
