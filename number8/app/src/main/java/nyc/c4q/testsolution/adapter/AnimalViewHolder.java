package nyc.c4q.testsolution.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import nyc.c4q.testsolution.R;
import nyc.c4q.testsolution.backend.Animal;

public class AnimalViewHolder extends RecyclerView.ViewHolder {
    private final View mRoot;
    private final TextView mName;

    public AnimalViewHolder(ViewGroup parent) {
        super(inflateView(parent));
        mRoot = itemView;
        mName = (TextView) mRoot.findViewById(R.id.name);
    }

    private static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.animal_viewholder, parent, false);
    }

    public void bind(Animal animal, final View fragmentView) {
        System.out.println("Animal values name -> " + animal.getName() + " * text -->" + animal.getTextColor());
        mName.setText(animal.getName());
        int textColor = Color.parseColor(animal.getTextColor());
        mName.setTextColor(textColor);
        final int backgroundColor = Color.parseColor(animal.getBackground());
        mRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentView.setBackgroundColor(backgroundColor);
            }
        });
    }
}
