package ruanyun.com.criminalintent2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public class CrimeActivity extends FragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime);

        FragmentManager fm = getSupportFragmentManager(); // Fragment管理器
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer); // 管理器查找Fragment
        if (fragment == null){//fm管理器中没有Fragment
            fragment = new CrimeFragment();// new 创建一个Fragment
            fm.beginTransaction()
                    .add(R.id.fragmentContainer, fragment)//替换id 为 fragmentContainer 位置的视图布局
                    .commit();//提交事务
        }

    }


}
