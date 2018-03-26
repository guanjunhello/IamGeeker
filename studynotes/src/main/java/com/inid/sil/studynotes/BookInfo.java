package com.inid.sil.studynotes;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * created by Guan at 2018/3/26 0026 下午 4:48
 * description:
 */
public class BookInfo implements Parcelable {
    private String name;
    private List<NoteInfo> noteInfos;

    public BookInfo(String name, List<NoteInfo> noteInfos) {
        this.name = name;
        this.noteInfos = noteInfos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<NoteInfo> getNoteInfos() {
        return noteInfos;
    }

    public void setNoteInfos(List<NoteInfo> noteInfos) {
        this.noteInfos = noteInfos;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeTypedList(this.noteInfos);
    }

    protected BookInfo(Parcel in) {
        this.name = in.readString();
        this.noteInfos = in.createTypedArrayList(NoteInfo.CREATOR);
    }

    public static final Parcelable.Creator<BookInfo> CREATOR = new Parcelable.Creator<BookInfo>() {
        @Override
        public BookInfo createFromParcel(Parcel source) {
            return new BookInfo(source);
        }

        @Override
        public BookInfo[] newArray(int size) {
            return new BookInfo[size];
        }
    };
}
