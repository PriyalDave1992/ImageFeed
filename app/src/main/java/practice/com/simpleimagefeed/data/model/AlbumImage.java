
package practice.com.simpleimagefeed.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AlbumImage implements Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private Object title;
    @SerializedName("description")
    @Expose
    private Object description;
    @SerializedName("datetime")
    @Expose
    private int datetime;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("animated")
    @Expose
    private boolean animated;
    @SerializedName("width")
    @Expose
    private int width;
    @SerializedName("height")
    @Expose
    private int height;
    @SerializedName("size")
    @Expose
    private int size;
    @SerializedName("views")
    @Expose
    private int views;
    @SerializedName("bandwidth")
    @Expose
    private int bandwidth;
    @SerializedName("vote")
    @Expose
    private Object vote;
    @SerializedName("favorite")
    @Expose
    private boolean favorite;
    @SerializedName("nsfw")
    @Expose
    private Object nsfw;
    @SerializedName("section")
    @Expose
    private Object section;
    @SerializedName("account_url")
    @Expose
    private Object accountUrl;
    @SerializedName("account_id")
    @Expose
    private Object accountId;
    @SerializedName("is_ad")
    @Expose
    private boolean isAd;
    @SerializedName("in_most_viral")
    @Expose
    private boolean inMostViral;
    @SerializedName("has_sound")
    @Expose
    private boolean hasSound;
    @SerializedName("tags")
    @Expose
    private List<Object> tags = null;
    @SerializedName("ad_type")
    @Expose
    private int adType;
    @SerializedName("ad_url")
    @Expose
    private String adUrl;
    @SerializedName("in_gallery")
    @Expose
    private boolean inGallery;
    @SerializedName("link")
    @Expose
    private String link;
    public final static Creator<AlbumImage> CREATOR = new Creator<AlbumImage>() {


        @SuppressWarnings({
            "unchecked"
        })
        public AlbumImage createFromParcel(Parcel in) {
            return new AlbumImage(in);
        }

        public AlbumImage[] newArray(int size) {
            return (new AlbumImage[size]);
        }

    }
    ;

    protected AlbumImage(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.title = in.readValue((Object.class.getClassLoader()));
        this.description = ((Object) in.readValue((Object.class.getClassLoader())));
        this.datetime = ((int) in.readValue((int.class.getClassLoader())));
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.animated = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.width = ((int) in.readValue((int.class.getClassLoader())));
        this.height = ((int) in.readValue((int.class.getClassLoader())));
        this.size = ((int) in.readValue((int.class.getClassLoader())));
        this.views = ((int) in.readValue((int.class.getClassLoader())));
        this.bandwidth = ((int) in.readValue((int.class.getClassLoader())));
        this.vote = ((Object) in.readValue((Object.class.getClassLoader())));
        this.favorite = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.nsfw = ((Object) in.readValue((Object.class.getClassLoader())));
        this.section = ((Object) in.readValue((Object.class.getClassLoader())));
        this.accountUrl = ((Object) in.readValue((Object.class.getClassLoader())));
        this.accountId = ((Object) in.readValue((Object.class.getClassLoader())));
        this.isAd = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.inMostViral = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.hasSound = ((boolean) in.readValue((boolean.class.getClassLoader())));
        in.readList(this.tags, (Object.class.getClassLoader()));
        this.adType = ((int) in.readValue((int.class.getClassLoader())));
        this.adUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.inGallery = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.link = ((String) in.readValue((String.class.getClassLoader())));
    }

    public AlbumImage() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getTitle() {
        return title;
    }

    public void setTitle(Object title) {
        this.title = title;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public int getDatetime() {
        return datetime;
    }

    public void setDatetime(int datetime) {
        this.datetime = datetime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isAnimated() {
        return animated;
    }

    public void setAnimated(boolean animated) {
        this.animated = animated;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(int bandwidth) {
        this.bandwidth = bandwidth;
    }

    public Object getVote() {
        return vote;
    }

    public void setVote(Object vote) {
        this.vote = vote;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public Object getNsfw() {
        return nsfw;
    }

    public void setNsfw(Object nsfw) {
        this.nsfw = nsfw;
    }

    public Object getSection() {
        return section;
    }

    public void setSection(Object section) {
        this.section = section;
    }

    public Object getAccountUrl() {
        return accountUrl;
    }

    public void setAccountUrl(Object accountUrl) {
        this.accountUrl = accountUrl;
    }

    public Object getAccountId() {
        return accountId;
    }

    public void setAccountId(Object accountId) {
        this.accountId = accountId;
    }

    public boolean isIsAd() {
        return isAd;
    }

    public void setIsAd(boolean isAd) {
        this.isAd = isAd;
    }

    public boolean isInMostViral() {
        return inMostViral;
    }

    public void setInMostViral(boolean inMostViral) {
        this.inMostViral = inMostViral;
    }

    public boolean isHasSound() {
        return hasSound;
    }

    public void setHasSound(boolean hasSound) {
        this.hasSound = hasSound;
    }

    public List<Object> getTags() {
        return tags;
    }

    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    public int getAdType() {
        return adType;
    }

    public void setAdType(int adType) {
        this.adType = adType;
    }

    public String getAdUrl() {
        return adUrl;
    }

    public void setAdUrl(String adUrl) {
        this.adUrl = adUrl;
    }

    public boolean isInGallery() {
        return inGallery;
    }

    public void setInGallery(boolean inGallery) {
        this.inGallery = inGallery;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(title);
        dest.writeValue(description);
        dest.writeValue(datetime);
        dest.writeValue(type);
        dest.writeValue(animated);
        dest.writeValue(width);
        dest.writeValue(height);
        dest.writeValue(size);
        dest.writeValue(views);
        dest.writeValue(bandwidth);
        dest.writeValue(vote);
        dest.writeValue(favorite);
        dest.writeValue(nsfw);
        dest.writeValue(section);
        dest.writeValue(accountUrl);
        dest.writeValue(accountId);
        dest.writeValue(isAd);
        dest.writeValue(inMostViral);
        dest.writeValue(hasSound);
        dest.writeList(tags);
        dest.writeValue(adType);
        dest.writeValue(adUrl);
        dest.writeValue(inGallery);
        dest.writeValue(link);
    }

    public int describeContents() {
        return  0;
    }

}
