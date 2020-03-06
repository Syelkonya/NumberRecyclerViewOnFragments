package su.ternovskiy.numberrecyclerviewonfragments.data;


import android.os.Parcel;
import android.os.Parcelable;

public class Number implements Parcelable {

    private final int mNumberValue;
    private final int mNumberColor;

    public Number(int numberValue, int numberColor) {
        mNumberValue = numberValue;
        mNumberColor = numberColor;
    }

    private Number(Parcel in) {
        mNumberValue = in.readInt();
        mNumberColor = in.readInt();
    }

    public static final Creator<Number> CREATOR = new Creator<Number>() {
        @Override
        public Number createFromParcel(Parcel in) {
            return new Number(in);
        }

        @Override
        public Number[] newArray(int size) {
            return new Number[size];
        }
    };

    public int getNumberValue() {
        return mNumberValue;
    }

    public int getNumberColor() {
        return mNumberColor;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mNumberValue);
        dest.writeInt(mNumberColor);
    }
}
