package vaibhav.vaibhavmain;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by simpl on 20-03-2016.
 */
public class FragmentTwo extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstances){
        return inflater.inflate(R.layout.fragment_two,container,false);
    }

}
