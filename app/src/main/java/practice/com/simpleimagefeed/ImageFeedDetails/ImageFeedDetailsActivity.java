package practice.com.simpleimagefeed.ImageFeedDetails;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import practice.com.simpleimagefeed.R;
import practice.com.simpleimagefeed.data.model.AlbumImage;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.google.common.base.Preconditions.checkNotNull;

public class ImageFeedDetailsActivity extends AppCompatActivity {

    @BindView(R.id.ivFeedCenter)
    ImageView ivFeedCenter;
    @BindView(R.id.tv_image_desc)
    TextView tvImageDesc;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_feed_details);
        bindViews();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setViewsContent();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "This is the Image Description", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        checkNotNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    private void bindViews() {
        ButterKnife.bind(this);
    }
    private void setViewsContent() {
        Intent intent = getIntent();
        AlbumImage albumImage = null;
        if(intent.getExtras()!=null) {
            albumImage = intent.getExtras().getParcelable("key_album_image");
        }
        if (albumImage != null) {
            Glide.with(ivFeedCenter.getContext())
                    .load(albumImage.getLink())
                    .into(ivFeedCenter);
            tvImageDesc.setText(albumImage.getDescription()!=null?albumImage.getDescription().toString():"");
            if(albumImage.getTitle()!=null)
            {
                collapsingToolbar.setTitleEnabled(true);
                collapsingToolbar.setTitle(albumImage.getTitle().toString());
            }
            else
            {
                collapsingToolbar.setTitleEnabled(false);
            }
        }
    }
}
