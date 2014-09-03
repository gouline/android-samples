package net.gouline.kotlindemo.app

import android.app.Activity
import android.widget.Button
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.content.Intent
import net.gouline.kotlindemo.R
import android.widget.Toast
import android.widget.TextView
import butterknife.InjectView

/**
 * Welcome activity.
 *
 * @author Mike Gouline
 */
open class MainActivity() : Activity() {
    private var scanWifiButton: Button? = null

    // Injected status text view.
    InjectView(R.id.txt_status) var statusTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super<Activity>.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        scanWifiButton = findViewById(R.id.btn_scan_wifi) as Button?
        scanWifiButton?.setOnClickListener({ v ->
            startActivity(Intent(this, javaClass<WifiActivity>()))
            finish()
        })

        // Setting status text view if not null.
        statusTextView?.setText("Test status")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.getItemId()
        if (id == R.id.action_settings) {
            Toast.makeText(this, R.string.prompt_settings_not_implemented, Toast.LENGTH_SHORT).show();
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
