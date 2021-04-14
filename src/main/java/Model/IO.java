package Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.io.FileUtils;

import java.io.*;

public class IO{
    public static Object Input_Info(Object o, String primary_key) throws IOException {



            File file = new File("src\\main\\java\\Data\\client.json");
            //BufferedReader buffered_reader = new BufferedReader(new FileReader("src\\"+primary_key+".json"));


            String content= FileUtils.readFileToString(file,"UTF-8");
        Gson gson;
        try {
            GsonBuilder builder = new GsonBuilder()
                    .serializeNulls()
                    .setDateFormat("yyyy-MM-dd HH:mm")
                    .setPrettyPrinting()
                    ;
            gson= builder.create();
            o = gson.fromJson(content, o.getClass());

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return o;
    }

    //read(Object o,String pk)
    //write(Object o,String pk)
    //delete(Object o,String pk)
    //create

    /**
     * used in classes' toString --PZ
     * @param o
     * @return
     */
    public static String printObject(Object o){
        Gson gson = new GsonBuilder().create();
        return gson.toJson(o);
    }


    public static int  Output_Info(Object o, String primary_key)
    {
        return 1;
    }
    public static int Delete_Info(Object o, String primary_key)
    {
        return 1;
    }
    public static void main(String[] args) throws IOException {
        Client p = (Client) Input_Info(new Client(),"1");
        System.out.println(p.toString());
        System.out.println(p.my_live.get(0).toString());
    }
}
