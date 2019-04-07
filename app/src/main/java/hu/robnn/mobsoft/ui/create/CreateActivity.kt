package hu.robnn.mobsoft.ui.create

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import hu.robnn.mobsoft.R
import kotlinx.android.synthetic.main.activity_main.*

class CreateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportFragmentManager.beginTransaction().replace(R.id.fragment, CreateFragment.newInstance()).commit()
    }

}
