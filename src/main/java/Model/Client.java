package Model;

import java.util.ArrayList;

public class Client{
        String name, Phone_number, Email, State, Password, Sex;
        int Weight, Height, BMI, Fatty_Lipase, Age, Rank;
        long Rank_Start_Time, Rank_End_Time;
        double discount;
        int free_time;
        String id;
        Generic_Plan generic_plan;
        ArrayList<Live> My_Lives = new ArrayList<>();
        ArrayList<Generic_Plan> Generic_Plans = new ArrayList<>();
        ArrayList<Class>My_Classes = new ArrayList<>();
        public Client()
        {

        }
        public Client(String Phone_number, String Email) {
                this.Phone_number = Phone_number;
                this.Email = Email;
        }
        public String getName() {
                return name;
        }

        public String getPhone_number() {
                return Phone_number;
        }

        public String getEmail() {
                return Email;
        }

        public String getState() {
                return State;
        }

        public int getWeight() {
                return Weight;
        }

        public int getHeight() {
                return Height;
        }

        public int getBMI() {
                return BMI;
        }

        public int getFatty_Lipase() {
                return Fatty_Lipase;
        }

        public int getAge() {
                return Age;
        }

        public int getRank() {
                return Rank;
        }

        public long getRank_Start_Time() {
                return Rank_Start_Time;
        }

        public long getRank_End_Time() {
                return Rank_End_Time;
        }

        public ArrayList<Live> getMy_Lives() {
                return My_Lives;
        }

        public ArrayList<Generic_Plan> getGeneric_Plans() {
                return Generic_Plans;
        }
        public void setName(String name) {
                this.name = name;
        }

        public void setPhone_number(String phone_number) {
                this.Phone_number = phone_number;
        }

        public void setEmail(String email) {
                this.Email = email;
        }

        public void setState(String state) {
                this.State = state;
        }

        public void setWeight(int weight) {
                this.Weight = weight;
        }

        public void setHeight(int height) {
                this.Height = height;
        }

        public void setFatty_Lipase(int fatty_Lipase) {
                this.Fatty_Lipase = fatty_Lipase;
        }

        public void setAge(int age) {
                this.Age = age;
        }

        public void setRank(int rank) {
                this.Rank = rank;
        }

        public void setRank_Start_Time(long rank_Start_Time) {
                this.Rank_Start_Time = rank_Start_Time;
        }

        public void setRank_End_Time(long rank_End_Time) {
                this.Rank_End_Time = rank_End_Time;
        }

        public void setMy_Lives(ArrayList<Live> my_Lives) {
                this.My_Lives = my_Lives;
        }

        public void setGeneric_Plans(ArrayList<Generic_Plan> generic_Plans) {
                this.Generic_Plans = generic_Plans;
        }
        public void setBMI(int BMI) {
                this.BMI =Weight/(Height*Height);
        }
        public void setSex(String Sex)
        {
                this.Sex = Sex;
        }
        public String getSex()
        {
                return Sex;
        }

        public String getPassword() {
                return Password;
        }

        public void setPassword(String password) {
                Password = password;
        }

        public double getDiscount() {
                return discount;
        }

        public void setDiscount(double discount) {
                this.discount = discount;
        }

        public ArrayList<Class> getMy_Classes() {
                return My_Classes;
        }

        public Class getAClass(int n)
        {
                return My_Classes.get(n);
        }

        public void setMy_Classes(ArrayList<Class> my_Classes) {
                this.My_Classes = my_Classes;
        }

        public Generic_Plan getGeneric_plan() {
                return generic_plan;
        }

        public void setGeneric_plan(Generic_Plan generic_plan) {
                this.generic_plan = generic_plan;
        }
        public  void addClasses(Class course)
        {
                My_Classes.add(course);
        }
        public  void addLives(Live live)
        {
                My_Lives.add(live);
        }
        public void addGeneric_Plan(Generic_Plan p)
        {
                Generic_Plans.add(p);
        }

        public int getFree_time() {
                return free_time;
        }

        public void setFree_time(int free_time) {
                this.free_time = free_time;
        }

        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
        }

        public Live getALive(int k) {
                return My_Lives.get(k);
        }
}