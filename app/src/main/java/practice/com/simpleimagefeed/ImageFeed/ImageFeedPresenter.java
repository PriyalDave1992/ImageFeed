package practice.com.simpleimagefeed.ImageFeed;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import practice.com.simpleimagefeed.Constants;
import practice.com.simpleimagefeed.data.model.AlbumImage;
import practice.com.simpleimagefeed.data.model.AlbumImagesResponse;
import practice.com.simpleimagefeed.data.service.ImageFeedService;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Priyal Divakala on 05/03/2018.
 */

public class ImageFeedPresenter implements ImageFeedContract.Presenter {

    private final Context context;
    private final ImageFeedService mImageFeedService;
    private final ImageFeedContract.View mView;

    public ImageFeedPresenter(Context context, @NonNull ImageFeedContract.View view) {
        this.context = context;
        mView = checkNotNull(view);
        this.mImageFeedService = new ImageFeedService();
    }

    @Override
    public void getAlbumImages(String albumId) {
        mImageFeedService
                .getAPI()
                .getAlbumImages(albumId,"Client-ID "+ Constants.CLIENT_ID).enqueue(new Callback<AlbumImagesResponse>() {
            @Override
            public void onResponse(Call<AlbumImagesResponse> call, Response<AlbumImagesResponse> response) {
                AlbumImagesResponse result = response.body();
                if(result != null && result.getData().size()>0) {
                    albumImagesReady(result.getData());

                }
                else if(result != null && result.getData().size() == 0)
                {
                    getAlbumImagesError();
                }
                else {
                    try {
                        JSONObject jObjError = new JSONObject(response.errorBody().string());
                        Toast.makeText(getContext(), jObjError.getString("message"), Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }

            }

            @Override
            public void onFailure(Call<AlbumImagesResponse> call, Throwable t) {
                getAlbumImagesError();

            }
        });

    }

    @Override
    public void albumImagesReady(List<AlbumImage> albumImages) {
        mView.showImages(albumImages);
    }

    @Override
    public void getAlbumImagesError() {
        mView.showNoImagesError();
    }

    public Context getContext()
    {
        return this.context;
    }
}
