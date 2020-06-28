package com.jdk8;

import com.io.bio.User;

import java.util.Optional;

/**
 * @version V1.0
 * @description: java8中的optional
 * @author: fenggaopan
 * @date: 2020-06-28 10:35:04
 */
public class OptionalDemo {

    public static void main(String[] args) {
        //1.创建一个空的
        Optional<String> code = Optional.empty();
        System.out.println(code.isPresent());

        //2.赋值空
        Optional<String> code2 = Optional.ofNullable(null);
        System.out.println(code2.isPresent());

        //3.对象赋值



        System.out.println("=========================================================");
        String str = "Hello World";
        Optional<String> strOpt = Optional.of(str);
        strOpt = Optional.ofNullable(null);
        String orElseResult = strOpt.orElse("Hello Shanghai");
        System.out.println(orElseResult);
        strOpt = Optional.ofNullable(null);
        String orElseGet = strOpt.orElseGet(() -> "Hello Shanghai");
        System.out.println(orElseGet);
        strOpt = Optional.ofNullable(null);

        try {
            String orElseThrow = strOpt.orElseThrow(
                    () -> new IllegalArgumentException("Argument 'str' cannot be null or blank."));
            System.out.println(orElseThrow);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(getUser());
    }

    public static User getUser() {
        User user = new User();
        user.setId("001");
        user.setName("xxx");
        Optional<User> userOptional = Optional.of(user);
        return userOptional.filter(user1-> user.getName().equals("xxx")).orElse(null);
    }
}
