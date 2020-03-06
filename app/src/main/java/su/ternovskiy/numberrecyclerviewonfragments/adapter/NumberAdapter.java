package su.ternovskiy.numberrecyclerviewonfragments.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import java.util.List;

import su.ternovskiy.numberrecyclerviewonfragments.R;
import su.ternovskiy.numberrecyclerviewonfragments.data.Number;


public class NumberAdapter extends Adapter<NumberAdapter.NumberViewHolder> {

    private List<Number> mNumberList;
    private OnNumberClickListener mNumberClickListener;


    @NonNull
    @Override
    public NumberAdapter.NumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.number_item, parent, false);
        return new NumberViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull NumberAdapter.NumberViewHolder holder, int position) {
        Number number = mNumberList.get(position);
        holder.bindView(number);
    }

    @Override
    public int getItemCount() {
        return mNumberList.size();
    }

    public void setNumberList(List<Number> numberList) {
        mNumberList = numberList;
    }

    class NumberViewHolder extends RecyclerView.ViewHolder {
        private final TextView mNumberTextView;

        NumberViewHolder(@NonNull View itemView) {
            super(itemView);
            mNumberTextView = itemView.findViewById(R.id.item_number_text_view);
        }

        void bindView(Number number) {
            mNumberTextView.setText(String.valueOf(number.getNumberValue()));
            mNumberTextView.setTextColor(number.getNumberColor());
            itemView.setOnClickListener(v -> {
                if(mNumberClickListener != null){
                    mNumberClickListener.onItemClick(number);
                }
            });
        }
    }

    public void setNumberClickListener(OnNumberClickListener numberClickListener) {
        mNumberClickListener = numberClickListener;
    }
}
