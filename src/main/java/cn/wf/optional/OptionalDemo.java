package cn.wf.optional;


import cn.wf.model.User;
import org.junit.Test;

import java.util.Optional;

public class OptionalDemo {

    /**
     * 创建Optional对象 -- of方法
     */
    @Test
    public void optionalTest1() {
        User user = new User("wf", "18");
        Optional<String> name = Optional.of(user.getName());
        if (name.isPresent()) {
            System.out.println(Optional.of(user.getName()).get());
        }

    }

    /**
     * 创建Optional对象 -- of方法
     */
    @Test
    public void optionalTest2() {
        User user = new User(null, "18");
        Optional<String> name = Optional.ofNullable(user.getName());
        if (name.isPresent()) {
            System.out.println(Optional.of(user.getName()).get());
        } else {
            name.orElseThrow(() -> new RuntimeException("出错了。。。"));
        }
    }

    /**
     * ofNullable方法(重要)，解决NullPointerException
     */
    @Test
    public void optionalTest3() {
        User user = new User(null, "18");
        System.out.println(Optional.ofNullable(user.getName()).orElse("wf"));
    }

    /**
     * map方法
     */
    @Test
    public void optionalTes4() {
        User user = null;
        System.out.println(Optional.ofNullable(user).map(User::getName).orElse("wf"));
    }

    /**
     * filter方法
     */
    @Test
    public void optionalTes5() {
        User user = new User("wf", "18");
        System.out.println(Optional.ofNullable(user).map(User::getName).filter(u -> u != "wf").orElse("wf1"));
    }


}
