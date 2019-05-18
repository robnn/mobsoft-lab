package hu.robnn.mobsoft.ui.create

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import hu.robnn.mobsoft.R
import kotlinx.android.synthetic.main.activity_create.*
import kotlinx.android.synthetic.main.activity_main.*

class CreateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)
        setSupportActionBar(toolbar_create)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_create, CreateFragment.newInstance()).commit()
    }

}
