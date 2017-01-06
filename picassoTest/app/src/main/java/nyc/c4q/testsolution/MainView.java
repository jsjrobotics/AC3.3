package nyc.c4q.testsolution;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nyc.c4q.testsolution.adapter.KeyboardKeysAdapter;
import nyc.c4q.testsolution.backend.ApiResponse;

public class MainView {
    private final View mRoot;
    private final RecyclerView mRecyclerView;

    public MainView(LayoutInflater inflater, ViewGroup parent) {
        mRoot = inflater.inflate(R.layout.fragment_main, parent,false);
        mRecyclerView = (RecyclerView) mRoot.findViewById(R.id.list);
    }

    public View getLayout() {
        return mRoot;
    }

    public void setData(Context context, ApiResponse data) {
        KeyboardKeysAdapter adapter = new KeyboardKeysAdapter(data, mRoot);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
    }
}
