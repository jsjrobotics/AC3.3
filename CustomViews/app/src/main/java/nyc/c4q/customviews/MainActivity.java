package nyc.c4q.customviews;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final long UPDATE_DELAY_TIME_MS = 20;
    private Handler mHandler;
    private ArrayList<BouncingBall> mViewsToUpdate = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout root = (RelativeLayout) findViewById(R.id.activity_main);
        for (int index = 0; index < root.getChildCount(); index ++){
            mViewsToUpdate.add((BouncingBall) root.getChildAt(index));
        }
        mHandler = new Handler();
        updateBall().run();
    }

    private Runnable updateBall() {
        return () -> {
            for (BouncingBall b : mViewsToUpdate){
                b.update();
            }
            mHandler.postDelayed(updateBall(), UPDATE_DELAY_TIME_MS);
        };
    }
}
