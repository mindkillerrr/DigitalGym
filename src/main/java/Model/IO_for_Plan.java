package Model;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class IO_for_Plan {
    private final Element root;
    private final Document doc;

    public IO_for_Plan() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        String url="src\\Data\\Plan.xml";
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
    public int Update(String id, Plan plan)
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
                            case "Sport" -> {
                                grandchild.setNodeValue(plan.getSport());
                            }
                            case "Times" -> {
                                grandchild.setNodeValue(String.valueOf(plan.getTimes()));
                            }
                            case "Start_Time" -> {
                                grandchild.setNodeValue(String.valueOf(plan.getStart_time()));
                            }
                            case "End_Time" -> {
                                grandchild.setNodeValue(String.valueOf(plan.getEnd_time()));
                            }
                            case "Detail"  ->{
                                grandchild.setNodeValue(plan.getDetail());
                            }
                            case "Video_Path" ->{
                                grandchild.setNodeValue(plan.getVideo_path());
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }
    public Plan Read(String id)
    {
        Plan plan = new Plan();
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
                            case "Sport" -> {
                                var textNode = (Text) grandchild.getFirstChild();
                                String text = textNode.getData().trim();
                                plan.setSport(text);
                            }
                            case "Times" -> {
                                var textNode = (Text) grandchild.getFirstChild();
                                String text = textNode.getData().trim();
                                plan.setTimes(Integer.parseInt(text));
                            }
                            case "Start_Time" -> {
                                var textNode = (Text) grandchild.getFirstChild();
                                String text = textNode.getData().trim();
                                plan.setStart_time(Long.parseLong(text));
                            }
                            case "End_Time" -> {
                                var textNode = (Text) grandchild.getFirstChild();
                                String text = textNode.getData().trim();
                                plan.setEnd_time(Long.parseLong(text));
                            }
                            case "Detail"  ->{
                                var textNode = (Text) grandchild.getFirstChild();
                                String text = textNode.getData().trim();
                                plan.setDetail(text);
                            }
                            case "Video_Path" ->{
                                var textNode = (Text) grandchild.getFirstChild();
                                String text = textNode.getData().trim();
                                plan.setVideo_path(text);
                            }
                        }
                    }
                }
            }
        }
        return plan;
    }

}
