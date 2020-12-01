package ru.trueip.hhproject11.screens.user_profile_screen;

import android.content.Context;
import android.content.Intent;
import android.database.Observable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableField;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import ru.trueip.hhproject11.pojo.Photo;
import ru.trueip.hhproject11.pojo.User;
import ru.trueip.hhproject11.screens.user_profile_screen.photo_details_activity.PhotoDetailsActivity;

import static ru.trueip.hhproject11.Constants.PHOTO_EXTRA;
import static ru.trueip.hhproject11.Constants.USER_EXTRA;

public class UserProfilePresenter {
    private static final String TAG = UserProfilePresenter.class.getSimpleName();

    private UserProfileContract contract;
    public ObservableField<String> name;
    public ObservableField<String> age;
    public ObservableField<String> city;
    public ObservableField<String> lastVisit;
    public ObservableField<String> image;
    public ObservableField<String> json;


    private void initFields() {
        name = new ObservableField<>();
        age = new ObservableField<>();
        city = new ObservableField<>();
        lastVisit = new ObservableField<>();
        image = new ObservableField<>();
        json = new ObservableField<>();
    }
    private void setFields(Bundle bundle) {
        if(bundle!=null){
            String stringOfUser =  bundle.getString(USER_EXTRA,"");
            User user = new Gson().fromJson(stringOfUser,User.class);

            name.set(user.getName());
            age.set(user.getAge());
            city.set(user.getCity());
            lastVisit.set(user.getLastVisit());
            image.set(user.getPhotos().get(0).getUrl());
            json.set(stringOfUser);

        }

    }

    public String getImageUrl() {
        return image.get();
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso.get()
                .load(imageUrl)
                .into(view);
    }

    public UserProfilePresenter(UserProfileContract contract,Bundle bundle) {
        this.contract = contract;
        initFields();
        setFields(bundle);
    }


    public void viewPhotos(View view){
        Context cx = view.getContext();
        Intent intent = new Intent(cx, PhotoDetailsActivity.class);
        intent.putExtra(PHOTO_EXTRA,json.get());
        cx.startActivity(intent);
    }

}
