package net.gouline.drawablesources.model;

import net.gouline.drawablesources.R;
import net.gouline.drawablesources.util.DrawableSource;

import java.io.Serializable;

public class User implements Profile, Serializable {
    private final String name;
    private final String pictureUrl;

    public User(String name, String pictureUrl) {
        this.name = name;
        this.pictureUrl = pictureUrl;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public DrawableSource getPicture() {
        if (pictureUrl != null) {
            return new DrawableSource(pictureUrl);
        }
        return new DrawableSource(R.drawable.ic_profile);
    }
}
