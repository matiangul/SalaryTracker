package pl.angulski.salarytracker.app.settings

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import pl.angulski.salarytracker.app.R

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        title = getString(R.string.settings_menu_title)
    }
}
