package ru.trueip.hhproject11.api;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.trueip.hhproject11.pojo.UserResponse;

public interface ApiService {
    @GET("ByLiked")
    Observable<UserResponse> getUsers(@Query("page") int page);


}
