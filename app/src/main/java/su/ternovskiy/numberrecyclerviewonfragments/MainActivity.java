package su.ternovskiy.numberrecyclerviewonfragments;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


import su.ternovskiy.numberrecyclerviewonfragments.fragment.ListNumberFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.root, ListNumberFragment.newInstance())
                    .commit();
        }
    }
}