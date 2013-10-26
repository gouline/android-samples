package org.gouline.android.gradle;

import org.apache.commons.lang3.StringUtils;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

/**
 * Sample main activity.
 *
 * @author Mike Gouline
 *
 */
public class MainActivity extends Activity {

  private TextView mTextViewEnvironment;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    String environmentShort = StringUtils.abbreviate(EnvironmentConfig.ENVIRONMENT, 3);

    mTextViewEnvironment = (TextView) findViewById(R.id.textViewEnvironment);
    mTextViewEnvironment.setText(environmentShort);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }
}
