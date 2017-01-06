package nyc.c4q.testsolution.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;

import nyc.c4q.testsolution.backend.ApiResponse;
import nyc.c4q.testsolution.backend.KeyboardKey;

public class KeyboardKeysAdapter extends RecyclerView.Adapter {
    private final List<KeyboardKey> mData;
    private final View mFragmentView;

    public KeyboardKeysAdapter(ApiResponse data, View fragmentView) {
        mData = data.getKeys();
        mFragmentView = fragmentView;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new KeyboardKeysHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        KeyboardKeysHolder viewHolder = (KeyboardKeysHolder) holder;
        viewHolder.bind(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
