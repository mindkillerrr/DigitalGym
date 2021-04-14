package Model;

import java.util.ArrayList;

public class Live {

    String Trainer, State, Info, Type, path;
    int Rate_of_Process, Start_time, End_time;
    int price;
    int rank;
    String id;
    ArrayList<Plan> Day_Plans = new ArrayList<Plan>();

    public Live(String trainer, String state, String info, String type,
                int rate_of_Process, int start_time, int end_time,
                ArrayList<String> video_Path, ArrayList<Plan> day_Plans) {
        Trainer = trainer;
        State = state;
        Info = info;
        Type = type;
        Rate_of_Process = rate_of_Process;
        Start_time = start_time;
        End_time = end_time;

        Day_Plans = day_Plans;
    }

    public Live() {

    }

    public String getTrainer() {
        return Trainer;
    }

    public String getState() {
        return State;
    }

    public String getInfo() {
        return Info;
    }

    public String getType() {
        return Type;
    }

    public int getRate_of_Process() {
        return Rate_of_Process;
    }

    public int getStart_time() {
        return Start_time;
    }

    public int getEnd_time() {
        return End_time;
    }


    public ArrayList<Plan> getDay_Plans() {
        return Day_Plans;
    }

    public void setTrainer(String trainer) {
        Trainer = trainer;
    }

    public void setState(String state) {
        State = state;
    }

    public void setInfo(String info) {
        Info = info;
    }

    public void setType(String type) {
        Type = type;
    }

    public void setRate_of_Process(int rate_of_Process) {
        Rate_of_Process = rate_of_Process;
    }

    public void setStart_time(int start_time) {
        Start_time = start_time;
    }

    public void setEnd_time(int end_time) {
        End_time = end_time;
    }



    public void setDay_Plans(ArrayList<Plan> day_Plans) {
        Day_Plans = day_Plans;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getPrice() {
        return price;
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

    public void addDay_Plans(Plan p) {
        Day_Plans.add(p);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
