package vaibhav.vaibhavmain;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.Button;

/**
 * Created by simpl on 20-03-2016.
 */

public class Fragment extends FragmentActivity {
    ViewPager viewpager;


Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        viewpager = (ViewPager) findViewById(R.id.pager);
        Tour padapter = new Tour(getSupportFragmentManager());
        viewpager.setAdapter(padapter);
        Boolean isFirstRun = getSharedPreferences("PREFERENCE"
                , MODE_PRIVATE)
                .getBoolean("isFirstRun", true);


   }}
