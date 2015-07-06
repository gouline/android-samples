package net.gouline.drawablesources.model;

import net.gouline.drawablesources.R;
import net.gouline.drawablesources.util.DrawableSource;

import java.io.Serializable;

public class Contact implements Profile, Serializable {
    private final String mName;

    public Contact(String name) {
        mName = name;
    }

    @Override
    public String getName() {
        return mName;
    }

    @Override
    public DrawableSource getPicture() {
        return new DrawableSource(R.drawable.ic_profile);
    }
}
