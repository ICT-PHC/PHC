package com.roles.census.Adapters;

/**
 * Created by Teespire on 3/16/2017.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.roles.census.R;

public class LocateUsAdapter extends BaseAdapter {
    Context context;
    String[] locateus;

   // ImageLoader imageLoader = new ImageLoader(context);
   // private ArrayList<Category> arrayList;
    public LocateUsAdapter(Context context, String[] locateus) {
        this.locateus = locateus;

        this.context=context;

    }
    @Override
    public int getCount() {
        return locateus.length;
    }

    @Override
    public Object getItem(int position) {
        return locateus[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

   @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

       TextView text_view;
       TextView textView;
       ImageView image_view;


       LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       if (convertView == null) {
           convertView = inflater.inflate(R.layout.locateus_cell, null);
       }

       text_view = (TextView) convertView.findViewById(R.id.addreses);
      // textView = (TextView) convertView.findViewById(R.id.answer);
     //  image_view = (ImageView) convertView.findViewById(R.id.Places_icons);


       String text = locateus[position].toString();

        text_view.setText(text);
       //textView.setText(ans.toString());


        convertView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  Toast.makeText(context, "You Clicked "+arrayList.get(position).getName(), Toast.LENGTH_LONG).show();
                PlacesFragment placesFragment =new PlacesFragment();
                placesFragment.setNewValue(arrayList.get(position).getId());
                FragmentManager fragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
                fragmentManager.beginTransaction().add(R.id.container, placesFragment).addToBackStack(null).commit();*/
            }
        });
        return convertView;
    }
}