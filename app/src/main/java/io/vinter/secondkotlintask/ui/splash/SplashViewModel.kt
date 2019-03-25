package io.vinter.secondkotlintask.ui.splash

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.vinter.secondkotlintask.entity.Technology
import io.vinter.secondkotlintask.network.NetModule
import io.vinter.secondkotlintask.network.service.DataService
import java.util.*

class SplashViewModel : ViewModel(){
    var data = MutableLiveData<ArrayList<Technology>>()

    fun loadData(){
        val technologies= ArrayList<Technology>()
        NetModule.retrofit.create(DataService::class.java)
                .getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMapIterable { it }
                .doOnComplete { data.postValue(technologies) }
                .subscribe({technology -> if (technology.name != null) technologies.add(technology)},
                        { e ->
                    Log.e("Network", e.message)
                })
    }
}