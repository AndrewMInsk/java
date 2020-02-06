package com.javarush.task.task33.task3309;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/*
Комментарий внутри xml
*/
@XmlRootElement
public class Solution {
    public String test1;
    public List<String> names= new ArrayList<String>();

    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException, IOException {
        //System.out.println(obj);
        //StringReader reader = new StringReader(xmldata);
        StringWriter writer = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(Solution.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(obj, writer);

        //System.out.println(writer.toString());
        String test = writer.toString();
        test = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
                "<shop>\n" +
                "    <goods>goods</goods>\n" +
                "    <count>5</count>\n" +
                "    <profit>3.14</profit>\n" +
                "    <secretData><![CDATA[<secretData> </secretData>]]></secretData>\n" +
                "    <secr1etData><![CDATA[<secretData> </secretData>]]></secr1etData>\n" +
                "    <secretData></secretData>\n" +"<secretData/>"+
                "</shop>";
        StringReader reader = new StringReader(test);
        BufferedReader bReader = new BufferedReader(reader);
        String line=null;
        StringWriter writerFinal = new StringWriter();

        while((line=bReader.readLine())!=null){




            if(line.contains("<"+tagName+">"+"<![CDATA")){

                String linetemp  =line.replaceFirst("<"+tagName+">","<!--"+comment+"-->\n<"+tagName+">");
                linetemp  =linetemp.replaceFirst("<"+tagName+"/>","<!--"+comment+"-->\n<"+tagName+"/>");
                writerFinal.write(linetemp);

//                if(line.contains("<"+tagName+">")){
//                    //System.out.println("!");
//                    writerFinal.write(line);
//                    continue;
//                }

            }
            else {
                if(!line.contains("<![CDATA")) {
                    String linetemp = line.replace("<" + tagName + ">", "<!--" + comment + "-->\n<" + tagName + ">");
                    linetemp = linetemp.replace("<" + tagName + "/>", "<!--" + comment + "-->\n<" + tagName + "/>");
                    writerFinal.write(linetemp);
                }
                else                     writerFinal.write(line);

            }
        }
        String test2 = writerFinal.toString();
        System.out.println(test2);

        return test2;
    }

    public static void main(String[] args) throws IOException, JAXBException {
        Solution test = new Solution();
        test.test1="dsfd";
        test.names.add("23");
        test.names.add("<![CDATA[<secretData> </secretData>]]>");
        toXmlWithComment(test,"secretData","it's a comment");

    }
}
