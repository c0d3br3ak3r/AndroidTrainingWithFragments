package andtraining.com.androidtrainingwithfragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends FragmentActivity implements LoginFragment.OnFragmentInteractionListener, SignUpFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Load the inital activity into fragment container
        if(findViewById(R.id.MyFragmentContainer)!=null) {
            LoginFragment default_login_frag = new LoginFragment();
            default_login_frag.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.MyFragmentContainer,default_login_frag).commit();
        }

        onSwitchListeners();
    }

    public void onFragmentInteraction(Uri uri) {
        //Doing nothing ?
    }

    public void onSwitchListeners() {
        Switch switch_widget = (Switch)findViewById(R.id.switch1);
        switch_widget.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {  //Load signup fragment
                    SignUpFragment signup_frag = new SignUpFragment();
                    FragmentTransaction txn = getSupportFragmentManager().beginTransaction();
                    txn.replace(R.id.MyFragmentContainer, signup_frag);
                    //txn.addToBackStack(null);
                    txn.commit();
                } else {  //Load login fragment
                    LoginFragment login_frag = new LoginFragment();
                    FragmentTransaction txn = getSupportFragmentManager().beginTransaction();
                    txn.replace(R.id.MyFragmentContainer,login_frag);
                    //txn.addToBackStack(null);
                    txn.commit();
                }
            }
        });
    }
}
