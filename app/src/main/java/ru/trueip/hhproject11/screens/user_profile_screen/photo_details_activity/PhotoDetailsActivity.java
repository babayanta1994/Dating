package ru.trueip.hhproject11.screens.user_profile_screen.photo_details_activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import ru.trueip.hhproject11.R;
import ru.trueip.hhproject11.adapters.PhotoAdapter;
import ru.trueip.hhproject11.pojo.Photo;
import ru.trueip.hhproject11.pojo.User;

import static ru.trueip.hhproject11.Constants.PHOTO_EXTRA;
import static ru.trueip.hhproject11.Constants.USER_EXTRA;

public class PhotoDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_details);
        ViewPager pager=(ViewPager)findViewById(R.id.pager);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            String stringOfUser =  bundle.getString(PHOTO_EXTRA,"");
            User user = new Gson().fromJson(stringOfUser, User.class);
            ArrayList<Photo> photos = new ArrayList<>();
            photos.addAll(user.getPhotos());
            pager.setAdapter(new PhotoAdapter(getSupportFragmentManager(),photos));
        }
    }
}