
package practice.com.simpleimagefeed.data.model;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AlbumImagesResponse implements Parcelable
{

    @SerializedName("data")
    @Expose
    private List<AlbumImage> data = null;
    @SerializedName("success")
    @Expose
    private boolean success;
    @SerializedName("status")
    @Expose
    private int status;
    public final static Creator<AlbumImagesResponse> CREATOR = new Creator<AlbumImagesResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public AlbumImagesResponse createFromParcel(Parcel in) {
            return new AlbumImagesResponse(in);
        }

        public AlbumImagesResponse[] newArray(int size) {
            return (new AlbumImagesResponse[size]);
        }

    }
    ;

    protected AlbumImagesResponse(Parcel in) {
        in.readList(this.data, (AlbumImage.class.getClassLoader()));
        this.success = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.status = ((int) in.readValue((int.class.getClassLoader())));
    }

    public AlbumImagesResponse() {
    }

    public List<AlbumImage> getData() {
        return data;
    }

    public void setData(List<AlbumImage> data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(data);
        dest.writeValue(success);
        dest.writeValue(status);
    }

    public int describeContents() {
        return  0;
    }

}
