package com.example.iis5.customlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //creating listviwand arraylist of type string
    private ListView listView;
    private ArrayList<String> namelist, numberlist;
    private TextView nametext, numbertext;
    private Myadapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//creating object for the list and text views
        nametext = (TextView) findViewById(R.id.name_text);
        numbertext = (TextView) findViewById(R.id.number_text);
        listView = (ListView) findViewById(R.id.list_view);
//adding namelist to the arraylist object
        namelist = new ArrayList<>();
        namelist.add("Name1");
        namelist.add("Name2");
        namelist.add("Name3");
        namelist.add("Name4");
        namelist.add("Name5");
        namelist.add("Name6");
        namelist.add("Name7");
//same as here
        numberlist = new ArrayList<>();
        numberlist.add("Phonenumber1");
        numberlist.add("Phonenumber2");
        numberlist.add("Phonenumber3");
        numberlist.add("Phonenumber4");
        numberlist.add("Phonenumber5");
        numberlist.add("Phonenumber6");
        numberlist.add("Phonenumber7");

        adapter = new Myadapter();
        listView.setAdapter(adapter);


    }
//creating a sub class called myadapter which extends baseadapter
    public class Myadapter extends BaseAdapter {
//it overridesthe methods called get count,getitem,getitemid and getview
        @Override
        public int getCount() {
            return namelist.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }
//it views the all  view in the viewholder
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            viewholder holder;
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.row_view, parent, false);
                holder = new viewholder();
                holder.bindview(convertView);
                convertView.setTag(holder);
                Log.e("MainActivity", "convertview is null");
            } else {
                holder = (viewholder) convertView.getTag();
            }
            holder.nametext.setText(namelist.get(position));
            holder.numbertext.setText(numberlist.get(position));
            return convertView;


        }

    }
//here it shows the  viewholder by the textview
    public class viewholder {
        TextView nametext, numbertext;

        void bindview(View convertview) {
            Log.e("MainActivity", "convertview is not null");
            nametext = (TextView) convertview.findViewById(R.id.name_text);
            numbertext = (TextView) convertview.findViewById(R.id.number_text);

        }
    }
}