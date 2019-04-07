package algorithms.greedy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
public class Activity {

    private Integer start;
    private Integer finish;

    public Activity(Integer start, Integer finish) {
        this.start = start;
        this.finish = finish;
    }

//    public int getStart() {
//        return start;
//    }
//
//    public int getFinish() {
//        return finish;
//    }
}
