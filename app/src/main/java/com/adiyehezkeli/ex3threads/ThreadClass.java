package com.adiyehezkeli.ex3threads;

import android.app.Activity;
import android.os.Message;
import android.widget.TextView;

public class ThreadClass extends Thread {
    private TextView txt;
    private int counter;
    private TextHandler txtHandler;

    private int CANCEL = -1;
    private int DONE = -2;


    ThreadClass(String name, TextView txtView, Activity context)
    {
        super();
        txt = txtView;
        counter = 0;
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
                        return;
                    }
                    message = Message.obtain();
                    counter = i;
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
}