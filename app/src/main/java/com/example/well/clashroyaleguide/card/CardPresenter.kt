package com.example.well.clashroyaleguide.card

import android.util.Log
import com.example.well.clashroyaleguide.service.model.Cards
import com.example.well.clashroyaleguide.service.RetrofitClient
import com.example.well.clashroyaleguide.service.sync.contracts.CardListListener
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by wellingtonyogui on 12/06/2018 for guideRoayle-android.
 */
class CardPresenter {

    private var retrofitClient: RetrofitClient = RetrofitClient()

    fun getAllCards(cardsListListener: CardListListener){

        retrofitClient.getClashApi().getAllCards().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<MutableList<Cards>>{
                    override fun onSubscribe(d: Disposable) {
                        cardsListListener.onRequestStarted()
                    }

                    override fun onComplete() {
                        cardsListListener.onRequestFinished()
                    }

                    override fun onNext(t: MutableList<Cards>) {
                        val cardList = t
                        cardsListListener.onCardListLoad(cardList)
                    }

                    override fun onError(e: Throwable) {
                        cardsListListener.onRequestFinished()
                        cardsListListener.onError(e)
                        Log.e("getAllCards:", e.message)
                    }

                })
    }
}