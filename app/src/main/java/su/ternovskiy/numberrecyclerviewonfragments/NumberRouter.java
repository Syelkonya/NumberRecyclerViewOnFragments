package su.ternovskiy.numberrecyclerviewonfragments;

import androidx.annotation.NonNull;

import su.ternovskiy.numberrecyclerviewonfragments.data.Number;

public interface NumberRouter {
    void openNumberShowFragment(@NonNull Number number);
}
