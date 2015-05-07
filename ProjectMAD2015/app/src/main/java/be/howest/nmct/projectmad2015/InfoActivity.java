package be.howest.nmct.projectmad2015;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class InfoActivity extends Activity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        //positie doorgeven aan fragment
        Intent intent = getIntent();
        int pos = intent.getIntExtra("key_pos",0);

        InfoLocatieFragment ilf = new InfoLocatieFragment();
        Bundle b = new Bundle();
        b.putInt("key_pos", pos);
        ilf.setArguments(b);

        getFragmentManager().beginTransaction().add(R.id.containerInfo, ilf, "InfoLocatieFragment").commit();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
