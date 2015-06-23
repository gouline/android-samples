package net.gouline.jacoco.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import net.gouline.jacoco.R;
import net.gouline.jacoco.util.UsefulUtils;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Main entry activity.
 * <p/>
 * Created by mgouline on 24/05/15.
 */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @InjectView(R.id.txt_status)
    TextView mStatusTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        // Display the result to ensure it works
        mStatusTextView.setText(String.valueOf(UsefulUtils.sum(1, 2, 3, 4, 5)));
    }
}
