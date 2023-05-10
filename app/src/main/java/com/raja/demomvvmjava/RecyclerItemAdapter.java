package com.raja.demomvvmjava;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.raja.demomvvmjava.databinding.RowListItemBinding;

import java.util.List;

public class RecyclerItemAdapter extends RecyclerView.Adapter<RecyclerItemAdapter.ViewHolder> {

    private List<User> userArrayList;

    MainViewModel mainViewModel;

    Context mContext;

    public RecyclerItemAdapter(Context context, List<User> listdata) {
        this.userArrayList = listdata;
        this.mContext = context;

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RowListItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.row_list_item, parent, false);

        mainViewModel = ViewModelProviders.of((FragmentActivity) mContext).get(MainViewModel.class);

        binding.setMainviewmodel(mainViewModel);

        return new ViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.rowListItemBinding.setUser(userArrayList.get(position));

    }


    @Override
    public int getItemCount() {
        return userArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public RowListItemBinding rowListItemBinding;

        public ViewHolder(RowListItemBinding rowListItemBinding1) {
            super(rowListItemBinding1.getRoot());
            this.rowListItemBinding = rowListItemBinding1;
        }
    }
}