package be.howest.nmct.projectmad2015;


import android.app.Activity;
import android.app.Fragment;
import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import be.howest.nmct.projectmad2015.Admin.Data;


/**
 * A simple {@link Fragment} subclass.
 */
public class LocatiesFragment extends ListFragment{

    public LocatieAdapter la;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        List<Data.Locatie> lijstLocs = Arrays.asList(Data.Locatie.values());
        la = new LocatieAdapter(getActivity(), lijstLocs);
        setListAdapter(la);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_locaties, container, false);


        Spinner spinner = (Spinner) v.findViewById(R.id.spinnerCategories);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item);

        for(int i =0; i<Data.Categorie.values().length; i++)
        {
            adapter.add(Data.Categorie.values()[i].getCategorie());
        }

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                List<Data.Locatie> lijstLocs = new ArrayList<>();


                for(Data.Locatie loc : Data.Locatie.values())
                {
                    if (loc.getCategorieLocatie() == Data.Categorie.values()[position] || Data.Categorie.values()[position] == Data.Categorie.All) {

                        lijstLocs.add(loc);
                    }
                }


                la = new LocatieAdapter(getActivity(), lijstLocs);
                setListAdapter(la);



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                List<Data.Locatie> lijstLocs = Arrays.asList(Data.Locatie.values());
                la = new LocatieAdapter(getActivity(), lijstLocs);
                setListAdapter(la);

            }
        });

        spinner.setAdapter(adapter);



        return v;

    }



    OnLocatieFragmentListener mListener;
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        Intent intent = new Intent(getActivity().getBaseContext(),
                InfoActivity.class);
        for(int i =0; i<Data.Locatie.values().length; i++)
        {
            if(la.Locs.get(position) == Data.Locatie.values()[i])
            {
                intent.putExtra("key_pos", i);
            }
        }

        getActivity().startActivity(intent);

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mListener = (OnLocatieFragmentListener) activity;

    }



    public interface OnLocatieFragmentListener {
        public void demandLatLon(Data.Locatie loc);
    }






    //Locatie Adapter
    public class LocatieAdapter extends ArrayAdapter<Data.Locatie> {

        public LocatieAdapter(Context context, List<Data.Locatie> Locs) {

            super(context, R.layout.row_locatie, R.id.txtLocatieNaam, Locs);
            this.Locs = Locs;
        }

        List<Data.Locatie> Locs;
        Data.Locatie loc;
        Button btnShowMaps;
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View row = super.getView(position, convertView, parent);
            loc = Locs.get(position);




                ViewHolder vh= (ViewHolder) row.getTag();

                if(vh==null)
                {
                    vh = new ViewHolder(row);
                    row.setTag(vh);
                }

                TextView txtNaamLocatie = vh.txtNaamLocatie;
                txtNaamLocatie.setText(loc.getNaamLocatie());

                TextView txtLocatieBeschr = vh.txtLocatieBeschr;
                txtLocatieBeschr.setText(loc.getStadLocatie());

                TextView txtCategorie = vh.txtCategorie;
                txtCategorie.setText(loc.getCategorieLocatie().getCategorie());


                btnShowMaps = (Button) row.findViewById(R.id.btnMaps);
                btnShowMaps.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        for(int i =0; i<Data.Locatie.values().length; i++)
                        {
                            if(la.Locs.get(position) == Data.Locatie.values()[i])
                            {
                                Data.Locatie l = Data.Locatie.values()[i];
                                mListener.demandLatLon(l);

                            }
                        }


                    }
                });

                return row;


        }

        class ViewHolder {

            TextView txtNaamLocatie;
            TextView txtLocatieBeschr;
            TextView txtCategorie;
            Button btnShowOnMaps;

            public ViewHolder(View row) {
                txtNaamLocatie = (TextView) row.findViewById(R.id.txtLocatieNaam);
                txtLocatieBeschr = (TextView) row.findViewById(R.id.txtLocatieBeschr);
                txtCategorie = (TextView) row.findViewById(R.id.txtCategorie);
                btnShowOnMaps = (Button) row.findViewById(R.id.btnMaps);
            }
        }

    }
}
