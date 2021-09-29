package com.example.custom_listviewasync_task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class P1ItemProfile extends AppCompatActivity {
    private androidx.appcompat.widget.Toolbar toolbar;
    TextView itemNameView,itemDescView,itemPriceView,totalAmountView,noOFPlatesView;
    ImageView itemImageView;
    int itemPrice=0,total_amount=0,no_of_plates=0;
    Button addItem,removeItem,orderItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p1_item_profile);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Order Food");

        setSupportActionBar(toolbar);

        itemNameView = (TextView) findViewById(R.id.itemname);
        itemDescView = (TextView) findViewById(R.id.itemdesc);
        itemImageView = (ImageView) findViewById(R.id.itemimage);
        itemPriceView = (TextView) findViewById(R.id.itemprice);
        totalAmountView = (TextView) findViewById(R.id.totalamount);
        noOFPlatesView = (TextView)findViewById(R.id.noplates);
        addItem = (Button) findViewById(R.id.additems);
        removeItem = (Button)findViewById(R.id.minusbutton);
        orderItems = (Button) findViewById(R.id.orderfood);






        Intent intent = getIntent();
        String itemNameString = intent.getStringExtra("itemName");
        String itemDescString = intent.getStringExtra("itemDesc");
        int itemImageInteger = intent.getIntExtra("itemImages",0);


        //Integer image = Integer.getInteger(itemImageString);

        if (itemNameString.equals("Grilled Chicken")){

            itemPrice=650;
        }
        else if (itemNameString.equals("Fish Fry")){
            itemPrice=400;
        }
        else if (itemNameString.equals("Shahi Paneer")){
            itemPrice=500;
        }else if (itemNameString.equals("Egg Biryani")){
            itemPrice=380;
        }else if (itemNameString.equals("French Fries")){
            itemPrice=99;
        }
        else {
            itemPrice=550;
        }
        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeItem.setVisibility(View.VISIBLE);

                no_of_plates = no_of_plates + 1;
                total_amount = itemPrice * no_of_plates;
                noOFPlatesView.setText(no_of_plates+"");
                totalAmountView.setText(total_amount+"");
            }
        });
        removeItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                no_of_plates = no_of_plates - 1;
                total_amount = itemPrice * no_of_plates;
                noOFPlatesView.setText(no_of_plates+"");
                totalAmountView.setText(total_amount+"");
                if (no_of_plates==0){
                    removeItem.setVisibility(View.INVISIBLE);
                }

            }
        });





        itemNameView.setText(itemNameString);
        itemDescView.setText(itemDescString);
        itemImageView.setImageResource(itemImageInteger);
        itemPriceView.setText(itemPrice+"");


        orderItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Bill Amount: "+total_amount,Toast.LENGTH_SHORT).show();
                startActivity(new Intent(P1ItemProfile.this,P1ListViewIndianRestaurant.class));

            }
        });





    }

}