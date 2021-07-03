package com.ISIS.KRMEFClinicSpring;

import com.ISIS.KRMEFClinicSpring.Model.User;
import com.ISIS.KRMEFClinicSpring.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String...args) throws Exception {
        Date date= new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1992");
        User admin = new User(1,"admin,","manager",date,"F","admin","U2FsdGVkX1+7okVvUvXxaKlD3TmOJZBe1D5vGIT6oTg=",true);
        userRepository.save(admin);
    }
}
