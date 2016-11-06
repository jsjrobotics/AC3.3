package nyc.c4q.anotherone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * Documentation needed for:
 * getIntent()
 * getIntExtra()
 *
 */
public class MainActivity extends AppCompatActivity {

    private static final int DEFAULT_VIEW = 1;
    private static final String VIEW_EXTRA = "intent.extra.view";
    private static final int BLUE = 0xFF0000FF;
    private static final int BLACK = 0xFF000000;

    private View mRoot;
    private View mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int viewToDispay = getIntent().getIntExtra(VIEW_EXTRA, DEFAULT_VIEW);
        setupView(viewToDispay);
        mRoot = findViewById(R.id.main_view);
        if (viewToDispay == DEFAULT_VIEW){
            mButton = findViewById(R.id.button1);
        } else {
            mButton = findViewById(R.id.button2);
        }
        mRoot.setOnClickListener(getClickListener());
        mButton.setOnClickListener(getClickListener());
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( view == mRoot) {
                    mRoot.setBackgroundColor(BLUE);
                } else {
                    mRoot.setBackgroundColor(BLACK);
                }
            }
        };
    }

    public void setupView(int viewOptions) {
        if (viewOptions == DEFAULT_VIEW){
            setContentView(R.layout.activity_main);
        } else {
            setContentView(R.layout.activity_submenu);
        }
    }
}
