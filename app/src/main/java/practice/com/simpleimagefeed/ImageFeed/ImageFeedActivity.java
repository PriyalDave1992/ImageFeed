package practice.com.simpleimagefeed.ImageFeed;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import practice.com.simpleimagefeed.BaseActivity;
import practice.com.simpleimagefeed.Constants;
import practice.com.simpleimagefeed.ImageFeedDetails.ImageFeedDetailsActivity;
import practice.com.simpleimagefeed.R;
import practice.com.simpleimagefeed.data.model.AlbumImage;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Priyal Divakala on 02/03/2018.
 */

public class ImageFeedActivity extends BaseActivity implements
        ImageFeedAdapter.OnFeedItemClickListener, ImageFeedContract.View {

    @BindView(R.id.rvImageFeed)
    RecyclerView rvImageFeed;
    @BindView(R.id.btnCreate)
    FloatingActionButton fab;
    @BindView(R.id.content)
    CoordinatorLayout clContent;

    private ImageFeedContract.Presenter mPresenter;
    private List<AlbumImage> mAlbumImages;
    private ImageFeedAdapter imageFeedAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter = new ImageFeedPresenter(this,this);

        if (savedInstanceState != null && imageFeedAdapter!=null) {
            imageFeedAdapter.addItems((ArrayList) mAlbumImages);
        }
        else {
            getAllAlbumImages();
        }
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "This is the Image Feed", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }
    private void getAllAlbumImages() {
        mPresenter.getAlbumImages(Constants.ALBUM_HASH);
    }

    @Override
    protected void bindViews() {
        super.bindViews();
        ButterKnife.bind(this);
    }

    private void setupFeed(List<AlbumImage> albumImages) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this) {
            @Override
            protected int getExtraLayoutSpace(RecyclerView.State state) {
                return 300;
            }
        };
        rvImageFeed.setLayoutManager(linearLayoutManager);
        imageFeedAdapter = new ImageFeedAdapter(this, albumImages);
        imageFeedAdapter.setOnFeedItemClickListener(this);
        rvImageFeed.setAdapter(imageFeedAdapter);
    }

    @Override
    public void onImageClick(View v, int position) {
        Intent intent = new Intent(this, ImageFeedDetailsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("key_album_image",mAlbumImages.get(position));
        startActivity(intent);
    }

    @Override
    public void showNoImagesError() {
        Toast.makeText(this,"There were no images in the Album",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showImages(List<AlbumImage> albumImages) {
        mAlbumImages = checkNotNull(albumImages);
        setupFeed(mAlbumImages);
    }

}
