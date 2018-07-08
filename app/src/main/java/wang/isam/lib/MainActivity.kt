package wang.isam.lib

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import wang.isam.libaray.kotlin.ext.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toast("use library")
        toast(R.string.app_name)
    }
}
