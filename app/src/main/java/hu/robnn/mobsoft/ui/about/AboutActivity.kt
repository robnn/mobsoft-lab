package hu.robnn.mobsoft.ui.about

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import hu.robnn.mobsoft.R
import kotlinx.android.synthetic.main.activity_main.*

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        setSupportActionBar(toolbar)
    }
}