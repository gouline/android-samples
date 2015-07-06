package net.gouline.drawablesources.util;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class DrawableSource {
    private String mUrl;
    private int mResId;

    public DrawableSource(String url) {
        mUrl = url;
    }

    public DrawableSource(int resId) {
        mResId = resId;
    }

    public void applyTo(Context context, ImageView imageView) {
        if (mUrl != null) {
            Picasso.with(context).load(mUrl).into(imageView);
        } else if (mResId != 0) {
            imageView.setImageResource(mResId);
        } else {
            imageView.setImageBitmap(null);
        }
    }
}
