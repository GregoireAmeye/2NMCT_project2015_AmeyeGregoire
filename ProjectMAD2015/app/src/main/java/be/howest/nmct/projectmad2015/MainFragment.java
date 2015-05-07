package be.howest.nmct.projectmad2015;


import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import be.howest.nmct.projectmad2015.Admin.Data;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment  implements OnMapReadyCallback {


    //Button btnToonLijst;

    GoogleMap LocatieMap;
    public void onMapReady(GoogleMap map) {



        for(int i=0; i<Data.Locatie.values().length;i++)
        {
            Data.Locatie l = Data.Locatie.values()[i];

            // set locatie Cursor
            double lat = Double.parseDouble(l.getLatitudeLocatie());
            double lng = Double.parseDouble(l.getLongitudeLocatie());

            LatLng latlon = new LatLng(lat, lng);




        String name = l.getNaamLocatie();
        String beschr = l.getBeschrijvingLocatie();



            BitmapDescriptor bdf;
            switch(l.getCategorieLocatie())
            {
                case ESCAPE:
                    bdf = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED);
                    break;
                case ANDERE:
                    bdf = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE);
                    break;
                default:
                    bdf = null;
                    break;
            }

            LocatieMap.addMarker(new MarkerOptions()
                    .title(name)
                    .snippet(beschr).position(latlon).icon(bdf));
            ;

        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_main, container, false);


        MapFragment mf = (MapFragment) getFragmentManagerCorrect().findFragmentById(R.id.map);
        LocatieMap = mf.getMap();
        mf.getMapAsync(MainFragment.this);

        //pos vanuit InfoLocatieFragment
        Bundle args = getArguments();
        if(args!=null){
            int pos = args.getInt("key_pos");
            loc =Data.Locatie.values()[pos];
            setMapZoom();
        }


        return v;
    }



    private FragmentManager getFragmentManagerCorrect() {
        FragmentManager fm;
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            fm = getFragmentManager();
        } else {

            fm = getChildFragmentManager();
        }
        return fm;
    }

    private String LOCATIE = "key_loc";
    Data.Locatie loc;
    public void setLonLat(Data.Locatie loc) {
        this.loc = loc;
        Bundle bundle = new Bundle();
        bundle.putInt(LOCATIE, loc.ordinal());

        setMapZoom();

    }


    private void setMapZoom()
    {


        // set locatie
        double lat = Double.parseDouble(loc.getLatitudeLocatie());
        double lng = Double.parseDouble(loc.getLongitudeLocatie());

        LatLng latlon = new LatLng(lat, lng);



        LocatieMap.setMyLocationEnabled(true);
        LocatieMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latlon, 20));
        LocatieMap.animateCamera(CameraUpdateFactory.zoomTo(15), 1000, null);
    }
}
