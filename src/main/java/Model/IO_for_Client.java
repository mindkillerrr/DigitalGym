package Model;

import org.w3c.dom.*;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class IO_for_Client {
    private final Element root;
    private final Document doc;
    private String url;
    public IO_for_Client() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        url = "target\\classes\\data\\Client.xml";
        File f = new File(url);
        doc = builder.parse(f);
        root = doc.getDocumentElement();
    }
    public int Create(Client client)
    {

        return 0;
    }
    public int Delete(String name)
    {
        return 0;
    }
    public  Client Read(String id) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException {
        Client client = new Client();
        NodeList children = root.getChildNodes();
        for(int i=0;i<children.getLength();i++)
        {
            Node child = children.item(i);


            if(child instanceof Element)
            {
                var childElement = (Element) child;
                String ID = childElement.getAttribute("id");
                if (!ID.equals(id))
                    continue;
                client.setId(id);
                NodeList grandchildren =child.getChildNodes();
                for(int j=0;j<grandchildren.getLength();j++)
                {
                    Node grandchild = grandchildren.item(j);
                    if(grandchild instanceof Element)
                    {
                        var grandchildElement = (Element) grandchild;


                        switch (grandchildElement.getTagName().trim())
                        {
                            case "Name"->    {
                                var textNode = (Text)grandchild.getFirstChild();
                                String text =textNode.getData().trim();
                                client.setName(text);
                            }
                            case "Phone_Number"->
                            {
                                var textNode = (Text)grandchild.getFirstChild();
                                String text =textNode.getData().trim();
                                client.setPhone_number(text);
                            }
                            case "E_mail"->
                            {
                                var textNode = (Text)grandchild.getFirstChild();
                                String text =textNode.getData().trim();
                                client.setEmail(text);
                            }
                            case "Height"->
                            {
                                var textNode = (Text)grandchild.getFirstChild();
                                String text =textNode.getData().trim();
                                client.setHeight(Integer.parseInt(text));
                            }
                            case "Weight"->
                            {
                                var textNode = (Text)grandchild.getFirstChild();
                                String text =textNode.getData().trim();
                                client.setWeight(Integer.parseInt(text));
                            }
                            case "BMI"->
                            {
                                var textNode = (Text)grandchild.getFirstChild();
                                String text =textNode.getData().trim();
                                client.setBMI(Integer.parseInt(text));
                            }
                            case "Fatty_Lipase"->
                            {
                                var textNode = (Text)grandchild.getFirstChild();
                                String text =textNode.getData().trim();
                                client.setFatty_Lipase(Integer.parseInt(text));
                            }
                            case "sex"->
                            {
                                var textNode = (Text)grandchild.getFirstChild();
                                String text =textNode.getData().trim();
                                client.setSex(text);
                            }
                            case "Age"->
                            {
                                var textNode = (Text)grandchild.getFirstChild();
                                String text =textNode.getData().trim();
                                client.setAge(Integer.parseInt(text));
                            }
                            case "Rank"->
                            {
                                var textNode = (Text)grandchild.getFirstChild();
                                String text =textNode.getData().trim();
                                client.setRank(Integer.parseInt(text));
                            }
                            case "State"->
                            {
                                var textNode = (Text)grandchild.getFirstChild();
                                String text =textNode.getData().trim();
                                client.setState(text);
                            }
                            case "Rank_Start_Time"->
                            {
                                var textNode = (Text)grandchild.getFirstChild();
                                String text =textNode.getData().trim();
                                client.setRank_Start_Time(Long.parseLong(text));
                            }
                            case "Rank_End_Time"->
                            {
                                var textNode = (Text)grandchild.getFirstChild();
                                String text =textNode.getData().trim();
                                client.setRank_End_Time(Long.parseLong(text));
                            }
                            case "My_Classes" ->
                            {
                                NodeList great_grandchildren = grandchild.getChildNodes();

                                for(int k=0;k<great_grandchildren.getLength();k++)
                                {

                                    Node great_grandchild = great_grandchildren.item(k);

                                    if( great_grandchild instanceof Element)
                                    {
                                        var textNode = (Text)great_grandchild.getFirstChild();
                                        String text = textNode.getData().trim();
                                        IO_for_Class io = new IO_for_Class();
                                        client.addClasses(io.Read(text));
                                       // System.out.println(text);
                                    }
                                }
                            }
                            case "My_Lives"  ->
                            {
                                NodeList great_grandchildren = grandchild.getChildNodes();
                                for(int k=0;k<great_grandchildren.getLength();k++)
                                {
                                    Node great_grandchild = great_grandchildren.item(k);
                                    if( great_grandchild instanceof Element)
                                    {
                                        var textNode = (Text)great_grandchild.getFirstChild();
                                        String text = textNode.getData().trim();
                                        IO_for_Live io = new IO_for_Live();
                                        client.addLives(io.Read(text));
                                        //System.out.println(textNode);
                                    }
                                }
                            }
                            case "Generic_Plan" ->
                            {
                                NodeList great_grandchildren = grandchild.getChildNodes();
                                for(int k=0;k<great_grandchildren.getLength();k++)
                                {
                                    Node great_grandchild = great_grandchildren.item(k);
                                    if( great_grandchild instanceof Element)
                                    {
                                        var textNode = (Text)grandchild.getFirstChild();
                                        String text = textNode.getData().trim();
                                        IO_for_Generic_Plan io = new IO_for_Generic_Plan();
                                        client.addGeneric_Plan(io.Read(text));
                                    }
                                }
                            }
                        }
                    }
                }

            }


        }

        return client;
    }
    public int Update(String id,Client client) throws IOException, ParserConfigurationException, SAXException, XPathExpressionException {
        NodeList children = root.getChildNodes();
        for(int i=0;i<children.getLength();i++)
        {
            Node child = children.item(i);


            if(child instanceof Element)
            {
                var childElement = (Element) child;
                String ID = childElement.getAttribute("id");
                if (!ID.equals(id))
                    continue;
                NodeList grandchildren =child.getChildNodes();
                for(int j=0;j<grandchildren.getLength();j++)
                {
                    Node grandchild = grandchildren.item(j);
                    if(grandchild instanceof Element)
                    {
                        var grandchildElement = (Element) grandchild;


                        switch (grandchildElement.getTagName().trim())
                        {
                            case "Name"->    {
                                var textNode = (Text)grandchild.getFirstChild();
                                String text =textNode.getData().trim();
                                client.setName(text);
                            }
                            case "Phone_Number"->
                                    {
                                        var textNode = (Text)grandchild.getFirstChild();
                                        String text =textNode.getData().trim();
                                        client.setPhone_number(text);
                                    }
                            case "E_mail"->
                                    {
                                        var textNode = (Text)grandchild.getFirstChild();
                                        String text =textNode.getData().trim();
                                        client.setEmail(text);
                                    }
                            case "Height"->
                                    {
                                        var textNode = (Text)grandchild.getFirstChild();
                                        String text =textNode.getData().trim();
                                        client.setHeight(Integer.parseInt(text));
                                    }
                            case "Weight"->
                                    {
                                        var textNode = (Text)grandchild.getFirstChild();
                                        String text =textNode.getData().trim();
                                        client.setWeight(Integer.parseInt(text));
                                    }
                            case "BMI"->
                                    {
                                        var textNode = (Text)grandchild.getFirstChild();
                                        String text =textNode.getData().trim();
                                        client.setBMI(Integer.parseInt(text));
                                    }
                            case "Fatty_Lipase"->
                                    {
                                        var textNode = (Text)grandchild.getFirstChild();
                                        String text =textNode.getData().trim();
                                        client.setFatty_Lipase(Integer.parseInt(text));
                                    }
                            case "sex"->
                                    {
                                        var textNode = (Text)grandchild.getFirstChild();
                                        String text =textNode.getData().trim();
                                        client.setSex(text);
                                    }
                            case "Age"->
                                    {
                                        var textNode = (Text)grandchild.getFirstChild();
                                        String text =textNode.getData().trim();
                                        client.setAge(Integer.parseInt(text));
                                    }
                            case "Rank"->
                                    {
                                        var textNode = (Text)grandchild.getFirstChild();
                                        String text =textNode.getData().trim();
                                        client.setRank(Integer.parseInt(text));
                                    }
                            case "State"->
                                    {
                                        var textNode = (Text)grandchild.getFirstChild();
                                        String text =textNode.getData().trim();
                                        client.setState(text);
                                    }
                            case "Rank_Start_Time"->
                                    {
                                        var textNode = (Text)grandchild.getFirstChild();
                                        String text =textNode.getData().trim();
                                        client.setRank_Start_Time(Long.parseLong(text));
                                    }
                            case "Rank_End_Time"->
                                    {
                                        var textNode = (Text)grandchild.getFirstChild();
                                        String text =textNode.getData().trim();
                                        client.setRank_End_Time(Long.parseLong(text));
                                    }
                            case "My_Classes" ->
                                    {
                                        IO_for_Client io1 = new IO_for_Client();
                                        Client client1 = new Client();
                                        client1 = io1.Read(client.getId());
                                        for(int k=0;k<client.My_Classes.size();k++)
                                        {
                                            int flag = 0;//not find
                                            for(Class c:client1.getMy_Classes()){
                                                if(c.getId().equals(client.getAClass(k).getId()))
                                                {
                                                    flag = 1;
                                                    break;
                                                }
                                            }
                                            if(flag==0)
                                            {
                                                Text textnode = doc.createTextNode(client.getAClass(k).id);

                                                Element great_grandchildElement = doc.createElement("My_Class");

                                                great_grandchildElement.appendChild(textnode);
                                                great_grandchildElement.setAttribute("id",client.getAClass(k).id);
                                                System.out.println("IOCLIENT: "+great_grandchildElement.getTagName()+"    "+great_grandchildElement.getAttribute("id"));
                                                Node great_grandchild = grandchildElement.appendChild(great_grandchildElement);
                                                var textNode = (Text)great_grandchild.getFirstChild();
                                                String text = textNode.getData().trim();
                                                System.out.println("IOCLIENT: "+text);
                                                DOMImplementation impl = doc.getImplementation();
                                                var implLS= (DOMImplementationLS) impl.getFeature("LS","3.0");
                                                LSSerializer ser = implLS.createLSSerializer();
                                                ser.getDomConfig().setParameter("format-pretty-print",true);
                                                LSOutput out  = implLS.createLSOutput();
                                                out.setEncoding("UTF-8");
                                                out.setByteStream(Files.newOutputStream(Path.of(url)));
                                                ser.write(doc,out);
                                            }
                                        }
                                    }
                            case "My_Lives"  ->
                                    {

                                        IO_for_Client io1 = new IO_for_Client();
                                        Client client1 = new Client();
                                        client1 = io1.Read(client.getId());
                                        for(int k=0;k<client.My_Lives.size();k++)
                                        {
                                            //System.out.println(k);
                                            int flag = 0;//not find
                                            for(Live c:client1.getMy_Lives()){
                                                if(c.getId().equals(client.getALive(k).getId()))
                                                {
                                                    flag = 1;
                                                    break;
                                                }
                                            }
                                            if(flag==0)
                                            {
                                                Text textnode = doc.createTextNode(client.getAClass(k).id);

                                                Element great_grandchildElement = doc.createElement("My_Live");

                                                great_grandchildElement.appendChild(textnode);
                                                great_grandchildElement.setAttribute("id",client.getAClass(k).id);
                                                System.out.println("IOCLIENT: "+great_grandchildElement.getTagName()+"    "+great_grandchildElement.getAttribute("id"));
                                                Node great_grandchild = grandchildElement.appendChild(great_grandchildElement);
                                                var textNode = (Text)great_grandchild.getFirstChild();
                                                String text = textNode.getData().trim();
                                                System.out.println("IOCLIENT: "+text);
                                                DOMImplementation impl = doc.getImplementation();
                                                var implLS= (DOMImplementationLS) impl.getFeature("LS","3.0");
                                                LSSerializer ser = implLS.createLSSerializer();
                                                ser.getDomConfig().setParameter("format-pretty-print",true);
                                                LSOutput out  = implLS.createLSOutput();
                                                out.setEncoding("UTF-8");
                                                out.setByteStream(Files.newOutputStream(Path.of(url)));
                                                ser.write(doc,out);
                                            }
                                        }
                                    }
                            case "Generic_Plan" ->
                                    {
                                        NodeList great_grandchildren = grandchild.getChildNodes();
                                        for(int k=0;k<great_grandchildren.getLength();k++)
                                        {
                                            Node great_grandchild = great_grandchildren.item(j);
                                            if( great_grandchild instanceof Element)
                                            {
                                                var textNode = (Text)grandchild.getFirstChild();
                                                String text = textNode.getData().trim();
                                                IO_for_Generic_Plan io = new IO_for_Generic_Plan();
                                                client.addGeneric_Plan(io.Read(text));
                                            }
                                        }
                                    }
                        }
                    }
                }

            }


        }
        return 0;
    }
}
