package ru.trueip.hhproject11.screens.users_screen;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import ru.trueip.hhproject11.api.ApiFactory;
import ru.trueip.hhproject11.pojo.User;
import ru.trueip.hhproject11.pojo.UserResponse;
import ru.trueip.hhproject11.screens.user_profile_screen.UserProfileActivity;

import static ru.trueip.hhproject11.Constants.USER_EXTRA;

public class UsersPresenter {
    private static final String TAG = UsersPresenter.class.getSimpleName();
    private CompositeDisposable compositeDisposable;
    private int pageNum = 1;
    private UsersContract contract;

    public UsersPresenter(UsersContract contract) {
        this.contract = contract;
        compositeDisposable = new CompositeDisposable();
    }

    public void loadUsers() {
        Disposable disposable = ApiFactory.getInstance().getApiService().getUsers(pageNum)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((UserResponse userResponse) -> {
                    contract.showUsers(userResponse.getUsers());
                    pageNum++;
                }, (throwable -> {
                    contract.showError();
                    Log.e(TAG, ">>> loadUsers " + throwable.getMessage());
                }));
        compositeDisposable.add(disposable);
    }


    public void startUserProfileActivity(Context context, User user) {
        Intent intent = new Intent(context, UserProfileActivity.class);
        intent.putExtra(USER_EXTRA, new Gson().toJson(user));
        context.startActivity(intent);
    }

    public void disposeDisposable() {
        if (compositeDisposable != null) {
            compositeDisposable.dispose();
        }
    }

}
