package ruanyun.com.criminalintent2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.UUID;

/**
 * Created by Administrator on 2015/9/18.
 */
public class CrimeFragment extends Fragment {

    public static final String EXTRA_CRIME_ID =
            "ruanyun.com.criminalintent2.crime_id";

    private String TAG = "CrimeFragment";
    private Crime mCrime;
    private EditText edit_title;
    private Button btn_date;
    private CheckBox mSolved;
    private boolean isCheck;

    public static CrimeFragment newInstance(UUID crimeId){
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_CRIME_ID, crimeId);
        CrimeFragment fragment = new CrimeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        UUID crimeId = (UUID) getActivity().getIntent().getSerializableExtra(EXTRA_CRIME_ID);
        UUID crimeId = (UUID) getArguments().getSerializable(EXTRA_CRIME_ID);
        mCrime = CrimeLab.get(getActivity()).getCrime(crimeId);//获取传递过来的Crime
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crime, container, false);

        edit_title = (EditText) view.findViewById(R.id.crime_edit);
        edit_title.setText(mCrime.getTitle());//根据传入的值设置标题
        Log.i(TAG, "crimeFragment ---->  " + mCrime.getTitle());
        edit_title.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                Log.i(TAG, "beforeTextChanged:---->" + s.toString() +"    start:--->" + start +"    count:--->" + count +"    after:--->" + after);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                Log.i(TAG, "onTextChanged:---->" + s.toString() + "    start:--->" + start + "    before:--->" + before + "    count:--->" + count);
                mCrime.setTitle(s.toString());      //编辑框中的文字 设置为Crime标题
            }

            @Override
            public void afterTextChanged(Editable s) {
//                Log.i(TAG, "afterTextChanged:---->" + s.toString());
            }
        });

        Log.i(TAG, "Date to string: " + mCrime.getDate().toString());
        btn_date = (Button) view.findViewById(R.id.btn_date);
        CharSequence charSequence  = DateFormat.format("EEEE,MMM dd, yyyy", mCrime.getDate());
        btn_date.setText(charSequence);
        btn_date.setEnabled(false);

        mSolved = (CheckBox) view.findViewById(R.id.Solved);
        Log.i(TAG, "1.是否选中： " + isCheck);
        mSolved.setChecked(mCrime.getSolved());//根据传入的值设置是否选中
        mSolved.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.i(TAG, "2.是否选中： " + isChecked);
                isCheck = isChecked;
            }
        });
        return view;
    }
}
