package ruanyun.com.criminalintent2;

import android.support.v4.app.Fragment;
import android.util.Log;

/**
 * Created by Administrator on 2015/9/22.
 */
public class CrimeListActivity extends SingleFragmentActivity {

    private String TAG = "CrimeListActivity";
    @Override
    public Fragment createFragment() {
        Log.i(TAG, "--------->  return new CrimeListActivity");
        return new CrimeListFragment();
    }

}
