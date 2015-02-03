package net.gouline.drawablesources.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import net.gouline.drawablesources.R;
import net.gouline.drawablesources.model.Profile;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ProfileView extends FrameLayout {
    @InjectView(R.id.img_picture)
    ImageView pictureImageView;
    @InjectView(R.id.txt_name)
    TextView nameTextView;
    @InjectView(R.id.txt_type)
    TextView typeTextView;

    public ProfileView(Context context) {
        this(context, null);
    }

    public ProfileView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ProfileView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        ButterKnife.inject(this, LayoutInflater.from(context).inflate(R.layout.view_profile, this));
    }

    public void update(Profile profile) {
        profile.getPicture().applyTo(getContext(), pictureImageView);
        nameTextView.setText(profile.getName());
        typeTextView.setText(profile.getClass().getSimpleName());
    }
}
