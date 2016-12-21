package nyc.c4q.testsolution.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.testsolution.backend.Animal;
import nyc.c4q.testsolution.backend.ApiResponse;

public class AnimalAdapter extends RecyclerView.Adapter {
    private final List<Animal> mData;
    private final View mFragmentView;

    public AnimalAdapter(ApiResponse data, View fragmentView) {
        mData = data.getAnimals();
        mFragmentView = fragmentView;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AnimalViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        AnimalViewHolder viewHolder = (AnimalViewHolder) holder;
        viewHolder.bind(mData.get(position), mFragmentView);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
