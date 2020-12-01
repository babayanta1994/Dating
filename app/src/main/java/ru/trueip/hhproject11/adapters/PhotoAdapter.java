package ru.trueip.hhproject11.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

import ru.trueip.hhproject11.pojo.Photo;
import ru.trueip.hhproject11.screens.user_profile_screen.photo_details_activity.PhotoPageFragment;

public class PhotoAdapter extends FragmentPagerAdapter {

    List<Photo> photos;

    public PhotoAdapter(@NonNull FragmentManager fm, List<Photo> photoList) {
        super(fm);
        photos = photoList;
    }

    @Override
    public int getCount() {
        return photos.size();
    }

    @Override
    public Fragment getItem(int position) {
        return (PhotoPageFragment.newInstance(photos.get(position)));
    }
}
