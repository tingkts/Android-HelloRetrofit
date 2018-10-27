package ting.hello.retrofit.restapi;

import android.util.Log;
import java.util.HashMap;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ting.hello.retrofit.bean.User;
import ting.hello.retrofit.bean.UserUpdated;

public class LoginApiImpl {
    private final static String TAG = LoginApiImpl.class.getName();

    public final static String USERNAME = "test2@qq.com";
    public final static String PASSWORD = "test1234qq";

    private ResultListener resultListener;
    private LoginApi requestApi;

    public LoginApiImpl(ResultListener resultListener) {
        this.resultListener = resultListener;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(LoginApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        requestApi = retrofit.create(LoginApi.class);
    }

    public void login(String username, String password) {
        Call<User> call = requestApi.getUser(username, password);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                Log.d(TAG, "login, get user: " + user);
                resultListener.onLoginResponse(user);
            }

            @Override
            public void onFailure(Call<User> call, Throwable throwable) {
                Log.e(TAG, "login, connect fail!");
                resultListener.onLoginFailure(throwable);
            }
        });
    }

    public void setTimezone(String session_token, String object_id, long timezone ) {
        HashMap<String, Integer> body = new HashMap<>();
        body.put("timezone", (int)timezone);

        Call<UserUpdated> call = requestApi.setTimezone(session_token, object_id, body);
        call.enqueue(new Callback<UserUpdated>() {
            @Override
            public void onResponse(Call<UserUpdated> call, Response<UserUpdated> response) {
                UserUpdated userUpdated = response.body();
                Log.d(TAG, "settimezone, : " + userUpdated);
                resultListener.onSetTimezoneResponse(userUpdated);
            }

            @Override
            public void onFailure(Call<UserUpdated> call, Throwable throwable) {
                Log.e(TAG, "settimezone, connect fail!");
                resultListener.onSetTimezoneFailure(throwable);
            }
        });
    }

    public interface ResultListener {
        void onLoginResponse(User user);
        void onLoginFailure(Throwable throwable);

        void onSetTimezoneResponse(UserUpdated userUpdated);
        void onSetTimezoneFailure(Throwable throwable);
    }
}