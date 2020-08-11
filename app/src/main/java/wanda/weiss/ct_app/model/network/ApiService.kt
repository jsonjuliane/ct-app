package wanda.weiss.ct_app.model.network

import io.reactivex.Maybe
import retrofit2.http.GET
import wanda.weiss.ct_app.model.pojo.Users

interface ApiService {

    @GET("/users")
    fun getUsers(): Maybe<ArrayList<Users>>

}