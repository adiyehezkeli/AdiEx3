package com.adiyehezkeli.ex3threads;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.TextView;

public class AsyncTaskClass extends AsyncTask<Void, String, String>
{
    private Activity parentContext;
    private TextView asyncView;
    private int counter;


    private String DONE = "Done!";


    AsyncTaskClass(TextView textView, Activity context)
    {
        asyncView = textView;
        parentContext = context;
        counter = 0;
    }


    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        if (asyncView != null)
        {
            asyncView.setText(values[0]);
        }
    }

    @Override
    protected String doInBackground(Void... voids) {
        for (int i = 0; i < 11; i++) {
            try {
                this.publishProgress(Integer.toString(i));
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        return DONE;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        asyncView.setText(DONE);
    }
}
