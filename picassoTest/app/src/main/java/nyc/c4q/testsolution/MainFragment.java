package nyc.c4q.testsolution;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nyc.c4q.testsolution.backend.ApiResponse;
import nyc.c4q.testsolution.backend.Backend;
import nyc.c4q.testsolution.helpers.Consumer;

public class MainFragment extends Fragment {

    private MainView mView;
    private Backend mBackend;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mBackend = new Backend(getContext());
    }
    @Override
    public void onStart(){
        super.onStart();
        mBackend.downloadData(buildDownloadReceiver());
    }

    private Consumer<ApiResponse> buildDownloadReceiver() {
        return new Consumer<ApiResponse>() {
            @Override
            public void accept(ApiResponse data) {
                mView.setData(getContext(), data);
            }
        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        mView = new MainView(inflater, parent);
        return mView.getLayout();
    }
}
