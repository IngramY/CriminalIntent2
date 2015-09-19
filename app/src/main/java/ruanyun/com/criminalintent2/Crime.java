package ruanyun.com.criminalintent2;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2015/9/18.
 */
public class Crime {
    /**
     * 属性
     */
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private Boolean mSolved;

    /**
     * 构造函数
     */
    public Crime() {
        mId = UUID.randomUUID();//自动生成Id
        mDate = new Date();
    }

    /**
     * getting setting 方法
     */
    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public Boolean getSolved() {
        return mSolved;
    }

    public void setSolved(Boolean solved) {
        mSolved = solved;
    }
}
