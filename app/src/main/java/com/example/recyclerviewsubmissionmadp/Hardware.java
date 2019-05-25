package com.example.recyclerviewsubmissionmadp;

import android.os.Parcel;
import android.os.Parcelable;

public class Hardware implements Parcelable {
    private String name, description, type, photo;
    private float price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeString(this.photo);
    }

    public Hardware() {
    }

    protected Hardware(Parcel in) {
        this.name = in.readString();
        this.description = in.readString();
        this.photo = in.readString();
    }


    public static final Creator<Hardware> CREATOR = new Creator<Hardware>() {
        @Override
        public Hardware createFromParcel(Parcel source) {
            return new Hardware(source);
        }
        @Override
        public Hardware[] newArray(int size) {
            return new Hardware[size];
        }
    };
}
