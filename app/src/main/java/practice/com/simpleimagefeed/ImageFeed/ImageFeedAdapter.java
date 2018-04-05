package practice.com.simpleimagefeed.ImageFeed;

import practice.com.simpleimagefeed.data.model.AlbumImage;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import practice.com.simpleimagefeed.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Priyal Divakala on 02/03/2018.
 */

public class ImageFeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<AlbumImage> mAlbumImages = new ArrayList<>();
    private OnFeedItemClickListener onFeedItemClickListener;

    ImageFeedAdapter(Context context, List<AlbumImage> albumImages) {
        this.context = context;
        mAlbumImages = albumImages;
    }

    void setOnFeedItemClickListener(OnFeedItemClickListener onFeedItemClickListener) {
        this.onFeedItemClickListener = onFeedItemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.image_feed, parent, false);
        CellFeedViewHolder cellFeedViewHolder = new CellFeedViewHolder(view);
        setupImageFeedOnClick(view,cellFeedViewHolder);
        return cellFeedViewHolder;
    }
    private void setupImageFeedOnClick(final View view, final CellFeedViewHolder cellFeedViewHolder) {
        cellFeedViewHolder.vImageRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onFeedItemClickListener.onImageClick(view,cellFeedViewHolder.getAdapterPosition());
                if (context instanceof ImageFeedActivity) {
                    ((ImageFeedActivity) context).onImageClick(view,cellFeedViewHolder.getAdapterPosition());
                }
            }
        });
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((CellFeedViewHolder) holder).bindView(mAlbumImages.get(position));
    }

    public void addItems(ArrayList albumImages) {
        this.mAlbumImages.addAll(albumImages);
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return mAlbumImages.size();
    }
    static class CellFeedViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ivFeedCenter)
        ImageView ivFeedCenter;
        @BindView(R.id.vImageRoot)
        FrameLayout vImageRoot;
        @BindView(R.id.tvCaption)
        TextView tvCaption;

        CellFeedViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        void bindView(AlbumImage albumImage) {
            Glide.with(ivFeedCenter.getContext())
                    .load(albumImage.getLink())
                    .into(ivFeedCenter);
            tvCaption.setText(albumImage.getTitle()!= null ? albumImage.getTitle().toString() : "");
        }

    }

    public interface OnFeedItemClickListener {
        void onImageClick(View v, int position);
    }
}
