package net.gouline.kotlindemo.app;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Activity with automatic injection on content view set.
 *
 * @author Mike Gouline
 */
public class InjectionActivity extends Activity {
    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        performInjection();
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        performInjection();
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        performInjection();
    }

    private void performInjection() {
        ButterKnife.inject(this);
    }
}
