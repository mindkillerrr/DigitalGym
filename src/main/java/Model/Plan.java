package Model;

public class Plan {

    String Sport;
    int Times;
    long Start_time, End_time;
    String detail;
    String video_path;
    public Plan(String sport, int times, long start_time, long end_time) {
        Sport = sport;
        Times = times;
        Start_time = start_time;
        End_time = end_time;
    }
    public Plan()
    {

    }
    public String getSport() {
        return Sport;
    }

    public int getTimes() {
        return Times;
    }

    public long getStart_time() {
        return Start_time;
    }

    public long getEnd_time() {
        return End_time;
    }

    public void setSport(String sport) {
        Sport = sport;
    }

    public void setTimes(int times) {
        Times = times;
    }

    public void setStart_time(long start_time) {
        Start_time = start_time;
    }

    public void setEnd_time(long end_time) {
        End_time = end_time;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getVideo_path() {
        return video_path;
    }

    public void setVideo_path(String video_path) {
        this.video_path = video_path;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "Sport='" + Sport + '\'' +
                ", Times=" + Times +
                ", Start_time=" + Start_time +
                ", End_time=" + End_time +
                '}';
    }

    /**
     * Added by PZ
     * @return
     */
    public String getPlan(){
        String s = new String("Sport: " + Sport + "\n"+"Times: "+Times+"\n"+"Start_time: "+Start_time+"\n"+"End_Time: "+End_time);
        return s;
    }
}
