package com.example.custom_listviewasync_task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class P2DisplayData extends AppCompatActivity {
    private Toolbar toolbar;
    private Button display;
    ImageView imageView;
    ProgressDialog progressBar;
    URL imagelink = null;
    InputStream inputStream = null;
    Bitmap downloadedImage = null;
    LinearLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p2_display_data);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Display Data");
        setSupportActionBar(toolbar);

        imageView = (ImageView) findViewById(R.id.downloaded_image);
        display = (Button) findViewById(R.id.displaydatabth);
        layout = (LinearLayout) findViewById(R.id.layout_container);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DownloadImage asyncTask = new DownloadImage();
                asyncTask.execute("https://im.rediff.com/movies/2018/oct/11navratri-dress1.jpg?w=670&h=900");

            }
        });
    }
    private class DownloadImage extends AsyncTask<String, String, Bitmap>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar = new ProgressDialog(P2DisplayData.this);
            progressBar.setMessage("Downloading....");
            progressBar.setCancelable(false);
            progressBar.show();
        }

        @Override
        protected Bitmap doInBackground(String... strings) {

            try {
                imagelink = new URL(strings[0]);
                HttpURLConnection connection = (HttpURLConnection) imagelink.openConnection();
                connection.setDoInput(true);
                connection.connect();
                inputStream = connection.getInputStream();
                BitmapFactory .Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                downloadedImage = BitmapFactory.decodeStream(inputStream,null,options);

            } catch (Exception e) {
                e.printStackTrace();
            }


            return downloadedImage;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            if (imageView!=null){
                progressBar.hide();
                layout.setVisibility(View.VISIBLE);
                imageView.setImageBitmap(downloadedImage);
            }
            else progressBar.show();

        }
    }

}