package net.gouline.drawablesources.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import net.gouline.drawablesources.R;
import net.gouline.drawablesources.model.Profile;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ProfileView extends FrameLayout {
    @Bind(R.id.img_picture)
    ImageView mPictureImageView;
    @Bind(R.id.txt_name)
    TextView mNameTextView;
    @Bind(R.id.txt_type)
    TextView mTypeTextView;

    public ProfileView(Context context) {
        this(context, null);
    }

    public ProfileView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ProfileView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        ButterKnife.bind(this, LayoutInflater.from(context).inflate(R.layout.view_profile, this));
    }

    public void update(Profile profile) {
        profile.getPicture().applyTo(getContext(), mPictureImageView);
        mNameTextView.setText(profile.getName());
        mTypeTextView.setText(profile.getClass().getSimpleName());
    }
}
