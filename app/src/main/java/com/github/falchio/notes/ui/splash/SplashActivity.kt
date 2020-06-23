package com.github.falchio.notes.ui.splash

import androidx.lifecycle.ViewModelProviders
import com.github.falchio.notes.ui.base.BaseActivity
import com.github.falchio.notes.ui.main.MainActivity


class SplashActivity : BaseActivity<Boolean?, SplashViewState>() {
    override val viewModel: SplashViewModel by lazy{
        ViewModelProviders.of(this).get(SplashViewModel::class.java)
    }

    override val layoutRes = null

    override fun onResume() {
        super.onResume()
        viewModel.requestUser()
    }



    override fun renderData(data: Boolean?) {
        data?.takeIf { it }?.let {
            startMainActivity()
        }
    }

    private fun startMainActivity(){
        MainActivity.start(this)
        finish()
    }
}
