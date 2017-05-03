package utilTest;

import com.xiangyang.util.TimeUtils;
import org.junit.Test;

import java.text.ParseException;

/**
 * Created by peiji on 2017/5/2.
 */
public class TimeUtilTest {
    @Test
    public void getTime(){
        System.out.println(TimeUtils.getTodayEndTime());
        System.out.println(TimeUtils.getTodayStartTime());
    }
    @Test
    public void getDateTime(){
        try {
            System.out.println(TimeUtils.getDateStartTime(TimeUtils.formatStrToDate(TimeUtils.YYYY年MM月DD,TimeUtils.getTodayDate())));
            System.out.println(TimeUtils.getDateEndTime(TimeUtils.formatStrToDate(TimeUtils.YYYY年MM月DD,TimeUtils.getTodayDate())));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void getTodayTime(){
        System.out.println(TimeUtils.getTodayDate());
    }
}
