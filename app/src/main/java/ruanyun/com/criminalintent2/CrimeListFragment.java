package ruanyun.com.criminalintent2;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/9/22.
 */
public class CrimeListFragment extends ListFragment {
    private String TAG = "CrimeListActivity";
    private ArrayList<Crime> mCrimes;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.Crimes);

        Log.i(TAG, "---------->  CrimeListFragment");
        mCrimes = CrimeLab.get(getActivity()).getCrimes();
        ArrayAdapter<Crime> adapter = new ArrayAdapter<Crime>(getActivity(),
                android.R.layout.simple_list_item_1,mCrimes);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Crime c = (Crime) getListAdapter().getItem(position);

    }

}
