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


public class MainFragment extends Fragment  implements OnMapReadyCallback {

    GoogleMap LocatieMap;
    public void onMapReady(GoogleMap map) {
        Bundle args = getArguments();
        if(args==null){

            //zoom instellen bij opstarten
            LatLng latlon = new LatLng(50.8308551,4.358102);

            LocatieMap.setMyLocationEnabled(true);
            LocatieMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latlon, 7));
        }

        //markers zetten
        setMarkers(Data.Locatie.values());
    }


    private void setMarkers(Data.Locatie[] values) {

        //Vorige markers verwijderen
        LocatieMap.clear();

        //markers 1 per 1 toevoegen
        for(int i=0; i<values.length;i++)
        {
            Data.Locatie l = values[i];

            // set locatie Cursor
            double lat = Double.parseDouble(l.getLatitudeLocatie());
            double lng = Double.parseDouble(l.getLongitudeLocatie());

            LatLng latlon = new LatLng(lat, lng);




            String name = l.getNaamLocatie();
            String adres = l.getStadLocatie() +", "+l.getStraatLocatie();



            BitmapDescriptor bdf;
            switch(l.getCategorieLocatie())
            {
                case ESCAPE:
                    bdf = BitmapDescriptorFactory.fromResource(R.drawable.escape);
                    break;
                case SPORT:
                    bdf = BitmapDescriptorFactory.fromResource(R.drawable.sport);
                    break;
                case ANDERE:
                    bdf = BitmapDescriptorFactory.fromResource(R.drawable.andere);
                    break;
                default:
                    bdf = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED);
                    break;
            }


            LocatieMap.addMarker(new MarkerOptions()
                    .title(name)
                    .snippet(adres).position(latlon).icon(bdf));


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

        LocatieMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latlon, 10));
        LocatieMap.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);
    }
}
