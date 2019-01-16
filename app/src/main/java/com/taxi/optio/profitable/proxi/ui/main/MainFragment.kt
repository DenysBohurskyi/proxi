package com.taxi.optio.profitable.proxi.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import com.taxi.optio.profitable.proxi.R
import com.taxi.optio.profitable.proxi.base.BaseFragment

class MainFragment : BaseFragment() {

    override val layout: Int = R.layout.fr_main

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

}
