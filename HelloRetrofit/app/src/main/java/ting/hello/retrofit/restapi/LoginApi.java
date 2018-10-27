package ting.hello.retrofit.restapi;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import ting.hello.retrofit.bean.User;
import ting.hello.retrofit.bean.UserUpdated;

public interface LoginApi {

    String BASE_URL="https://watch-master-staging.herokuapp.com/";

    @Headers({
            "X-Parse-Application-Id: vqYuKPOkLQLYHhk4QTGsGKFwATT4mBIGREI2m8eD",
            "X-Parse-REST-API-Key: "
    })
    @GET("api/login")
    Call<User> getUser(@Query("username") String username, @Query("password") String password);


    @Headers({
            "X-Parse-Application-Id: vqYuKPOkLQLYHhk4QTGsGKFwATT4mBIGREI2m8eD",
            "X-Parse-REST-API-Key: ",
            "Content-Type: application/json"
    })
    @PUT("api/users/{object_id}")
    Call<UserUpdated> setTimezone(@Header("X-Parse-Session-Token") String session_token,
            @Path("object_id") String object_id, @Body HashMap<String, Integer> body);
}