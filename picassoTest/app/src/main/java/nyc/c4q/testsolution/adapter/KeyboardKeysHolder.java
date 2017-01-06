package nyc.c4q.testsolution.adapter;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import nyc.c4q.testsolution.R;
import nyc.c4q.testsolution.SecondActivity;
import nyc.c4q.testsolution.backend.KeyboardKey;

public class KeyboardKeysHolder extends RecyclerView.ViewHolder {
    private final View mRoot;
    private final TextView mName;

    public KeyboardKeysHolder(ViewGroup parent) {
        super(inflateView(parent));
        mRoot = itemView;
        mName = (TextView) mRoot.findViewById(R.id.name);
    }

    private static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.animal_viewholder, parent, false);
    }

    public void bind(final KeyboardKey key) {
        mName.setText(key.getName());
        int textColor = Color.parseColor(key.getTextColor());
        mName.setTextColor(textColor);
        mRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(v.getContext(), SecondActivity.class);
                intent.putExtra(SecondActivity.URL_TO_DOWNLOAD, key.getUrlPath());
                v.getContext().startActivity(intent);
            }
        });

    }
}
