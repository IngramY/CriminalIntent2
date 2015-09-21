package ruanyun.com.criminalintent2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

/**
 * Created by Administrator on 2015/9/18.
 */
public class CrimeFragment extends Fragment {

    private String TAG = "CrimeFragment";
    private Crime mCrime;
    private EditText edit_title;
    private Button btn_date;
    private CheckBox mSolved;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCrime = new Crime();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crime, container, false);

        edit_title = (EditText) view.findViewById(R.id.crime_edit);
        edit_title.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                Log.i(TAG, "beforeTextChanged:---->" + s.toString() +"    start:--->" + start +"    count:--->" + count +"    after:--->" + after);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                Log.i(TAG, "onTextChanged:---->" + s.toString() + "    start:--->" + start + "    before:--->" + before + "    count:--->" + count);
                mCrime.setTitle(s.toString());//编辑框中的文字 设置为Crime标题
            }

            @Override
            public void afterTextChanged(Editable s) {
//                Log.i(TAG, "afterTextChanged:---->" + s.toString());
            }
        });

        Log.i(TAG, "Date to string: " + mCrime.getDate().toString());
        btn_date = (Button) view.findViewById(R.id.btn_date);
        btn_date.setText(mCrime.getDate().toString());

        mSolved = (CheckBox) view.findViewById(R.id.Solved);
        mSolved.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.i(TAG, "是否选中： " + isChecked);
            }
        });


        return view;
    }

}
