package ruanyun.com.criminalintent2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

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
//        ArrayAdapter<Crime> adapter = new ArrayAdapter<Crime>(getActivity(),
//                android.R.layout.simple_list_item_1,mCrimes);
        CrimeAdapter adapter = new CrimeAdapter(mCrimes);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Crime c = ((CrimeAdapter) getListAdapter()).getItem(position);

        //Start CrimeActivity
        Intent i = new Intent(getActivity(), CrimeActivity.class);
        i.putExtra(CrimeFragment.EXTRA_CRIME_ID, c.getId());
        startActivity(i);
    }

    private class CrimeAdapter extends ArrayAdapter<Crime> {
        public CrimeAdapter(ArrayList<Crime> crimes) {
            super(getActivity(), 0, crimes);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_crime, parent, false);
                viewHolder = new ViewHolder(convertView);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            Crime c = getItem(position);
            viewHolder.crimelistitemdateTextView.setText(c.getDate().toString());
            viewHolder.crimelistitemtitleTextView.setText(c.getTitle());
            viewHolder.crimelistitemsolvedCheckBox.setChecked(c.getSolved());
            return convertView;
        }

        public class ViewHolder {
            public final CheckBox crimelistitemsolvedCheckBox;
            public final TextView crimelistitemtitleTextView;
            public final TextView crimelistitemdateTextView;
            public final View root;

            public ViewHolder(View root) {
                crimelistitemsolvedCheckBox = (CheckBox) root.findViewById(R.id.crime_list_item_solvedCheckBox);
                crimelistitemtitleTextView = (TextView) root.findViewById(R.id.crime_list_item_titleTextView);
                crimelistitemdateTextView = (TextView) root.findViewById(R.id.crime_list_item_dateTextView);
                this.root = root;
            }
        }
    }


}
