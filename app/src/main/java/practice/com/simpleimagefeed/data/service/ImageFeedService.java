package practice.com.simpleimagefeed.data.service;

import practice.com.simpleimagefeed.Constants;
import practice.com.simpleimagefeed.data.model.AlbumImagesResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

/**
 * Created by Priyal Divakala on 05/03/2018.
 */

public class ImageFeedService {

    public interface  ImageFeedAPI{
        //@Headers({"Authorization: Client-ID e0d9382b96f900b"})
        @GET("album/{albumId}/images")
        Call<AlbumImagesResponse> getAlbumImages(@Path("albumId") String albumId, @Header("Authorization") String clientId);
    }

    public ImageFeedAPI getAPI(){
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ImageFeedAPI.class);
    }
}
