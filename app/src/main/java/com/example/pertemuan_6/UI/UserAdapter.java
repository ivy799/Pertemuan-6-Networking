package com.example.pertemuan_6.UI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pertemuan_6.data.response.User;
import com.example.pertemuan_6.databinding.ItemuserBinding;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private final List<User> userList;

    public UserAdapter(List<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemuserBinding binding = ItemuserBinding.inflate(inflater, parent, false);

        return new UserViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.UserViewHolder holder, int position) {
        User user = userList.get(position);
        Glide.with(holder.itemView.getContext())
                .load(user.getAvatar())
                .into(holder.binding.avatarImageView);

        String fullname = user.getFirstName() + " " + user.getLastName();
        holder.binding.nameTextView.setText(fullname);
        String email = user.getEmail();
        holder.binding.emailTextView.setText(email);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {

        private ItemuserBinding binding;

        public UserViewHolder(ItemuserBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
