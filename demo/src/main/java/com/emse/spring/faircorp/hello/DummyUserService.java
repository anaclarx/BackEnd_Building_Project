package com.emse.spring.faircorp.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DummyUserService {
    //instancio o service
    private GreetingService greetingService;
    //injeto a dependencia, cria o metodo da classe
    @Autowired
    public DummyUserService(GreetingService greetingService){
        //injecao de dependencia, apenas instancia interface semp precisar inicializar
      this.greetingService = greetingService;
    }

    public void greetAll(){
        int i;
        String[] names=new String[] {"Elodie", "Charles"};
        for(i = 0; i < names.length; i++ ) {
            greetingService.greet(names[i]);
            System.out.println("Hello, " +names[i] + "!");
        }
    }

}
