package com.vivek.template;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * Created by Shiva on 10-06-2015.
 */
public class MainActivity extends AppCompatActivity {


    @Override
    public void onBackPressed() {
        finish();
    }

    public String t = "org.cyanogenmod.theme.chooser";
    Process process;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater m = getMenuInflater();
        m.inflate(R.menu.menu_main , menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.one:
                Intent f = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(getString(R.string.applink)));
                startActivity(f);

                break;
            case R.id.two:
                Intent ff = new Intent(Intent.ACTION_SEND);

                ff.putExtra(Intent.EXTRA_TEXT , getString(R.string.applink));
                ff.setType("plain/text");
                startActivity(Intent.createChooser(ff , "Share via:"));
                break;
            case R.id.three:
                finish();
                break;



        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("Neat");
        ImageView header = (ImageView)findViewById(R.id.m);
        header.setScaleType(ImageView.ScaleType.FIT_XY);

        final CardView preview = (CardView) findViewById(R.id.preview);
        preview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(MainActivity.this , ViewPagerActivity.class);
                startActivity(a);
            }
        });

        CardView themes = (CardView) findViewById(R.id.themes);
        themes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                try{

                    Intent b = getPackageManager().getLaunchIntentForPackage(t);
                    startActivity(b);
                    throw new pa("You don't have theme engine and hence this theme won't work.LOL!");


                }catch (pa P){



                }
            }
        });




        CardView dev = (CardView) findViewById(R.id.dev);
        dev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(MainActivity.this , about.class);
                startActivity(c);
            }
        });

        CardView reboot = (CardView) findViewById(R.id.r);
        reboot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{


                    process = Runtime.getRuntime().exec("su -c reboot");

                   process = Runtime.getRuntime().exec("su -c reboot");


                }catch (IOException e){


                }
            }
        });

        CardView sys = (CardView)findViewById(R.id.sys);
        sys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                killUI("com.android.systemui");
            }
        });




        CardView mail = (CardView) findViewById(R.id.mail);
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent d = new Intent(Intent.ACTION_SEND);

                d.putExtra(Intent.EXTRA_EMAIL , new String[]{getResources().getString(R.string.email)});
                d.putExtra(Intent.EXTRA_SUBJECT , new String[]{getResources().getString(R.string.sub1)});
                d.putExtra(Intent.EXTRA_TEXT , new String[]{getResources().getString(R.string.sub12)});
                d.setType("plain/text");
                startActivity(Intent.createChooser(d , "Send Mail"));
            }
        });

        CardView ddd = (CardView) findViewById(R.id.donation);
        ddd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ii = new Intent(MainActivity.this , Donation.class);
                startActivity(ii);
            }
        });

    }

    private void killUI(String p){
        Process root = null;
        try{

            root = Runtime.getRuntime().exec("su");
        }catch (IOException e){

            e.printStackTrace();
        }
        if(root!=null){

            try{
                DataOutputStream dataOutputStream = new DataOutputStream((root.getOutputStream()));
                dataOutputStream.writeBytes("pkill " + p + "\n");
                dataOutputStream.flush();
                dataOutputStream.writeBytes("exit\n");
                dataOutputStream.flush();
                root.waitFor();


            }catch (IOException e){
                e.printStackTrace();
            }catch (InterruptedException i){
                i.printStackTrace();
            }
        }


    }


}
