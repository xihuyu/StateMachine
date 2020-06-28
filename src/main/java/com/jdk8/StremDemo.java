package com.jdk8;

import com.io.bio.User;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @version V1.0
 * @description: Strem流的demo
 * @author: fenggaopan
 * @date: 2020-06-28 10:40:01
 */
public class StremDemo {
    public static void main(String[] args) throws Exception {

        //1.Stream的条件过滤
        List<User> users = new ArrayList<>();
        User u1 = new User();
        u1.setName("u1");
        u1.setId("01");
        u1.setAge(23);

        User u2 = new User();
        u2.setName("u2");
        u2.setId("02");
        u2.setAge(26);


        User u3 = new User();
        u3.setName("u3");
        u3.setId("02");
        u3.setAge(20);

        users.add(u1);
        users.add(u2);
        users.add(u3);


        List<String> uNames = users
                .stream()
                .filter(user -> user.getAge() > 22)
                .sorted(Comparator.comparing(User::getAge))
                .map(User::getName)
                .collect(Collectors.toList());

        uNames.forEach(e-> {
            System.out.println(e);
        });


        //2.字符串转换为stream
        String[] codes = new String[]{"001", "002"};
        Stream<String> codeStream = Arrays.stream(codes);

        //3.很多类提供了静态方法
        //Stream<String> files = Files.lines(Paths.get("aa.jpg"), Charset.defaultCharset());

        //4.iterater方法，输出偶数
        Stream.iterate(0, n->n+2).limit(51).forEach(System.out::println);

        //5.generate方法，输出10编
        Stream.generate(() -> "Hello Man!").limit(10).forEach(System.out::println);

        //6.10天以后所有的日期
        Stream.iterate(LocalDate.now(), date -> date.plusDays(1)).limit(10).forEach(System.out::println);

        //7.流的基本操作
        /*
        Stream接口中包含许多对流操作的方法，这些方法分别为：
        filter()：对流的元素过滤
        map()：将流的元素映射成另一个类型
        distinct()：去除流中重复的元素
        sorted()：对流的元素排序
        forEach()：对流中的每个元素执行某个操作
        peek()：与forEach()方法效果类似，不同的是，该方法会返回一个新的流，而forEach()无返回
        limit()：截取流中前面几个元素
        skip()：跳过流中前面几个元素
        toArray()：将流转换为数组
        reduce()：对流中的元素归约操作，将每个元素合起来形成一个新的值
        collect()：对流的汇总操作，比如输出成List集合
        anyMatch()：匹配流中的元素，类似的操作还有allMatch()和noneMatch()方法
        findFirst()：查找第一个元素，类似的还有findAny()方法
        max()：求最大值
        min()：求最小值
        count()：求总数
        */

        Stream.of(1, 8, 5, 2, 1, 0, 9, 2, 0, 4, 8)
                .filter(n->n>2)
                .distinct()
                .limit(3)
                .sorted()
                .forEach(System.out::println);

        System.out.println("**************************************************************");
        boolean hasMatch = Stream.of("Java", "C#", "PHP", "C++", "Python")
                .anyMatch(s -> s.equals("Java"));
        System.out.println(hasMatch);

    }
}
