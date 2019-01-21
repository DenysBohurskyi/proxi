package com.taxi.optio.profitable.proxi.main.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.widget.AppCompatAutoCompleteTextView
import br.com.simplepass.loadingbutton.customViews.CircularProgressImageButton
import com.taxi.optio.profitable.proxi.R
import com.taxi.optio.profitable.proxi.base.BaseFragment
import com.taxi.optio.profitable.proxi.utils.extentions.onTextChanged
import io.reactivex.Observable

class MainFragment : BaseFragment(){

    override val layout: Int = R.layout.fr_main
    private var btnFind: CircularProgressImageButton? = null

    private var startPoint: AppCompatAutoCompleteTextView? = null
    private var endPoint: AppCompatAutoCompleteTextView? = null

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        startPoint = view?.findViewById(R.id.startPoint)
        startPoint?.onTextChanged { viewModel.onStartPointTextChanged(it) }

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
