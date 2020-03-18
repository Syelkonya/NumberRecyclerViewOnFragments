package su.ternovskiy.numberrecyclerviewonfragments.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import su.ternovskiy.numberrecyclerviewonfragments.R;
import su.ternovskiy.numberrecyclerviewonfragments.data.Number;

public class NumberShowFragment extends Fragment {

    private static final String ARG_NUMBER = "ARG_NUMBER";

    public static NumberShowFragment newInstance(@NonNull Number number) {
        NumberShowFragment fragment = new NumberShowFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_NUMBER, number);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_show_number,container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView showNumberTextView = view.findViewById(R.id.show_number_text_view);
        Bundle arguments = getArguments();
        Number number = (arguments != null) ? arguments.getParcelable(ARG_NUMBER) : null;
        if (number != null) {
            String numberString = String.valueOf(number.getNumberValue());
            showNumberTextView.setText(numberString);
            showNumberTextView.setTextColor(number.getNumberColor());
        }
    }
}
