package com.taxi.optio.profitable.proxi.main.ui

import androidx.lifecycle.ViewModel
import com.taxi.optio.profitable.proxi.main.domain.interactors.PriceListInteractor
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import java.util.concurrent.TimeUnit

class MainViewModel: ViewModel(), KoinComponent {

    private var startPointObservable: Disposable? = null
    private val interactor by inject<PriceListInteractor>()

    fun onStartPointTextChanged(startPointSource: String) {

        startPointObservable = Observable.just(startPointSource)
            .debounce(1000, TimeUnit.MILLISECONDS)
            .distinctUntilChanged()
            .filter { startPointSource.isNotBlank() }
            .flatMap { interactor.findStartPlaces(it) }
            .subscribe {
                    it -> println("test " + it)
            }

    }

}
