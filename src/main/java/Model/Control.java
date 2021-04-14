package Model;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.util.ArrayList;

public class Control {
    public Control()
    {

    }

    /**
     * @author ZZ
     * This method has been fixed by PZ at 4.9
     * This method will show all classes from database
     * @return all classes
     * @throws IOException
     * @throws ParserConfigurationException
     * @throws SAXException
     */
    public ArrayList<Class> ShowAllClasses() throws IOException, ParserConfigurationException, SAXException {
        IO_for_Class io =new IO_for_Class();
        return io.ShowAllClasses();
    }
    public ArrayList<Live> ShowAllLives() throws IOException, ParserConfigurationException, SAXException {
        IO_for_Live io = new IO_for_Live();
        return io.ShowAllLives();
    }

    /**
     * @author PZ
     * this method return a client's subscribed classes arraylist
     * @param id client id, need to be modified to client email or phone latter
     * @return target classes
     * @throws XPathExpressionException
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    public ArrayList<Class> showClientClasses(String id) throws ParserConfigurationException, SAXException, XPathExpressionException, IOException {
        Client client = ReadClient(id);
        return client.My_Classes;
    }
    /**
     * @author PZ
     * this method return a client's subscribed classes arraylist
     * @param id client id, need to be modified to client email or phone latter
     * @return  targeted lives
     * @throws XPathExpressionException
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    public ArrayList<Live> showClientLives(String id) throws ParserConfigurationException, SAXException, XPathExpressionException, IOException {
        Client client = ReadClient(id);
        return client.My_Lives;
    }
    /**
     *
     * this method return a Client object
     * @param id client id, need to be modified to client email or phone latter
     * @return
     * @throws XPathExpressionException
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    public Client ReadClient(String id) throws XPathExpressionException, ParserConfigurationException, IOException, SAXException {
        //System.out.println(id);
        IO_for_Client io = new IO_for_Client();
        return io.Read(id);
    }
    public int AddClass(String userid, String id) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        IO_for_Client io1 = new IO_for_Client();
        Client user = io1.Read(userid);
        IO_for_Class io2 =new IO_for_Class();
        user.addClasses(io2.Read(id));
        //System.out.println(io2.Read(id).getId()+"xxxxxxxx");
        return io1.Update(userid,user);
    }

    public int AddLive(String userid, String id) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        IO_for_Client io1 = new IO_for_Client();
        Client user = io1.Read(userid);

        IO_for_Live io2 =new IO_for_Live();
        user.addLives(io2.Read(id));
        System.out.println(user.getMy_Lives().size());
        return io1.Update(userid,user);
    }

}
