package com.adiyehezkeli.ex3threads;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.widget.TextView;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class ThreadClass extends Thread {
    private boolean shouldRun;
    private TextView txt;
    private int counter;
    private long time;
    TextHandler txtHandler;
    private Activity mainContext;

    private int CANCEL = -1;
    private int DONE = -2;


    ThreadClass(String name, TextView txtView, Activity context)
    {
        super();
        txt = txtView;
        counter = 0;
        mainContext = context;
        time = SystemClock.elapsedRealtime();
        txtHandler = new TextHandler(context);
    }

    @Override
    public void run() {
        Message message;
        for (int i = 0; i < 11; i++) {
            synchronized (this) {
                try {
                    if (Thread.currentThread().isInterrupted()) {
                        message = Message.obtain();
                        message.what = CANCEL;
                        txtHandler.sendMessage(message);
//                        txt.setText("Cancelled");
                        return;
                    }
                    message = Message.obtain();
                    counter = i;
//                    String val = String.valueOf(i);
//                    txt.setText(val);
                    message.what = i;
                    txtHandler.sendMessage(message);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println(e);
                }
            }
        }
        message = Message.obtain();
        message.what = DONE;
        txtHandler.sendMessage(message);
    }

    public void cancel() {
        shouldRun = false;
    }

    private void count()
    {
        counter++;
        txt.setText(String.valueOf(counter));
    }
}