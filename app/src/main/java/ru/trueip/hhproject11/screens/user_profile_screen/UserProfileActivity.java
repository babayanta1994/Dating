package ru.trueip.hhproject11.screens.user_profile_screen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import ru.trueip.hhproject11.R;
import ru.trueip.hhproject11.databinding.ActivityUserProfileBinding;
import ru.trueip.hhproject11.pojo.User;
import ru.trueip.hhproject11.screens.users_screen.UsersActivity;
import ru.trueip.hhproject11.screens.users_screen.UsersContract;

import static ru.trueip.hhproject11.Constants.USER_EXTRA;

public class UserProfileActivity extends AppCompatActivity implements UserProfileContract {
    private static final String TAG = UserProfileActivity.class.getSimpleName();

    private ActivityUserProfileBinding binding;
    private UserProfilePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_profile);
        presenter = new UserProfilePresenter(this,getIntent().getExtras());
        binding.setPresenter(presenter);

    }
}