package io.vinter.secondkotlintask.ui.splash

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.vinter.secondkotlintask.ui.main.MainActivity
import io.vinter.secondkotlintask.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val viewModel = ViewModelProviders.of(this).get(SplashViewModel::class.java)

        viewModel.loadData()

        viewModel.data.observe(this, Observer {
            if (it != null){
                val switchToMain = Intent(this, MainActivity::class.java)
                switchToMain.putParcelableArrayListExtra("data", it)
                startActivity(switchToMain)
                finish()
            }
        })
    }
}
