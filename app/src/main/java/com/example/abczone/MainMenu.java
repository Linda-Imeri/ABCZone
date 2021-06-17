
package com.example.alphabet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity {

    View listView;
String items[]={"Alphabets","Numbers","Animals","Colors"};
int items_images[]={R.drawable.alphabets, R.drawable.numbers, R.drawable.animals, R.drawable.colors};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        listView=findViewById(R.id.listView);
        listView(new CostumAdapter());
    }

    private void listView(CostumAdapter costumAdapter) {
    }

    public class CostumAdapter extends BaseAdapter{


    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView=getLayoutInflater().inflate(R.layout.costume_listview,null);

        ImageView image=convertView.findViewById(R.id.item_image);
        TextView item_name=convertView.findViewById(R.id.item_name);

        return convertView;
    }
}
}