package tech.android.tcmp13.cleanfragmentcommunicationdemo;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by tcmp13-t on 12/18/2016.
 */
public class NewCarFragment extends Fragment {

    private NewCarCreatedListener newCarCreatedListener;

    /**
     * The functionality will be performed at runtime when everything is displayed to the user, so
     * just the knowledge of who the containing context(activity) is should be enough to set the callback interface.
     * @param context the containing context (activity)
     */
    @Override
    public void onAttach(Context context) {

        super.onAttach(context);
        if (context instanceof NewCarCreatedListener) {
            newCarCreatedListener = (NewCarCreatedListener) context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_new, container, false);
        final EditText newCarEditText = (EditText) view.findViewById(R.id.newCarEditText);

        Button save = (Button) view.findViewById(R.id.saveCarButton);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String car = newCarEditText.getText().toString();
                //Call the callback interface with the new data
                newCarCreatedListener.onNewCarCreated(car);
            }
        });

        return view;
    }
}
