package com.adiyehezkeli.ex3threads;

import android.app.Activity;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.widget.TextView;

public class ThreadClass extends HandlerThread {
    private boolean shouldRun;
    private TextView txt;
    private int counter;
    private long time;
    private Activity mainContext;


    ThreadClass(String name, TextView txtView, Activity context)
    {
        super(name);
        txt = txtView;
        counter = 0;
        mainContext = context;
        time = SystemClock.elapsedRealtime();
    }

    @Override
    public void run() {
//        shouldRun = true;
//
//        while (shouldRun)
//        {
//            mainContext.runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    Intent intent = new Intent(mainContext, ThreadsActivity.class);
//                    time=SystemClock.elapsedRealtime()-time;
//                    String message = String.valueOf(time);
//                    intent.putExtra(EXTRA_MESSAGE, message);
//                    mainContext.startActivity(intent);
//                    count();
//                }
//            });
//            this.quit();
//        }
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