package bingfashixian.sanduixianggongxiang;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dell on 2017/3/3.
 */
public class ThreeStooges {
    private final Set<String> stooge=new HashSet<>();
    ThreeStooges(){
        stooge.add("MOE");
        stooge.add("LArry");
        stooge.add("Cure");
    }

    public boolean isStooge(String name){
        return stooge.contains(name);
    }
}
