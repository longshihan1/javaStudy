package dom;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class DOM4JTest {
    public static void main(String[] args) {
        //创建一个DocumentBuilderFactory的对象
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        //创建一个DocumentBuilder的对象
        try {
            //创建DocumentBuilder对象
            DocumentBuilder db = dbf.newDocumentBuilder();
            //通过DocumentBuilder对象的parser方法加载books.xml文件到当前项目下
            Document document = db.parse("outfile\\AndroidManifest.xml");
            //------------------------------------------------------------
            System.out.println("-------------------修改manifest的属性--------------------------");
            NodeList manifests = document.getElementsByTagName("manifest");
            Node manifest = manifests.item(0);
            Element manifestElement = manifest.getOwnerDocument().getDocumentElement();
            Attr manifestattr = document.createAttribute("package");
            manifestattr.setValue("666651");
            manifestElement.setAttributeNode(manifestattr);
            System.out.println("-------------------修改application的属性--------------------------");
            //获取所有application节点的集合
            NodeList applicationList = document.getElementsByTagName("application");
            //通过 item(i)方法 获取一个application节点，nodelist的索引值从0开始
            Node application = applicationList.item(0);
            if (application.getAttributes().getNamedItem("android:name")==null) {
                //添加android:name
                Element element= (Element) application;
                Attr applicationattr = document.createAttribute("android:name");
                applicationattr.setValue("com.longshihan.MyApplication");
                element.setAttributeNode(applicationattr);
            }else {
                //修改android:name
                application.getAttributes().getNamedItem("android:name").setNodeValue("com.longshihan.MyApplication1");
            }

            //创建要增加的节点元素
            Element nn = document.createElement("activity");
            //设置节点属性
            Attr attr = document.createAttribute("android:name");
            attr.setValue("testActivitya");
            nn.setAttributeNode(attr);
            //增加新元素stu的子元素
            Element nn1 = document.createElement("intent-filter");
            nn.appendChild(nn1);
            //性别
            Element nn2 = document.createElement("action");
            Attr actionAttr = document.createAttribute("android:name");
            actionAttr.setValue("android.intent.action.MAIN");
            nn2.setAttributeNode(actionAttr);
            nn1.appendChild(nn2);
            //班级
            Element nn3 = document.createElement("category");
            Attr categoryAttr = document.createAttribute("android:name");
            categoryAttr.setValue("android.intent.category.LAUNCHER");
            nn3.setAttributeNode(categoryAttr);
            nn1.appendChild(nn3);
            application.appendChild(nn);


            //创建一个用来转换DOM对象的工厂对象
            TransformerFactory factory = TransformerFactory.newInstance();
            //获得转换器对象
            Transformer t = factory.newTransformer();
            //定义要转换的源对象
            DOMSource xml = new DOMSource(document);
            //定义要转换到的目标文件
            StreamResult s = new StreamResult(new File("outfile\\mainfest2.xml"));
            //开始转换
            t.transform(xml, s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
