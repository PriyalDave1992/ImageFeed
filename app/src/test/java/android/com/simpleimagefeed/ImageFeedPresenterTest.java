package android.com.simpleimagefeed;

import practice.com.simpleimagefeed.ImageFeed.ImageFeedContract;
import practice.com.simpleimagefeed.ImageFeed.ImageFeedPresenter;
import android.content.Context;

import practice.com.simpleimagefeed.data.model.AlbumImage;
import practice.com.simpleimagefeed.data.service.ImageFeedService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.Mockito.verify;

/**
 * Created by Priyal Divakala on 05/03/2018.
 */

@RunWith(MockitoJUnitRunner.class)
public class ImageFeedPresenterTest {

    @Mock
    ImageFeedService mImageFeedService;
    @Mock
    ImageFeedContract.View view;
    @Mock
    Context mContext;

    private ImageFeedPresenter mImageFeedPresenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mImageFeedPresenter = new ImageFeedPresenter(mContext,view);
    }

    @Test
    public void testAlbumsReady()
    {
        mImageFeedPresenter.albumImagesReady(new ArrayList<AlbumImage>());
        verify(view).showImages(new ArrayList<AlbumImage>());
    }
    @Test
    public void testGetAlbumImagesError()
    {
        mImageFeedPresenter.getAlbumImagesError();
        verify(view).showNoImagesError();
    }

}
