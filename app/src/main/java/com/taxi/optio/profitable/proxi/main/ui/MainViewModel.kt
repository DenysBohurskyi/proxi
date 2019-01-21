package com.taxi.optio.profitable.proxi.main.ui

import androidx.lifecycle.ViewModel
import com.taxi.optio.profitable.proxi.main.domain.entity.PlacesModel
import com.taxi.optio.profitable.proxi.main.domain.interactors.PriceListInteractor
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class MainViewModel: ViewModel(), KoinComponent {

    private var startPointObservable: Disposable? = null
    private val interactor by inject<PriceListInteractor>()

    fun onStartPointTextChanged(startPointSource: String): Observable<MutableList<PlacesModel>> {
        println()
        return interactor.findStartPlaces(startPointSource)
    }

}
