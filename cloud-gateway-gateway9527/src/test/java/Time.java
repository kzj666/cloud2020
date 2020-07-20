/*
@author kzj
@date 2020/7/17 - 11:09
*/

import java.time.ZonedDateTime;

public class Time {
    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
        // 2020-07-17T11:10:19.226+08:00[Asia/Shanghai]
    }
}
