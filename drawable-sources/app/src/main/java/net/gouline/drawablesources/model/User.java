package net.gouline.drawablesources.model;

import net.gouline.drawablesources.R;
import net.gouline.drawablesources.util.DrawableSource;

import java.io.Serializable;

public class User implements Profile, Serializable {
    private final String mName;
    private final String mPictureUrl;

    public User(String name, String pictureUrl) {
        mName = name;
        mPictureUrl = pictureUrl;
    }

    @Override
    public String getName() {
        return mName;
    }

    @Override
    public DrawableSource getPicture() {
        if (mPictureUrl != null) {
            return new DrawableSource(mPictureUrl);
        }
        return new DrawableSource(R.drawable.ic_profile);
    }
}
