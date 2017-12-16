package vaibhav.vaibhavmain;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class Tour extends FragmentPagerAdapter {

    public Tour(FragmentManager fm) {
        super(fm);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Fragment getItem(int arg0) {
        // TODO Auto-generated method stub
        switch (arg0) {
            case 0:

                return new FragmentOne();
            case 1:
                return new FragmentTwo();

            case 2:
                return new FragmentThree();
            default:
                break;
        }
        return null;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return 3;
    }


}
