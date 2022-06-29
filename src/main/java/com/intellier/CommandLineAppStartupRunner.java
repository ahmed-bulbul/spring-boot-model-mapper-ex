package com.intellier;

import com.intellier.setup.AppDefaultUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineAppStartupRunner  implements CommandLineRunner {

    @Autowired
    AppDefaultUserService defaultUserService;


    @Override
    public void run(String... args) throws Exception {
        System.out.println("---->CommandLineAppStartupRunner----->");
        this.defaultUserService.createUser();
        this.defaultUserService.createBook();
        this.defaultUserService.createPost();
        this.defaultUserService.createComment();
    }
}