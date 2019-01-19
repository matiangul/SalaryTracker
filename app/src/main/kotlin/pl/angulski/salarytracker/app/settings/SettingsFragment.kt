package pl.angulski.salarytracker.app.settings

import android.os.Bundle
import android.support.v7.preference.PreferenceFragmentCompat
import pl.angulski.salarytracker.app.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)
    }

    companion object {
        fun newInstance(): SettingsFragment {
            return SettingsFragment()
        }
    }
}
