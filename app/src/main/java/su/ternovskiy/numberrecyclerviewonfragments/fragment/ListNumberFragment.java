package su.ternovskiy.numberrecyclerviewonfragments.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import su.ternovskiy.numberrecyclerviewonfragments.NumberRouter;
import su.ternovskiy.numberrecyclerviewonfragments.adapter.NumberAdapter;
import su.ternovskiy.numberrecyclerviewonfragments.adapter.OnNumberClickListener;
import su.ternovskiy.numberrecyclerviewonfragments.R;
import su.ternovskiy.numberrecyclerviewonfragments.data.Number;
import su.ternovskiy.numberrecyclerviewonfragments.data.NumberProvider;

public class ListNumberFragment extends Fragment {

    private static final String NUMBERS_COUNT = "NUMBERS_COUNT";
    private List<Number> mNumberList;

    private RecyclerView mRecyclerView;
    private int mNumbersCount = 100;
    private NumberRouter mNumberRouter;
    private final NumberProvider mNumberProvider = new NumberProvider();
    private final NumberAdapter mNumberAdapter = new NumberAdapter();
    private final OnNumberClickListener mOnNumberClickListener = number ->
            mNumberRouter.openNumberShowFragment(number);

    public static Fragment newInstance() {
        return new ListNumberFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNumberList = mNumberProvider.getNumberList();
        mNumberAdapter.setNumberList(mNumberList);
        mNumberAdapter.setNumberClickListener(mOnNumberClickListener);

        if (savedInstanceState != null){
            mNumbersCount = savedInstanceState.getInt(NUMBERS_COUNT);
            mNumberList = mNumberProvider.getNumberList(mNumbersCount);
            mNumberAdapter.setNumberList(mNumberList);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_numbers, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = view.findViewById(R.id.number_list_recycler_view);
        FloatingActionButton floatingActionButton = view.findViewById(R.id.number_list_fab);
        initRecyclerView();

        floatingActionButton.setOnClickListener(v -> {
            int nextNumber = mNumberAdapter.getItemCount() + 1;
            Number number = new Number(nextNumber, (nextNumber % 2 == 0) ? Color.RED : Color.BLUE);
            mNumberList.add(number);
            mNumberAdapter.notifyDataSetChanged();
            mNumbersCount++;
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mNumberRouter = (NumberRouter) context;
    }

    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false);
        int quantityOfColumns = getResources().getInteger(R.integer.column_quantity);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(requireContext(), quantityOfColumns);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL);
        DividerItemDecoration dividerItemDecorationHorizontal =
                new DividerItemDecoration(requireContext(), DividerItemDecoration.HORIZONTAL);
        mRecyclerView.addItemDecoration(dividerItemDecoration);
        mRecyclerView.addItemDecoration(dividerItemDecorationHorizontal);
        mRecyclerView.setAdapter(mNumberAdapter);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(NUMBERS_COUNT, mNumbersCount);
    }
}
