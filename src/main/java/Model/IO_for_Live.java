package Model;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class IO_for_Live {
    private final Element root;
    private final Document doc;
    public IO_for_Live() throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        String url="src\\Data\\Live.xml";
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
    public int Update(String id, String tag, String text)
    {
        return 0;
    }
    public Live Read(String id) throws ParserConfigurationException, IOException, SAXException {
       Live live = new Live();
        NodeList children = root.getChildNodes();
        for(int i=0;i<children.getLength();i++) {
            Node child = children.item(i);
            if (child instanceof Element) {
                var childElement = (Element) child;
                String ID = childElement.getAttribute("id");
                if (!ID.equals(id))
                    continue;
                live.setId(id);
                NodeList grandchildren = child.getChildNodes();
                for (int j = 0; j < grandchildren.getLength(); j++) {
                    Node grandchild = grandchildren.item(j);

                    if (grandchild instanceof Element) {
                        var grandchildElement = (Element) grandchild;
                        switch (grandchildElement.getTagName().trim()) {
                            case "Trainer" ->{
                                var textNode = (Text) grandchild.getFirstChild();
                                String text = textNode.getData().trim();
                                live.setTrainer(text);
                            }
                            case "State"  ->{
                                var textNode = (Text) grandchild.getFirstChild();
                                String text = textNode.getData().trim();
                                live.setState(text);
                            }
                            case "Info"    ->{
                                var textNode = (Text) grandchild.getFirstChild();
                                String text = textNode.getData().trim();
                                live.setInfo(text);
                            }
                            case "Type"     ->{
                                var textNode = (Text) grandchild.getFirstChild();
                                String text = textNode.getData().trim();
                                live.setType(text);
                            }
                            case "Rate_of_Process" ->{
                                var textNode = (Text) grandchild.getFirstChild();
                                String text = textNode.getData().trim();
                                live.setRate_of_Process(Integer.parseInt(text));
                            }
                            case "Rank" ->{
                                var textNode = (Text) grandchild.getFirstChild();
                                String text = textNode.getData().trim();
                                live.setRank(Integer.parseInt(text));
                            }
                            case "Price" ->{
                                var textNode = (Text) grandchild.getFirstChild();
                                String text = textNode.getData().trim();
                                live.setPrice(Integer.parseInt(text));
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
                                        live.addDay_Plans(io.Read(great_grandchildElement.getAttribute("id")));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return live;
    }
    public ArrayList<Live> ShowAllLives() throws ParserConfigurationException, IOException, SAXException {
        ArrayList<Live> list= new ArrayList<>();
        NodeList children = root.getChildNodes();
        for(int i=0;i<children.getLength();i++) {
            Node child = children.item(i);
            Live course = new Live();
            if (child instanceof Element) {
                var childElement = (Element) child;
                course.setId(childElement.getAttribute("id"));
                NodeList grandchildren = child.getChildNodes();
               // System.out.println(grandchildren.getLength());
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
}
