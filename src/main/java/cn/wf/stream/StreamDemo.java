package cn.wf.stream;

import cn.wf.model.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {

    @Test
    public void streamTest1(){
        List<User> list = new ArrayList<>();
        list.add(new User("wf","18"));

        list.stream().map(User::getName).filter(x -> x.startsWith("w"))
                .collect(Collectors.toList()).forEach(System.out::println);

    }
    @Test
    public void streamTest2(){
        List<User> list = new ArrayList<>();
        list.add(new User("wf","18"));
        list.add(new User("wf1","18"));

        //常用于对集合中每个对象的数字进行累加
        String reduce = list.stream().map(User::getName).filter(x -> x.startsWith("w")).reduce("姓名：", (a, b) -> a + b);
        System.out.println(reduce);

    }
}
