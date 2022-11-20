package conteiners;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class TimeStamp {
    LocalTime start;
    LocalTime end;
    public TimeStamp() {
        this.start = LocalTime.now();
        this.end = LocalTime.now();
    }
    public LocalTime GetStart() {
        return start;
    }
    public LocalTime GetEnd() {
        return end;
    }
    public TimeStamp Stop(){
        end = LocalTime.now();
        return this;
    }
    public long TimeDiff() {
        if(end.compareTo(start) == 0 ){
            return -1;
        } else {
            return start.until(end, ChronoUnit.SECONDS);
        }
    }
}
