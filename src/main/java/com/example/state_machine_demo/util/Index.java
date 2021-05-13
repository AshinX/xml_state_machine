package com.example.state_machine_demo.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import com.example.state_machine_demo.dto.OperationDto;
import com.sun.org.apache.xerces.internal.dom.DeferredElementImpl;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Component
public class Index {

    public  Map<String,List<OperationDto>> init(){
        Map<String,List<OperationDto>> dataSource=new HashMap<>();
        try {
            File file = new File("/Users/fengyue/IdeaProjects/state_machine_demo/src/main/resources/state-action.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder =  factory.newDocumentBuilder();
            Document doc = builder.parse(file);

            NodeList state = doc.getElementsByTagName("state");

            for (int i = 0; i < state.getLength(); i++) {
                List<OperationDto> operations = new ArrayList<>();
                Node node = state.item(i);
                NamedNodeMap nodeMap = node.getAttributes();
                String stateStr = nodeMap.getNamedItem("id").getNodeValue();

                //------------------开始解析operation--------------------
                NodeList childNodes = ((DeferredElementImpl)node).getElementsByTagName("operations");
                for (int j = 0; j < childNodes.getLength(); j++) {
                    OperationDto dto=new OperationDto();
                    Node item = childNodes.item(j);
                    String operationCode = item.getAttributes().getNamedItem("ref").getNodeValue();
                    String to = item.getAttributes().getNamedItem("to").getNodeValue();
                    dto.setCode(operationCode);
                    dto.setTo(to);

                    operations.add(dto);
                }
                dataSource.put(stateStr,operations);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }


}
