package com.vivek.template;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Shiva on 10-06-2015.
 */
public class splash extends Activity {



    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN ,  WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.splash);


       final Thread t = new Thread() {
            @Override
            public void run() {
           try{
              sleep(1000);




           }  catch(Exception e){



           }
                finally {
               Intent s = new Intent(splash.this , MainActivity.class);
               startActivity(s);
           }
            }
        };
        t.start();
    }
}
