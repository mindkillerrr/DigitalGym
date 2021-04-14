package Model;

import java.util.ArrayList;
import java.util.Date;

public class Client{
        String phone_number,password,name,state,sex,age,generic_plan;
        int rank,height,weight;
        Date premium_end_date;
        ArrayList<String> my_course;
        ArrayList<Live>my_live;

        public Client(String phone_number) {
                this.phone_number = phone_number;
        }

    public Client() {

    }

    public String getPhone_number() {
                return phone_number;
        }

        public void setPhone_number(String phone_number) {
                this.phone_number = phone_number;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getState() {
                return state;
        }

        public void setState(String state) {
                this.state = state;
        }

        public String getSex() {
                return sex;
        }

        public void setSex(String sex) {
                this.sex = sex;
        }

        public String getAge() {
                return age;
        }

        public void setAge(String age) {
                this.age = age;
        }

        public String getGeneric_plan() {
                return generic_plan;
        }

        public void setGeneric_plan(String generic_plan) {
                this.generic_plan = generic_plan;
        }

        public int getRank() {
                return rank;
        }

        public void setRank(int rank) {
                this.rank = rank;
        }

        public int getHeight() {
                return height;
        }

        public void setHeight(int height) {
                this.height = height;
        }

        public int getWeight() {
                return weight;
        }

        public void setWeight(int weight) {
                this.weight = weight;
        }

        public Date getPremium_end_date() {
                return premium_end_date;
        }

        public void setPremium_end_date(Date premium_end_date) {
                this.premium_end_date = premium_end_date;
        }

        public ArrayList<String> getMy_course() {
                return my_course;
        }

        public void setMy_course(ArrayList<String> my_course) {
                this.my_course = my_course;
        }

        public ArrayList<Live> getMy_live() {
                return my_live;
        }

        public void setMy_live(ArrayList<Live> my_live) {
                this.my_live = my_live;
        }

    @Override
    public String toString() {
        return "Client{" +
                "phone_number='" + phone_number + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", generic_plan='" + generic_plan + '\'' +
                ", rank=" + rank +
                ", height=" + height +
                ", weight=" + weight +
                ", premium_end_date=" + premium_end_date +
                ", my_course=" + my_course +
                ", my_live=" + my_live +
                '}';
    }
}