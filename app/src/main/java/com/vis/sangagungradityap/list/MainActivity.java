package com.vis.sangagungradityap.list;

import android.app.ListActivity;
import android.content.Context;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] angkatan = {"Capung", "Orion", "Angklung", "Astro", "Kawung", "Turbo", "Jagung", "Ultra", "Kangkung"};

        Integer[] imgId ={R.drawable.capung,R.drawable.orion,R.drawable.angklung,R.drawable.astro,R.drawable.kawung,
                R.drawable.turbo,R.drawable.jagung, R.drawable.ultra};

        AngkatanAdapter adapter = new AngkatanAdapter(this, angkatan, imgId);

        ((ListView) findViewById(R.id.list)).setAdapter(adapter);
    }

    private static class AngkatanAdapter extends ArrayAdapter<String> {

        private Integer[] img;

        public AngkatanAdapter(Context context, String[] arrAngkatan, Integer[] imgId) {
            super(context, 0, arrAngkatan);
            img = imgId;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = LayoutInflater.from(getContext()).inflate(R.layout.list_item_angkatan, null);
            TextView tv = (TextView) v.findViewById(R.id.teks);
            tv.setText(getItem(position).toString());
            ImageView imv = (ImageView) v.findViewById(R.id.img);

            imv.setImageDrawable(getContext().getResources().getDrawable(img[position]));
            return v;
        }
    }
}