package be.howest.nmct.projectmad2015;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import be.howest.nmct.projectmad2015.Admin.Data;


/**
 * A simple {@link Fragment} subclass.
 */
public class InfoLocatieFragment extends Fragment {


    public InfoLocatieFragment() {
        // Required empty public constructor
    }



    TextView txtNaamLoc;
    TextView txtAdresLoc;
    TextView txtBeschrijving;
    Button btnInfoMap;



    int pos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_info_locatie, container, false);

        txtNaamLoc = (TextView)v.findViewById(R.id.txtNaamLocInfo);
        txtAdresLoc = (TextView)v.findViewById(R.id.txtAdresLocInfo);
        txtBeschrijving = (TextView)v.findViewById(R.id.txtBeschrijvingInfo);

        btnInfoMap = (Button)v.findViewById(R.id.btnMapsInfo);
        btnInfoMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getBaseContext(),MainActivity.class);
                intent.putExtra("key_pos", pos);
                getActivity().startActivity(intent);
            }
        });

        pos = getArguments().getInt("key_pos");
        Data.Locatie loc = Data.Locatie.values()[pos];
        if(loc != null)
        {
            txtNaamLoc.setText(loc.getNaamLocatie());
            txtAdresLoc.setText(loc.getStadLocatie()+ ", "+loc.getStraatLocatie());
            txtBeschrijving.setText(loc.getBeschrijvingLocatie());
        }

        return v;
    }





}
