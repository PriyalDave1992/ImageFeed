package practice.com.simpleimagefeed.ImageFeed;

import practice.com.simpleimagefeed.data.model.AlbumImage;

import java.util.List;

/**
 * Created by Priyal Divakala on 05/03/2018.
 */

public interface ImageFeedContract {

    interface View  {
        void showNoImagesError();
        void showImages(List<AlbumImage> albumImages);
    }

    interface Presenter {
        void getAlbumImages(String albumId);
        void albumImagesReady(List<AlbumImage> albumImages);
        void getAlbumImagesError();
    }
}
