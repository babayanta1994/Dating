package ru.trueip.hhproject11.screens.users_screen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ru.trueip.hhproject11.R;
import ru.trueip.hhproject11.adapters.UserAdapter;
import ru.trueip.hhproject11.pojo.User;

public class UsersActivity extends AppCompatActivity implements UsersContract {

    private RecyclerView recyclerViewUsers;
    private UserAdapter adapter;
    private UsersPresenter presenter;
    private static final String TAG = UsersActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new UsersPresenter(this);
        recyclerViewUsers = findViewById(R.id.recyclerView);
        adapter = new UserAdapter();
        adapter.setUsers(new ArrayList<User>());
        recyclerViewUsers.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewUsers.setAdapter(adapter);

        presenter.loadUsers();

        adapter.setOnReachEndListener(() -> {
            presenter.loadUsers();
            Log.e(TAG, " >>> Конец списка, подгрузка данных");
        });

        adapter.setOnUserItemClickListener((int position) -> {
            presenter.startUserProfileActivity(this, adapter.getUserByPosition(position));
        });
    }

    @Override
    protected void onDestroy() {
        presenter.disposeDisposable();
        super.onDestroy();
    }

    @Override
    public void showUsers(List<User> users) {
        adapter.addUsers(users);
    }

    @Override
    public void showError() {
        Toast.makeText(UsersActivity.this, R.string.error_user_response, Toast.LENGTH_SHORT).show();
    }
}