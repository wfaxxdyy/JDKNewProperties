package cn.wf.stream;

import cn.wf.model.Order;
import cn.wf.model.User;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class StreamDemo1 {

    @Test
    public void streamTest1() {
        List<User> list = new ArrayList<>();
        list.add(new User("wf", "18"));

        list.stream().map(User::getName).filter(x -> x.startsWith("w"))
                .collect(Collectors.toList()).forEach(System.out::println);

    }

    @Test
    public void streamTest2() {
        List<User> list = new ArrayList<>();
        list.add(new User("wf", "18"));
        list.add(new User("wf1", "18"));

        //常用于对集合中每个对象的数字进行累加
        String reduce = list.stream().map(User::getName).filter(x -> x.startsWith("w")).reduce("姓名：", (a, b) -> a + b);
        System.out.println(reduce);

    }

    @Test
    public void streamTest3() throws InterruptedException {

        List<Order> list = new ArrayList<>();
        list.add(new Order("1", "衣服", new Date()));
        Thread.sleep(500);
        list.add(new Order("1", "衣服", new Date()));
        Thread.sleep(500);
        list.add(new Order("1", "鞋子", new Date()));
        Thread.sleep(500);
        list.add(new Order("1", "帽子", new Date()));
        Thread.sleep(500);
        list.add(new Order("1", "鞋子", new Date()));
        Thread.sleep(500);
        list.add(new Order("1", "毛巾", new Date()));
        Thread.sleep(500);
        list.add(new Order("2", "衣服", new Date()));
        Thread.sleep(500);
        list.add(new Order("3", "鞋子", new Date()));
        Thread.sleep(500);
        list.add(new Order("2", "帽子", new Date()));
        Thread.sleep(500);
        list.add(new Order("1", "毛巾", new Date()));
        Thread.sleep(500);
        list.add(new Order("3", "衣服", new Date()));
        Thread.sleep(500);
        list.add(new Order("2", "鞋子", new Date()));
        Thread.sleep(500);
        list.add(new Order("3", "帽子", new Date()));
        Thread.sleep(500);
        list.add(new Order("4", "毛巾", new Date()));

        Map<String, List<Order>> collect = list.stream()
                .collect(Collectors.groupingBy(x -> x.getAccountid() + x.getGoodtype()));

        collect.forEach(
                (x, y) -> {
                    y.stream().sorted(Comparator.comparing(Order::getTime)).forEach(System.out::println);
                }
        );

    }
}
