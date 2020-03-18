package su.ternovskiy.numberrecyclerviewonfragments.adapter;

import androidx.annotation.NonNull;

import su.ternovskiy.numberrecyclerviewonfragments.data.Number;

public interface OnNumberClickListener {
    void onItemClick(@NonNull Number number);
}
