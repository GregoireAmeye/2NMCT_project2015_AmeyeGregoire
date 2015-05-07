package be.howest.nmct.projectmad2015;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;

import be.howest.nmct.projectmad2015.Admin.Data;


public class MainActivity extends Activity implements LocatiesFragment.OnLocatieFragmentListener{

    private DrawerLayout dl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intent = getIntent();
        int pos = intent.getIntExtra("key_pos", -1);

        if(pos==-1)
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new MainFragment(), "MainFragment")
                    .commit();
        else
        {
            Bundle bundle=new Bundle();
            bundle.putInt("key_pos", pos);

            MainFragment mf=new MainFragment();
            mf.setArguments(bundle);

            getFragmentManager().beginTransaction()
                    .add(R.id.container, mf, "MainFragment")
                    .commit();
        }

        dl = (DrawerLayout) findViewById(R.id.drawer_layout);



    }



    @Override
    public void demandLatLon(Data.Locatie loc) {
        FragmentManager fragmentManager = getFragmentManager();


        MainFragment mf = (MainFragment) getFragmentManager().findFragmentByTag("MainFragment");



        mf.setLonLat(loc);
        dl.closeDrawer(Gravity.LEFT);


        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, mf);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
