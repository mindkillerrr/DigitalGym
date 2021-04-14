package Model;

import java.util.ArrayList;
import java.util.Date;

public class LivePlan {

    ArrayList<String> url_path,live_plan;
    Date live_start_time;
    public LivePlan()
    {

    }

    public LivePlan(ArrayList<String> url_path, ArrayList<String> live_plan, Date live_start_time) {
        this.url_path = url_path;
        this.live_plan = live_plan;
        this.live_start_time = live_start_time;
    }

    public ArrayList<String> getUrl_path() {
        return url_path;
    }

    public void setUrl_path(ArrayList<String> url_path) {
        this.url_path = url_path;
    }

    public ArrayList<String> getLive_plan() {
        return live_plan;
    }

    public void setLive_plan(ArrayList<String> live_plan) {
        this.live_plan = live_plan;
    }

    public Date getLive_start_time() {
        return live_start_time;
    }

    public void setLive_start_time(Date live_start_time) {
        this.live_start_time = live_start_time;
    }
}
