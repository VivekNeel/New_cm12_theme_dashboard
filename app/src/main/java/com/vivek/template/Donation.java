package com.vivek.template;



import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import org.sufficientlysecure.donations.DonationsFragment;


public class Donation extends AppCompatActivity {

    /*
    Make sure to replace GOOGLE_PUBKEY with yours
    Make sure to replace GOOGLE_CATALOG with yours
    Here v.n.5 indicates the product ID which you get after you upload your application with Billing permission in manifest.
    In the same way you can upload multiple apks and hence the multiple IDs ..so just use them in your GOOGLE_CATALOG
     */
    private static final String GOOGLE_PUBKEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAk3cQ5G6ZNxgLZeg737jR4o1qCaenT4AA+Kx88QzJjh8jq//ESvQ+NCo5nC/Abt5M0Jfx63oFmL6E/Qu1wMmHvjHVHixsPnXIm9DgDagHtTgTe4RYog5rmwj+hYzUw+3EYT+SKh+N39z6RzR4Ms7i5jsg3uhtdfTJ3La16Od7IA7VO5LAutT9W31fzz4NQ4edLaxysEGpn9/ejFnSZ4kJUHNOAnN3fBgEeISQGDp9/Y77FKzSbFdtWmakAlgWnRpUtu9Qs3lOOlK/PMyxyHBjBr4IH806lBZu3Cv3uwqT2uVzO/Rh+/xFE6FuJzcDk4vvBjmuuybEw7WdTdz1m4e6HwIDAQAB";
    private static final String[] GOOGLE_CATALOG = new String[]{"v.n.5",
            "v.n.5", "v.n.5" , "v.n.5" , "v.n.5" , "v.n.5" ,  "v.n.5" , "v.n.5" ,  "v.n.5"};


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.donation);
        Toolbar toolbar = (Toolbar)findViewById(R.id.dtoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        DonationsFragment donationsFragment;
        if (BuildConfig.DONATIONS_GOOGLE) {
            donationsFragment = DonationsFragment.newInstance(BuildConfig.DEBUG, true, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAk3cQ5G6ZNxgLZeg737jR4o1qCaenT4AA+Kx88QzJjh8jq//ESvQ+NCo5nC/Abt5M0Jfx63oFmL6E/Qu1wMmHvjHVHixsPnXIm9DgDagHtTgTe4RYog5rmwj+hYzUw+3EYT+SKh+N39z6RzR4Ms7i5jsg3uhtdfTJ3La16Od7IA7VO5LAutT9W31fzz4NQ4edLaxysEGpn9/ejFnSZ4kJUHNOAnN3fBgEeISQGDp9/Y77FKzSbFdtWmakAlgWnRpUtu9Qs3lOOlK/PMyxyHBjBr4IH806lBZu3Cv3uwqT2uVzO/Rh+/xFE6FuJzcDk4vvBjmuuybEw7WdTdz1m4e6HwIDAQAB", GOOGLE_CATALOG,
                    getResources().getStringArray(R.array.google_catalog_values), false, null, null,
                    null, false, null, null, false, null);
        }
        ft.replace(R.id.donations_activity_container, donationsFragment, "donationsFragment");
        ft.commit();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag("donationsFragment");
        if (fragment != null) {
            fragment.onActivityResult(requestCode, resultCode, data);
        }
    }

}