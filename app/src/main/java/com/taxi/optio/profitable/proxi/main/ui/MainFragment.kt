package com.taxi.optio.profitable.proxi.main.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.Handler
import android.widget.ArrayAdapter
import androidx.appcompat.widget.AppCompatAutoCompleteTextView
import br.com.simplepass.loadingbutton.customViews.CircularProgressImageButton
import com.jakewharton.rxbinding2.widget.RxTextView
import com.taxi.optio.profitable.proxi.R
import com.taxi.optio.profitable.proxi.base.BaseFragment
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class MainFragment : BaseFragment() {

    override val layout: Int = R.layout.fr_main
    private var btnFind: CircularProgressImageButton? = null

    private var startPointAdapter: ArrayAdapter<String>? = null
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
        startPoint?.let {
            RxTextView.textChanges(it)
                .debounce(300, TimeUnit.MILLISECONDS)
                .map { charSequence -> charSequence.toString() }
                .distinctUntilChanged()
                .filter { source -> source.isNotBlank() }
                .flatMap { source -> viewModel.onStartPointTextChanged(source) }
                .flatMap { result ->
                    Observable.fromIterable(result)
                        .map { item -> item.title }
                        .toList()
                        .toObservable()
                }
                .subscribe { result ->
                    setStartPointAdapter(result)
                }
        }

        btnFind = view?.findViewById(R.id.btnFind)
        btnFind?.setOnClickListener {
            btnFind?.startAnimation()
            Handler().postDelayed({
                btnFind?.revertAnimation()
            }, 4000)
        }
    }

    private fun setStartPointAdapter(startPointArray: MutableList<String?>) {
        startPointAdapter?.clear()
        if (startPointArray.size < 10) startPoint?.threshold = 2
        else startPoint?.threshold = 2

        context?.let {
            startPointAdapter?.setNotifyOnChange(true)
            if (startPointAdapter != null) {
                startPointAdapter?.addAll(startPointArray)
            } else {
                startPointAdapter = ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, startPointArray)
                startPoint?.setAdapter(startPointAdapter)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        btnFind?.dispose()
    }

}
