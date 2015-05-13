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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import be.howest.nmct.projectmad2015.Admin.Data;


/**
 * A simple {@link Fragment} subclass.
 */
public class LocatiesFragment extends ListFragment {

    public LocatieAdapter la;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        la = new LocatieAdapter(getActivity());
        setListAdapter(la);




    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_locaties, container, false);



        return v;

    }


    OnLocatieFragmentListener mListener;
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        Intent intent = new Intent(getActivity().getBaseContext(),
                InfoActivity.class);
        intent.putExtra("key_pos", position);
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






    //Adapter
    public class LocatieAdapter extends ArrayAdapter<Data.Locatie> {

        public LocatieAdapter(Context context) {
            super(context, R.layout.row_locatie, R.id.txtLocatieNaam, Data.Locatie.values());

        }

        Data.Locatie loc;
        Button btnShowMaps;
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View row = super.getView(position, convertView, parent);
            loc = Data.Locatie.values()[position];

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
                    Data.Locatie l = Data.Locatie.values()[position];
                    mListener.demandLatLon(l);
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
