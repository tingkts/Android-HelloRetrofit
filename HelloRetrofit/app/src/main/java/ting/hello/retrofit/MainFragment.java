package ting.hello.retrofit;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import ting.hello.retrofit.bean.User;
import ting.hello.retrofit.bean.UserUpdated;
import ting.hello.retrofit.restapi.LoginApiImpl;

public class MainFragment extends Fragment {
    private Button btnLogIn;
    private Button btnChangeUserDataOfTimezone;
    private TextView textUserData;

    private LoginApiImpl loginApi;
    private User loginUser;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.main_fragment, container, false);

        btnLogIn = root.findViewById(R.id.buttonLogIn);
        btnChangeUserDataOfTimezone = root.findViewById(R.id.buttonChangeUserDataOfTimezone);
        textUserData = root.findViewById(R.id.textUserData);

        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setEnabled(false);
                textUserData.setText(R.string.wait_for_user_data);
                loginApi.login(LoginApiImpl.USERNAME, LoginApiImpl.PASSWORD);
            }
        });
        btnChangeUserDataOfTimezone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setEnabled(false);
                loginUser.setTimezone(8L);
                loginApi.setTimezone(loginUser.getSessionToken(), loginUser.getObjectId(),
                        loginUser.getTimezone());
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        loginApi = new LoginApiImpl(new LoginApiImpl.ResultListener(){
            @Override
            public void onLoginResponse(User user) {
                loginUser = user;
                textUserData.setText(user.toString());
                btnChangeUserDataOfTimezone.setEnabled(true);
            }

            @Override
            public void onLoginFailure(Throwable throwable) {
                textUserData.setText(throwable.toString());
            }

            @Override
            public void onSetTimezoneResponse(UserUpdated userUpdated) {
                textUserData.setText(userUpdated.toString());
            }

            @Override
            public void onSetTimezoneFailure(Throwable throwable) {
                textUserData.setText(throwable.toString());
            }
        });
    }
}