package nyc.c4q.testsolution;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import nyc.c4q.testsolution.backend.Backend;

public class SecondActivity extends AppCompatActivity {
    public static final String URL_TO_DOWNLOAD = "url_to_download";
    private boolean mBackPressedOnce = false;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        String urlToShow = getIntent().getStringExtra(URL_TO_DOWNLOAD);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        Picasso.with(this).load(Backend.getBaseUrl() + urlToShow).into(imageView);
    }

    @Override
    public void onBackPressed(){
        if(mBackPressedOnce == true){
            finish();
        } else {
            Toast.makeText(this, "Press once more to see list", Toast.LENGTH_SHORT).show();
            mBackPressedOnce = true;
        }
    }
}
