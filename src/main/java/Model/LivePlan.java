package Model;

import java.util.ArrayList;
import java.util.Date;

public class LivePlan {

    private String live_url;
    private Date live_start_Date;//null before book
    private String personal_plan;
    private String course_id;
    private String client_id;

    public LivePlan(String client_id) {
        setLive_url("initial url");
        setLive_start_Date(null);
        setPersonal_plan("initial text");


    }
    public String toString(){
        return "use IO.printObject instead.";
    }

    public String getLive_url() {
        return live_url;
    }

    public void setLive_url(String live_url) {
        this.live_url = live_url;
    }

    public Date getLive_start_Date() {
        return live_start_Date;
    }

    public void setLive_start_Date(Date live_start_Date) {
        this.live_start_Date = live_start_Date;
    }

    public String getPersonal_plan() {
        return personal_plan;
    }

    public void setPersonal_plan(String personal_plan) {
        this.personal_plan = personal_plan;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }
}
