package pl.angulski.salarytracker.ui

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import pl.angulski.salarytracker.R

class MainActivity : AppCompatActivity(), SalaryView {

    //move to dagger
    val salaryController: SalaryController = SalaryController()
    val salaryPresenter: SalaryPresenter = SalaryPresenter(this)

    //view binder thing from tropos
    override var viewState: SalaryViewState = SalaryViewState.EmptySalaryViewState

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }
}
