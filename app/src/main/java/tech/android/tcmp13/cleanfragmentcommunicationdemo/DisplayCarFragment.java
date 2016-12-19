package tech.android.tcmp13.cleanfragmentcommunicationdemo;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by tcmp13-t on 12/18/2016.
 */
public class DisplayCarFragment extends Fragment {

    private NewCarRequestedListener newCarRequestListener;

    @Override
    public void onAttach(Context context) {

        super.onAttach(context);
        if (context instanceof NewCarRequestedListener) {
            newCarRequestListener = (NewCarRequestedListener) context;
        }
    }

    public static DisplayCarFragment newInstance(String car) {

        DisplayCarFragment fragment = new DisplayCarFragment();

        Bundle args = new Bundle();
        args.putString("car", car);

        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_display, container, false);
        TextView displayTextView = (TextView) view.findViewById(R.id.carDisplayTextView);
        displayTextView.setText(getArguments().getString("car"));

        Button newCarButton = (Button) view.findViewById(R.id.newCarButton);
        newCarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newCarRequestListener.onNewCarRequested();
            }
        });
        return view;
    }
}
