package tech.android.tcmp13.cleanfragmentcommunicationdemo;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class  MainActivity extends AppCompatActivity implements NewCarCreatedListener, NewCarRequestedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onNewCarCreated("");
    }

    @Override
    public void onNewCarCreated(String car) {

        DisplayCarFragment displayCarFragment = DisplayCarFragment.newInstance(car);
        getFragmentManager().beginTransaction().replace(R.id.container, displayCarFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).commit();
    }

    @Override
    public void onNewCarRequested() {

        getFragmentManager().beginTransaction().replace(R.id.container, new NewCarFragment())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN) //transition animation
                .addToBackStack(null) //once back is pressed on the NEW fragment, this transaction will be reverted
                .commit();
    }
}
