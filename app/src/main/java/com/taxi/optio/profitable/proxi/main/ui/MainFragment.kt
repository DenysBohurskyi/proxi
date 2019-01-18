package com.taxi.optio.profitable.proxi.main.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.Handler
import br.com.simplepass.loadingbutton.customViews.CircularProgressImageButton
import com.taxi.optio.profitable.proxi.R
import com.taxi.optio.profitable.proxi.base.BaseFragment

class MainFragment : BaseFragment(){

    override val layout: Int = R.layout.fr_main
    private var btnFind: CircularProgressImageButton? = null

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
//    val viewModel1: MainViewModel by viewModel()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        btnFind = view?.findViewById(R.id.btnFind)

        btnFind?.setOnClickListener {
            btnFind?.startAnimation()
            Handler().postDelayed({
                btnFind?.revertAnimation()
            }, 4000)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        btnFind?.dispose()
    }

}
