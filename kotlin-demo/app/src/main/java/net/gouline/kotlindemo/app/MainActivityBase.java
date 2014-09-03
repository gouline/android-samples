package net.gouline.kotlindemo.app;

import android.widget.TextView;

import net.gouline.kotlindemo.R;

import butterknife.InjectView;

/**
 * Base activity for {@link net.gouline.kotlindemo.app.MainActivity} as a workaround for injections.
 *
 * @author Mike Gouline
 */
public class MainActivityBase extends InjectionActivity {
    @InjectView(R.id.txt_status)
    TextView statusTextView;
}
