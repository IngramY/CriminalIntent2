package ruanyun.com.criminalintent2;

import android.support.v4.app.Fragment;

public class CrimeActivity extends SingleFragmentActivity {

    @Override
    public Fragment createFragment() {
        return new CrimeFragment();
    }
}
