package io.vinter.secondkotlintask.network.service

import io.reactivex.Observable
import io.reactivex.Single
import io.vinter.secondkotlintask.entity.Technology
import retrofit2.http.GET

interface DataService {
    @GET("src/data/techs.ruleset.json")
    fun getData(): Observable<ArrayList<Technology>>
}