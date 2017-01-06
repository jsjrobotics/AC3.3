package nyc.c4q.testsolution;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            return;
        }
        getSupportFragmentManager().beginTransaction()
                .add(R.id.content, new MainFragment())
                .commit();
    }
}
