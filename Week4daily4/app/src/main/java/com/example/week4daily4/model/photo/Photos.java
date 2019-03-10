
package com.example.week4daily4.model.photo;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Photos implements Parcelable
{

    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("pages")
    @Expose
    private String pages;
    @SerializedName("perpage")
    @Expose
    private Integer perpage;
    @SerializedName("total")
    @Expose
    private String total;
    @SerializedName("photo")
    @Expose
    private List<Photo> photo = null;
    public final static Parcelable.Creator<Photos> CREATOR = new Creator<Photos>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Photos createFromParcel(Parcel in) {
            return new Photos(in);
        }

        public Photos[] newArray(int size) {
            return (new Photos[size]);
        }

    }
    ;

    private Photos(Parcel in) {
        this.page = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.pages = ((String) in.readValue((String.class.getClassLoader())));
        this.perpage = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.total = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.photo, (com.example.week4daily4.model.photo.Photo.class.getClassLoader()));
    }

    public Photos() {
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public Integer getPerpage() {
        return perpage;
    }

    public void setPerpage(Integer perpage) {
        this.perpage = perpage;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Photo> getPhoto() {
        return photo;
    }

    public void setPhoto(List<Photo> photo) {
        this.photo = photo;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(page);
        dest.writeValue(pages);
        dest.writeValue(perpage);
        dest.writeValue(total);
        dest.writeList(photo);
    }

    public int describeContents() {
        return  0;
    }

}
