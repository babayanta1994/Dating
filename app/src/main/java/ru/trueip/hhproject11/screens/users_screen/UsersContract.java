package ru.trueip.hhproject11.screens.users_screen;

import java.util.List;

import ru.trueip.hhproject11.pojo.User;

public interface UsersContract {
    void showUsers(List<User> users);
    void showError();
}
