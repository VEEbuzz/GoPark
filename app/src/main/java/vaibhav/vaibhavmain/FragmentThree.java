package vaibhav.vaibhavmain;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by simpl on 20-03-2016.
 */
public class FragmentThree extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstances) {
        View v = inflater.inflate(R.layout.fragment_three, container, false);


        Button btn = (Button)v.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),Database.class);
                startActivity(intent);
            }
        });

        return v;

    }

}
