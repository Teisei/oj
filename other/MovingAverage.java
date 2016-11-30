import java.util.Date;

public class MovingAverage {
    public long getNow() {
        Date date = new Date();
        return date.getTime() / 1000;
    }

    class Event {
        long previousTime;
        long sum;
        int hit;

        public Event(long time, int val) {
            previousTime = time;
            sum = val;
            hit = 1;
        }
    }

    Event[] events;

    public MovingAverage() {
        events = new Event[300];
    }

    /**
     add a val into the data structure
     */
    public void record(int val) {
        long currentTime = getNow();
        int inx = (int) (currentTime % 300);
        if (events[inx] == null || events[inx].previousTime != currentTime) {
            Event e = new Event(currentTime, val);
            events[inx] = e;
        } else {
            events[inx].sum += val;
            events[inx].hit ++;
        }
    }

    /**
     get the current average of this data structure
     */
    public double getAvg() {
        long totalSum = 0;
        int totalHit = 0;
        long currentTime = getNow();
        for (Event e: events) {
            if (e != null && currentTime - e.previousTime < 300) {
                totalSum += e.sum;
                totalHit += e.hit;
            }
        }
        if (totalHit == 0) return 0.0;
        return (double) totalSum / (double) totalHit;
    }

    public static void main(String[] args) throws InterruptedException {
        MovingAverage ds = new MovingAverage();
        ds.record(17);
        //Thread.sleep(60000);//sleep 60 seconds
        ds.record(28);
        ds.record(39);
        //Thread.sleep(60000);//sleep 60 seconds
        ds.record(7);
        //Thread.sleep(60000);//sleep 60 seconds
        ds.record(28);
        //Thread.sleep(60000);//sleep 60 seconds
        ds.record(28);
        //Thread.sleep(60000);//sleep 60 seconds
        ds.record(28);

        double result = ds.getAvg();
        System.out.println(result);
    }
}
