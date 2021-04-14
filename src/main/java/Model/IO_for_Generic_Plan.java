package Model;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class IO_for_Generic_Plan {
    private final Element root;
    private final Document doc;
    public IO_for_Generic_Plan() throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        String url="src\\Data\\GenericPlan.xml";
        File f = new File(url);
        doc = builder.parse(f);
        root = doc.getDocumentElement();
    }
    public int Create(Generic_Plan plan)
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
    public Generic_Plan Read(String id) {
        Generic_Plan plan = new Generic_Plan();
        NodeList children = root.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
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
                            case "Food_Plan" -> {
                                var textNode = (Text) grandchild.getFirstChild();
                                String text = textNode.getData().trim();
                                plan.setFood_plan(text);
                            }
                        }
                    }
                }
            }

        }
        return plan;
    }
}
