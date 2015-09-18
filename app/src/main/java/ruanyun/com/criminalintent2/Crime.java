package ruanyun.com.criminalintent2;

import java.util.UUID;

/**
 * Created by Administrator on 2015/9/18.
 */
public class Crime {
    private UUID mId;
    private String mTitle;

    public Crime() {
        mId = UUID.randomUUID();//自动生成Id
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
