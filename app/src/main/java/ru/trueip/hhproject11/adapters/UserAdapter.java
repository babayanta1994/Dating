package ru.trueip.hhproject11.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ru.trueip.hhproject11.R;
import ru.trueip.hhproject11.pojo.User;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private List<User> users;
    private OnReachEndListener onReachEndListener;
    private OnUserItemClickListener onUserItemClickListener;

    public void setOnReachEndListener(OnReachEndListener onReachEndListener) {
        this.onReachEndListener = onReachEndListener;
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUserByPosition(int i) {
        return users.get(i);
    }

    public void setUsers(List<User> users) {
        this.users = users;
        notifyDataSetChanged();
    }

    public void addUsers(List<User> users) {
        this.users.addAll(users);
        notifyDataSetChanged();
    }

    public void setOnUserItemClickListener(OnUserItemClickListener onUserItemClickListener) {
        this.onUserItemClickListener = onUserItemClickListener;
    }

    public interface OnUserItemClickListener{
        void onUserItemClick(int position);
    }

    public interface OnReachEndListener {
        void onReachEnd();
    }


    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.people_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        if (position == users.size()-3 && onReachEndListener != null) {
            onReachEndListener.onReachEnd();
        }
        User user = users.get(position);
        holder.tvName.setText(user.getName());
        holder.tvLastVisit.setText(user.getLastVisit());
        Picasso.get().load(user.getIurl200()).into(holder.ivPhoto);
        holder.circleIsOnline.setBackgroundResource(user.isOnline()?R.drawable.solid_circle:R.drawable.solid_circle_red);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPhoto;
        TextView tvName;
        TextView tvLastVisit;
        View circleIsOnline;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPhoto = itemView.findViewById(R.id.ivPhoto);
            tvName = itemView.findViewById(R.id.tvName);
            tvLastVisit = itemView.findViewById(R.id.tvLastVisit);
            circleIsOnline = itemView.findViewById(R.id.circleIsOnline);
            itemView.setOnClickListener((View v)->{
                if(onUserItemClickListener!=null){
                    onUserItemClickListener.onUserItemClick(getAdapterPosition());
                }
            });
        }
    }

}
