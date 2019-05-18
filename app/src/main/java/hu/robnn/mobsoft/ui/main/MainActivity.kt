package hu.robnn.mobsoft.ui.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import hu.robnn.mobsoft.R
import hu.robnn.mobsoft.ui.about.AboutActivity
import hu.robnn.mobsoft.ui.create.CreateActivity
import kotlinx.android.synthetic.main.activity_about.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportFragmentManager.beginTransaction().replace(R.id.fragment, TodosFragment.newInstance()).commit()

        fab.setOnClickListener {
            run {
                val intent = Intent(this, CreateActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.about_button -> openAboutActivity()
        }
        return true
    }

    private fun openAboutActivity() {
        val intent = Intent(this, AboutActivity::class.java)
        startActivity(intent)
    }
}
