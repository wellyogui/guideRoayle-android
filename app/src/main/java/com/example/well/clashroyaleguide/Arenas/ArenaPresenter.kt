package com.example.well.clashroyaleguide.Arenas

import android.util.Log
import com.example.well.clashroyaleguide.Service.model.Arena
import com.example.well.clashroyaleguide.Service.RetrofitClient
import com.example.well.clashroyaleguide.Service.sync.contracts.ArenaListListener
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
                        arenaListListener.onRequestStarted()
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