package com.inid.sil.studynotes;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * created by Guan at 2018/3/26 0026 下午 3:43
 * description:
 */
public class NoteInfo implements Parcelable {

    private String title;
    private String source;

    public NoteInfo(String title, String source) {
        this.title = title;
        this.source = source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.source);
    }

    protected NoteInfo(Parcel in) {
        this.title = in.readString();
        this.source = in.readString();
    }

    public static final Parcelable.Creator<NoteInfo> CREATOR = new Parcelable.Creator<NoteInfo>() {
        @Override
        public NoteInfo createFromParcel(Parcel source) {
            return new NoteInfo(source);
        }

        @Override
        public NoteInfo[] newArray(int size) {
            return new NoteInfo[size];
        }
    };
}
