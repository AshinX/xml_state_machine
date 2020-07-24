package com.example.state_machine_demo.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.state_machine_demo.dto.ActionState;
import com.example.state_machine_demo.dto.OperationDto;
import com.example.state_machine_demo.util.Index;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    public static final Map<String,String> stateMap=new HashMap<String,String>();
    public static final Map<String,String> operationMap=new HashMap<String,String>();

    static {
        stateMap.put("startstate","开始");
        stateMap.put("gaixuqiustate","改需求");
        stateMap.put("yangshangstate","养伤");
        stateMap.put("zuohuibaostate","做汇报");
        stateMap.put("siwangstate","死亡");

        operationMap.put("beikaifada","被开发打");
        operationMap.put("yangshangchenggong","养伤成功");
        operationMap.put("yangshangshibai","养伤失败");
        operationMap.put("lingdaobumanyiduini","领导不满意怼你");
        operationMap.put("yangshangchenggonggaixuqiuchenggong","养伤成功改需求成功");
        operationMap.put("gaixuqiuchenggong","修改需求成功");
        operationMap.put("lingdaobumanyi","领导不满意");
        operationMap.put("gaixuqiu","改需求");
        operationMap.put("siwang","死亡");
    }


    @Autowired
    private Index util;

    @GetMapping("/index")
    public ModelAndView index(@RequestParam String operation) {
        ArrayList<OperationDto> dtos = new ArrayList<>();

        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        Map<String, List<OperationDto>> dataSource = util.init();

        List<OperationDto> list = dataSource.get("startstate");

        for (int i = 0; i < list.size(); i++) {
            OperationDto operationDto = list.get(i);
            operationDto.setName(operationMap.get(list.get(i).getCode()));
            operationDto.setUrl("http://localhost:8080/"+list.get(i).getCode()+"?operation="+list.get(i).getCode()+"&state="+operationDto.getTo());
            dtos.add(operationDto);
        }
        List<OperationDto> dtoList = list.stream().filter(e -> operation.equals(e.getCode())).collect(
            Collectors.toList());
        if(null == dtoList || dtoList.size()==0){
            return view;
        }

        view.addObject("state",stateMap.get("startstate"));
        view.addObject("operationList",dtos);
        return view;
    }


    @GetMapping("/beikaifada")
    public ModelAndView beikaifada(@RequestParam String operation,@RequestParam String state) {
        System.out.println("被开发打...");
        ArrayList<OperationDto> dtos = new ArrayList<>();

        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        Map<String, List<OperationDto>> dataSource = util.init();

        List<OperationDto> list = dataSource.get(state);
        for (int i = 0; i < list.size(); i++) {
            OperationDto operationDto = list.get(i);
            operationDto.setName(operationMap.get(list.get(i).getCode()));
            operationDto.setUrl("http://localhost:8080/"+list.get(i).getCode()+"?operation="+list.get(i).getCode()+"&state="+operationDto.getTo());
            dtos.add(operationDto);
        }


        view.addObject("state",stateMap.get(state));
        view.addObject("operationList",dtos);

        return view;
    }

    @GetMapping("/yangshangchenggong")
    public ModelAndView yangshangchenggong(@RequestParam String operation,@RequestParam String state) {
        ArrayList<OperationDto> dtos = new ArrayList<>();

        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        Map<String, List<OperationDto>> dataSource = util.init();

        List<OperationDto> list = dataSource.get(state);
        for (int i = 0; i < list.size(); i++) {
            OperationDto operationDto = list.get(i);
            operationDto.setName(operationMap.get(list.get(i).getCode()));
            operationDto.setUrl("http://localhost:8080/"+list.get(i).getCode()+"?operation="+list.get(i).getCode()+"&state="+operationDto.getTo());
            dtos.add(operationDto);
        }


        view.addObject("state",stateMap.get(state));
        view.addObject("operationList",dtos);

        return view;
    }

    @GetMapping("/yangshangshibai")
    public ModelAndView yangshangshibai(@RequestParam String operation,@RequestParam String state) {
        ArrayList<OperationDto> dtos = new ArrayList<>();

        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        Map<String, List<OperationDto>> dataSource = util.init();

        List<OperationDto> list = dataSource.get(state);
        for (int i = 0; i < list.size(); i++) {
            OperationDto operationDto = list.get(i);
            operationDto.setName(operationMap.get(list.get(i).getCode()));
            operationDto.setUrl("http://localhost:8080/"+list.get(i).getCode()+"?operation="+list.get(i).getCode()+"&state="+operationDto.getTo());
            dtos.add(operationDto);
        }


        view.addObject("state",stateMap.get(state));
        view.addObject("operationList",dtos);

        return view;
    }

    @GetMapping("/lingdaobumanyiduini")
    public ModelAndView lingdaobumanyiduini(@RequestParam String operation,@RequestParam String state) {
        ArrayList<OperationDto> dtos = new ArrayList<>();

        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        Map<String, List<OperationDto>> dataSource = util.init();

        List<OperationDto> list = dataSource.get(state);
        for (int i = 0; i < list.size(); i++) {
            OperationDto operationDto = list.get(i);
            operationDto.setName(operationMap.get(list.get(i).getCode()));
            operationDto.setUrl("http://localhost:8080/"+list.get(i).getCode()+"?operation="+list.get(i).getCode()+"&state="+operationDto.getTo());
            dtos.add(operationDto);
        }


        view.addObject("state",stateMap.get(state));
        view.addObject("operationList",dtos);

        return view;
    }

    @GetMapping("/yangshangchenggonggaixuqiuchenggong")
    public ModelAndView yangshangchenggonggaixuqiuchenggong(@RequestParam String operation,@RequestParam String state) {
        ArrayList<OperationDto> dtos = new ArrayList<>();

        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        Map<String, List<OperationDto>> dataSource = util.init();

        List<OperationDto> list = dataSource.get(state);
        for (int i = 0; i < list.size(); i++) {
            OperationDto operationDto = list.get(i);
            operationDto.setName(operationMap.get(list.get(i).getCode()));
            operationDto.setUrl("http://localhost:8080/"+list.get(i).getCode()+"?operation="+list.get(i).getCode()+"&state="+operationDto.getTo());
            dtos.add(operationDto);
        }


        view.addObject("state",stateMap.get(state));
        view.addObject("operationList",dtos);

        return view;
    }

    @GetMapping("/gaixuqiuchenggong")
    public ModelAndView gaixuqiuchenggong(@RequestParam String operation,@RequestParam String state) {
        ArrayList<OperationDto> dtos = new ArrayList<>();

        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        Map<String, List<OperationDto>> dataSource = util.init();

        List<OperationDto> list = dataSource.get(state);
        for (int i = 0; i < list.size(); i++) {
            OperationDto operationDto = list.get(i);
            operationDto.setName(operationMap.get(list.get(i).getCode()));
            operationDto.setUrl("http://localhost:8080/"+list.get(i).getCode()+"?operation="+list.get(i).getCode()+"&state="+operationDto.getTo());
            dtos.add(operationDto);
        }


        view.addObject("state",stateMap.get(state));
        view.addObject("operationList",dtos);

        return view;
    }

    @GetMapping("/lingdaobumanyi")
    public ModelAndView lingdaobumanyi(@RequestParam String operation,@RequestParam String state) {
        ArrayList<OperationDto> dtos = new ArrayList<>();

        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        Map<String, List<OperationDto>> dataSource = util.init();

        List<OperationDto> list = dataSource.get(state);
        for (int i = 0; i < list.size(); i++) {
            OperationDto operationDto = list.get(i);
            operationDto.setName(operationMap.get(list.get(i).getCode()));
            operationDto.setUrl("http://localhost:8080/"+list.get(i).getCode()+"?operation="+list.get(i).getCode()+"&state="+operationDto.getTo());
            dtos.add(operationDto);
        }


        view.addObject("state",stateMap.get(state));
        view.addObject("operationList",dtos);
        return view;
    }

    @GetMapping("/gaixuqiu")
    public ModelAndView gaixuqiu(@RequestParam String operation,@RequestParam String state) {
        System.out.println("被开发打...");
        ArrayList<OperationDto> dtos = new ArrayList<>();

        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        Map<String, List<OperationDto>> dataSource = util.init();

        List<OperationDto> list = dataSource.get(state);
        for (int i = 0; i < list.size(); i++) {
            OperationDto operationDto = list.get(i);
            operationDto.setName(operationMap.get(list.get(i).getCode()));
            operationDto.setUrl("http://localhost:8080/"+list.get(i).getCode()+"?operation="+list.get(i).getCode()+"&state="+operationDto.getTo());
            dtos.add(operationDto);
        }


        view.addObject("state",stateMap.get(state));
        view.addObject("operationList",dtos);

        return view;
    }

    @GetMapping("/siwang")
    public ModelAndView siwang(@RequestParam String operation,@RequestParam String state) {
        ArrayList<OperationDto> dtos = new ArrayList<>();

        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        Map<String, List<OperationDto>> dataSource = util.init();

        List<OperationDto> list = dataSource.get(state);
        for (int i = 0; i < list.size(); i++) {
            OperationDto operationDto = list.get(i);
            operationDto.setName(operationMap.get(list.get(i).getCode()));
            operationDto.setUrl("http://localhost:8080/"+list.get(i).getCode()+"?operation="+list.get(i).getCode()+"&state="+operationDto.getTo());
            dtos.add(operationDto);
        }


        view.addObject("state",stateMap.get(state));
        view.addObject("operationList",dtos);
        return view;
    }



}
