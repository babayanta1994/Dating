package ru.trueip.hhproject11.screens.user_profile_screen.photo_details_activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;

import ru.trueip.hhproject11.R;
import ru.trueip.hhproject11.pojo.Photo;

import static ru.trueip.hhproject11.Constants.PHOTO_PATH;

public class PhotoPageFragment extends Fragment {

    private String photoPath;

    public static PhotoPageFragment newInstance(Photo page) {
        PhotoPageFragment fragment = new PhotoPageFragment();
        Bundle args=new Bundle();
        args.putString(PHOTO_PATH, page.getUrl());
        fragment.setArguments(args);
        return fragment;
    }

    public PhotoPageFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        photoPath = getArguments() != null ? getArguments().getString(PHOTO_PATH) : "";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result=inflater.inflate(R.layout.fragment_photo_page, container, false);
        ImageView imageView=(ImageView)result.findViewById(R.id.ivPhotoDetail);
        Picasso.get()
                .load(photoPath)
                .into(imageView);

        return result;
    }
}