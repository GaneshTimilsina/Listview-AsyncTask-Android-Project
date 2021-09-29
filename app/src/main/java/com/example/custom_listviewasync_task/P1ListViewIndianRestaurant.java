package com.example.custom_listviewasync_task;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class P1ListViewIndianRestaurant extends AppCompatActivity {
    private Toolbar toolbar;
    ListView listView;
    ArrayList<P1DataItem> arrayList = new ArrayList<>();
    int pos;
    View listViewProvide;
    AlertDialog.Builder alertBuilder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p1_list_view_indian_restaurant);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Indian Restaurant");
        toolbar.setSubtitle("Feel Like Home");
        setSupportActionBar(toolbar);
        toolbar.inflateMenu(R.menu.p2menu_items);

        arrayList.add(new P1DataItem("Grilled Chicken", "Grilled chicken with garlic and lemon", R.drawable.grill_chicken, 500));
        arrayList.add(new P1DataItem("Fish Fry", "Enjoy local fish with coke in combo pack", R.drawable.fish_fry, 350));
        arrayList.add(new P1DataItem("Shahi Paneer", "Shahi paneer is a royal Mughlai dish where paneer is cooked in a rich yogurt, nuts and seeds gravy.", R.drawable.shahi_paneer, 200));
        arrayList.add(new P1DataItem("Egg Biryani", "Zesty marinade for egg biryani is made from freshly ground spices, grated ginger, minced garlic, chopped mint, and cilantro.", R.drawable.egg_biryani, 400));
        arrayList.add(new P1DataItem("French Fries", "Long, thin and crispy french fries available with coke and lemon ", R.drawable.french_fry, 150));
        arrayList.add(new P1DataItem("Keema Naan", "Sourdough wheat pancake stuffed with finely chopped lamb", R.drawable.keema_naan, 625));

        P1CustomViewAdapter customViewAdapter = new P1CustomViewAdapter(this, R.layout.p1mylist_view, arrayList);
        listView = findViewById(R.id.customlistview);
        listView.setAdapter(customViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(getApplicationContext(),arrayList.get(i).getItemName(),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), P1ItemProfile.class);
                intent.putExtra("itemName", arrayList.get(i).getItemName());
                intent.putExtra("itemDesc", arrayList.get(i).getItemDesc());
                intent.putExtra("itemImages", arrayList.get(i).getItemImage());

                startActivity(intent);
                //Toast.makeText(getApplicationContext(), arrayList.get(i).getItemPrice(),Toast.LENGTH_SHORT).show();
            }
        });

        alertBuilder = new AlertDialog.Builder(this);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int pos, long l) {

                alertBuilder.setMessage("")
                        .setCancelable(false)
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();



                            }
                        }).setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //finish();
                        Toast.makeText(getApplicationContext(), "Item Deleted!" + pos, Toast.LENGTH_SHORT).show();
                        arrayList.remove(pos);
                        customViewAdapter.notifyDataSetChanged();

                    }
                });




                /*
                Toast.makeText(getApplicationContext(), "Delete Item" + i, Toast.LENGTH_SHORT).show();
                arrayList.remove(i);
                customViewAdapter.notifyDataSetChanged();
                return true;

                 */

                AlertDialog dialog = alertBuilder.create();
                dialog.setTitle("Do you want to Delete item?");
                dialog.show();
            return true;
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.p2menu_items, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.help) {
            Toast.makeText(getApplicationContext(), "Long Press on Item to Delete Item", Toast.LENGTH_LONG).show();
        }
        return true;
    }
}