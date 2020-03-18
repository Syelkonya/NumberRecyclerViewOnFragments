package su.ternovskiy.numberrecyclerviewonfragments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


import su.ternovskiy.numberrecyclerviewonfragments.data.Number;
import su.ternovskiy.numberrecyclerviewonfragments.fragment.ListNumberFragment;
import su.ternovskiy.numberrecyclerviewonfragments.fragment.NumberShowFragment;

public class MainActivity extends AppCompatActivity implements NumberRouter {

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

    @Override
    public void openNumberShowFragment(@NonNull Number number) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.root, NumberShowFragment.newInstance(number))
                .addToBackStack(null)
                .commit();
    }
}