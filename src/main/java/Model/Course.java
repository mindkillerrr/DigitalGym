package Model;


import java.util.ArrayList;

public class Course {

    private String  state, info, type;
    private String course_id,name,trainer_id,trainer,client_id;
    private ArrayList<String> plan;
    private ArrayList<String> video_path;

    private double price;
    private int rank;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrainer_id() {
        return trainer_id;
    }

    public void setTrainer_id(String trainer_id) {
        this.trainer_id = trainer_id;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public ArrayList<String> getPlan() {
        return plan;
    }

    public void setPlan(ArrayList<String> plan) {
        this.plan = plan;
    }

    public ArrayList<String> getVideo_path() {
        return video_path;
    }

    public void setVideo_path(ArrayList<String> video_path) {
        this.video_path = video_path;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}