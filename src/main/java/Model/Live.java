package Model;

import java.util.ArrayList;

public class Live {

    String course_id,name,trainer_id,client_id,trainer,type,state,info;
    int rank;
    double price;
    ArrayList<String> plan;
    ArrayList<LivePlan> live_plan;

    public Live() {

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

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ArrayList<String> getPlan() {
        return plan;
    }

    public void setPlan(ArrayList<String> plan) {
        this.plan = plan;
    }

    public ArrayList<LivePlan> getLive_plan() {
        return live_plan;
    }

    public void setLive_plan(ArrayList<LivePlan> live_plan) {
        this.live_plan = live_plan;
    }

    @Override
    public String toString() {
        return "Live{" +
                "course_id='" + course_id + '\'' +
                ", name='" + name + '\'' +
                ", trainer_id='" + trainer_id + '\'' +
                ", client_id='" + client_id + '\'' +
                ", trainer='" + trainer + '\'' +
                ", type='" + type + '\'' +
                ", state='" + state + '\'' +
                ", info='" + info + '\'' +
                ", rank=" + rank +
                ", price=" + price +
                ", plan=" + plan +
                ", live_plan=" + live_plan +
                '}';
    }
}
