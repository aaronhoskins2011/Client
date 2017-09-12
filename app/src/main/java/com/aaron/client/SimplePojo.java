package com.aaron.client;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by aaron on 9/12/17.
 */

public class SimplePojo implements Parcelable {
    String someString;

    protected SimplePojo(Parcel in) {
        someString = in.readString();
    }

    public static final Creator<SimplePojo> CREATOR = new Creator<SimplePojo>() {
        @Override
        public SimplePojo createFromParcel(Parcel in) {
            return new SimplePojo(in);
        }

        @Override
        public SimplePojo[] newArray(int size) {
            return new SimplePojo[size];
        }
    };

    public String getSomeString() {
        return someString;
    }

    public void setSomeString(String someString) {
        this.someString = someString;
    }

    public SimplePojo() {

    }

    public SimplePojo(String someString) {

        this.someString = someString;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(someString);
    }
}
