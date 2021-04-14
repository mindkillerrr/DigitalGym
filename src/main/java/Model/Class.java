package Model;


import java.util.ArrayList;

public class Class {

    String Trainer, State, Info, Type, Video_Path;
    String id;
    int Rate_of_Process;
    ArrayList<Plan> Day_Plans = new ArrayList<>();
    int price;
    int rank;
    public Class(String trainer, String state, String info, String type,
                 int rate_of_Process,
                 ArrayList<Plan> day_Plans) {
        Trainer = trainer;
        State = state;
        Info = info;
        Type = type;
        Rate_of_Process = rate_of_Process;
        Day_Plans = day_Plans;
    }

    public Class() {

    }

    public String getTrainer() {
        return Trainer;
    }

    public void setTrainer(String trainer) {
        this.Trainer = trainer;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        this.State = state;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        this.Info = info;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        this.Type = type;
    }

    public int getRate_of_Process() {
        return Rate_of_Process;
    }

    public void setRate_of_Process(int rate_of_Process) {
        this.Rate_of_Process = rate_of_Process;
    }

    public ArrayList<Plan> getDay_Plans() {
        return Day_Plans;
    }

    public void setDay_Plans(ArrayList<Plan> day_Plans) {
        this.Day_Plans = day_Plans;
    }

    public String getVideo_Path() {
        return Video_Path;
    }

    public int getPrice() {
        return price;
    }

    public void setVideo_Path(String video_Path) {
        Video_Path = video_Path;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
    public void addDay_Plans(Plan plan)
    {
        Day_Plans.add(plan);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}