package com.taxi.optio.profitable.proxi.main.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.Handler
import android.widget.EditText
import androidx.appcompat.widget.AppCompatAutoCompleteTextView
import androidx.appcompat.widget.AppCompatEditText
import br.com.simplepass.loadingbutton.customViews.CircularProgressImageButton
import com.jakewharton.rxbinding2.widget.RxTextView
import com.jakewharton.rxbinding2.widget.textChanges
import com.taxi.optio.profitable.proxi.R
import com.taxi.optio.profitable.proxi.base.BaseFragment
import com.taxi.optio.profitable.proxi.utils.extentions.onTextChanged
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class MainFragment : BaseFragment() {

    override val layout: Int = R.layout.fr_main
    private var btnFind: CircularProgressImageButton? = null

    private var startPoint: AppCompatEditText? = null
    private var endPoint: AppCompatEditText? = null

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        startPoint = view?.findViewById(R.id.startPoint)

        startPoint!!.textChanges()
            .debounce(300, TimeUnit.MILLISECONDS)
            .distinctUntilChanged()
            .filter { source -> source.toString().isNotBlank() }
            .flatMap { source -> viewModel.onStartPointTextChanged(source.toString()) }
            .subscribe({ result -> println("test " + result) })


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
