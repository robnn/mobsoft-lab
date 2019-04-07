package hu.robnn.mobsoft.ui.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import hu.robnn.mobsoft.R
import hu.robnn.mobsoft.ui.create.CreateActivity
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

}
