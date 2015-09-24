package ruanyun.com.criminalintent2;

import android.support.v4.app.Fragment;

/**
 * Created by Administrator on 2015/9/22.
 */
public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    public Fragment createFragment() {
        return new CrimeListFragment();
    }
}
