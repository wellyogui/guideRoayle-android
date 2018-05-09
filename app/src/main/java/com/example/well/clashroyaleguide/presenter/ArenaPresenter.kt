package com.example.well.clashroyaleguide.presenter

import android.util.Log
import com.example.well.clashroyaleguide.model.Arena
import com.example.well.clashroyaleguide.sync.RetrofitClient
import com.example.well.clashroyaleguide.sync.contracts.ArenaListListener
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class ArenaPresenter {

    private var retrofitClient: RetrofitClient = RetrofitClient()

    fun loadArenaList(arenaListListener: ArenaListListener) {
        arenaListListener.onRequestStarted()

        retrofitClient.getClashApi().getAllArenas().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<MutableList<Arena>> {
                    override fun onComplete() {
                        arenaListListener.onRequestFinished()
                    }

                    override fun onSubscribe(d: Disposable) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onNext(t: MutableList<Arena>) {
                        val arenaList = t
                        arenaListListener.onArenaListLoad(arenaList)
                    }

                    override fun onError(e: Throwable) {
                        arenaListListener.onRequestFinished()
                        arenaListListener.onError(e)
                        Log.e("getAllArenas: %s", e.message)
                    }

                })
    }
}