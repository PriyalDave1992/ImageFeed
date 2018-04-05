package practice.com.simpleimagefeed;

import android.annotation.SuppressLint;
import practice.com.simpleimagefeed.R;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Priyal Divakala on 02/03/2018.
 */

@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {

    @Nullable
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        bindViews();
    }

    protected void bindViews() {
        ButterKnife.bind(this);
        setupToolbar();
    }

    private void setupToolbar() {
        if (toolbar != null) {
            setSupportActionBar(toolbar);

            if(getSupportActionBar()!=null)
                getSupportActionBar().setDisplayShowTitleEnabled(false);

        }
    }

}
