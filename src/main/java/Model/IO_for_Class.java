package Model;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class IO_for_Class {
    private final Element root;
    private final Document doc;
    public IO_for_Class() throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        String url="src\\Data\\Class.xml";
        File f = new File(url);
        doc = builder.parse(f);
        root = doc.getDocumentElement();
    }
    public int Create(Plan plan)
    {
        return 0;
    }
    public int Delete(String id)
    {
        return 0;
    }
    public int Update(String id, Class course)
    {
        NodeList children = root.getChildNodes();
        for(int i=0;i<children.getLength();i++) {
            Node child = children.item(i);
            if (child instanceof Element) {
                var childElement = (Element) child;
                String ID = childElement.getAttribute("id");
                if (!ID.equals(id))
                    continue;
                NodeList grandchildren = child.getChildNodes();
                for (int j = 0; j < grandchildren.getLength(); j++) {
                    Node grandchild = grandchildren.item(j);

                    if (grandchild instanceof Element) {
                        var grandchildElement = (Element) grandchild;
                        switch (grandchildElement.getTagName().trim()) {
                            case "Trainer" ->{
                                grandchild.setNodeValue(course.getTrainer());
                            }
                            case "State"  ->{
                                grandchild.setNodeValue(course.getState());
                            }
                            case "Info"    ->{
                                grandchild.setNodeValue(course.getInfo());
                            }
                            case "Type"     ->{
                                grandchild.setNodeValue(course.getType());
                            }
                            case "Rate_of_Process" ->{
                                grandchild.setNodeValue(String.valueOf(course.getRate_of_Process()));
                            }
                            case "Rank" ->{
                                grandchild.setNodeValue(String.valueOf(course.getRank()));
                            }
                            case "Price" ->{
                                grandchild.setNodeValue(String.valueOf(course.getPrice()));
                            }
                            case "Day_Plans"->{
                                NodeList great_grandchildren = grandchild.getChildNodes();
                                for(int k=0;k<great_grandchildren.getLength();k++)
                                {
                                    Node great_grandchild = great_grandchildren.item(k);
                                    if(great_grandchild instanceof Element)
                                    {


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
    public Class Read(String id) throws ParserConfigurationException, IOException, SAXException {
        Class course = new Class();
        NodeList children = root.getChildNodes();
        for(int i=0;i<children.getLength();i++) {
            Node child = children.item(i);
            if (child instanceof Element) {
                var childElement = (Element) child;
                String ID = childElement.getAttribute("id");
                if (!ID.equals(id))
                    continue;
                course.setId(ID);
                System.out.println(course.getId()+"xxx");
                NodeList grandchildren = child.getChildNodes();
                for (int j = 0; j < grandchildren.getLength(); j++) {
                    Node grandchild = grandchildren.item(j);

                    if (grandchild instanceof Element) {
                        var grandchildElement = (Element) grandchild;
                        switch (grandchildElement.getTagName().trim()) {
                            case "Trainer" ->{
                                var textNode = (Text) grandchild.getFirstChild();
                                String text = textNode.getData().trim();
                                course.setTrainer(text);
                            }
                            case "State"  ->{
                                var textNode = (Text) grandchild.getFirstChild();
                                String text = textNode.getData().trim();
                                course.setState(text);
                            }
                            case "Info"    ->{
                                var textNode = (Text) grandchild.getFirstChild();
                                String text = textNode.getData().trim();
                                course.setInfo(text);
                            }
                            case "Type"     ->{
                                var textNode = (Text) grandchild.getFirstChild();
                                String text = textNode.getData().trim();
                                course.setType(text);
                            }
                            case "Rate_of_Process" ->{
                                var textNode = (Text) grandchild.getFirstChild();
                                String text = textNode.getData().trim();
                                course.setRate_of_Process(Integer.parseInt(text));
                            }
                            case "Rank" ->{
                                var textNode = (Text) grandchild.getFirstChild();
                                String text = textNode.getData().trim();
                                course.setRank(Integer.parseInt(text));
                            }
                            case "Price" ->{
                                var textNode = (Text) grandchild.getFirstChild();
                                String text = textNode.getData().trim();
                                course.setPrice(Integer.parseInt(text));
                            }
                            case "Day_Plans"->{
                                NodeList great_grandchildren = grandchild.getChildNodes();
                                for(int k=0;k<great_grandchildren.getLength();k++)
                                {
                                    Node great_grandchild = great_grandchildren.item(k);
                                    if(great_grandchild instanceof Element)
                                    {
                                        var great_grandchildElement = (Element) great_grandchild;
                                        IO_for_Plan io =new IO_for_Plan();
                                        course.addDay_Plans(io.Read(great_grandchildElement.getAttribute("id")));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return course;
    }
    public ArrayList<Class> ShowAllClasses() throws ParserConfigurationException, IOException, SAXException {
        ArrayList<Class> list= new ArrayList<>();
        NodeList children = root.getChildNodes();
        for(int i=0;i<children.getLength();i++) {
            Node child = children.item(i);
            Class course = new Class();
            if (child instanceof Element) {
                var childElement = (Element) child;
                course.setId(childElement.getAttribute("id"));
                NodeList grandchildren = child.getChildNodes();
                for (int j = 0; j < grandchildren.getLength(); j++) {
                    Node grandchild = grandchildren.item(j);

                    if (grandchild instanceof Element) {
                        var grandchildElement = (Element) grandchild;
                        switch (grandchildElement.getTagName().trim()) {
                            case "Trainer" ->{
                                var textNode = (Text) grandchild.getFirstChild();
                                String text = textNode.getData().trim();
                                course.setTrainer(text);
                            }
                            case "State"  ->{
                                var textNode = (Text) grandchild.getFirstChild();
                                String text = textNode.getData().trim();
                                course.setState(text);
                            }
                            case "Info"    ->{
                                var textNode = (Text) grandchild.getFirstChild();
                                String text = textNode.getData().trim();
                                course.setInfo(text);
                            }
                            case "Type"     ->{
                                var textNode = (Text) grandchild.getFirstChild();
                                String text = textNode.getData().trim();
                                course.setType(text);
                            }
                            case "Rate_of_Process" ->{
                                var textNode = (Text) grandchild.getFirstChild();
                                String text = textNode.getData().trim();
                                course.setRate_of_Process(Integer.parseInt(text));
                            }
                            case "Rank" ->{
                                var textNode = (Text) grandchild.getFirstChild();
                                String text = textNode.getData().trim();
                                course.setRank(Integer.parseInt(text));
                            }
                            case "Price" ->{
                                var textNode = (Text) grandchild.getFirstChild();
                                String text = textNode.getData().trim();
                                course.setPrice(Integer.parseInt(text));
                            }
                            case "Day_Plans"->{
                                NodeList great_grandchildren = grandchild.getChildNodes();
                                for(int k=0;k<great_grandchildren.getLength();k++)
                                {
                                    Node great_grandchild = great_grandchildren.item(k);
                                    if(great_grandchild instanceof Element)
                                    {
                                        var great_grandchildElement = (Element) great_grandchild;
                                        IO_for_Plan io =new IO_for_Plan();
                                        course.addDay_Plans(io.Read(great_grandchildElement.getAttribute("id")));
                                    }
                                }
                            }
                        }
                    }
                }list.add(course);
            }

        }
        return list;
    }


    public void Update() {
    }
}
