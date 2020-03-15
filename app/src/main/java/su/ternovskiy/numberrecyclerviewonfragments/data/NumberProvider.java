package su.ternovskiy.numberrecyclerviewonfragments.data;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

public class NumberProvider {
    private final List<Number> mNumberList;

    public NumberProvider() {
        mNumberList = new ArrayList<>();

        for(int i = 1; i <= 100; i++){
            mNumberList.add(new Number(i,(i % 2 == 0) ? Color.RED : Color.BLUE));
        }
    }

    public List<Number> getNumberList() {
        return mNumberList;
    }


    public List<Number> getNumberList(int savedInstanceNumber) {
        for(int i = 101; i <= savedInstanceNumber; i++){
            mNumberList.add(new Number(i,(i % 2 == 0) ? Color.RED : Color.BLUE));
        }
        return mNumberList;
    }


}
