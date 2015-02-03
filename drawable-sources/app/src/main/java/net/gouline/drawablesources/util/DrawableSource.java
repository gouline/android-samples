package net.gouline.drawablesources.util;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class DrawableSource {
    private String url;
    private int resId;

    public DrawableSource(String url) {
        this.url = url;
    }

    public DrawableSource(int resId) {
        this.resId = resId;
    }

    public void applyTo(Context context, ImageView imageView) {
        if (url != null) {
            Picasso.with(context).load(url).into(imageView);
        } else if (resId != 0) {
            imageView.setImageResource(resId);
        }
    }
}
