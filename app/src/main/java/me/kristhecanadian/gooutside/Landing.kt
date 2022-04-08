package me.kristhecanadian.gooutside

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.kristhecanadian.gooutside.R
import java.util.*


class Landing : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)
        Timer().schedule(object : TimerTask() {
            override fun run() {
                startActivity(Intent(this@Landing, Dashboard::class.java))
                finish()
            }
        }, 1000)
    }
}