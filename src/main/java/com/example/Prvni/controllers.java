package com.example.Prvni;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class controllers {


    @GetMapping("/getUser")
    public UserRestApp getUser(@RequestParam(name="id", defaultValue = "0")int id){


     ListUsersTEst testUser = new ListUsersTEst();

    return testUser.getUsersList(id);

    }

    @PostMapping("/create")
    public UserRestApp createUser(@RequestParam(name="name")String name,@RequestParam(name="surname")String surname,@RequestParam(name="age")int age){
        UserRestApp createUser = new UserRestApp(name,surname,age);

        return createUser;

    }

    @PutMapping("/update")
    public UserRestApp updateUser(@RequestParam(name="id")int id,@RequestParam(name="name")String name,
                                  @RequestParam(name="surname")String surname,@RequestParam(name="age")int age){
        ListUsersTEst testUser = new ListUsersTEst();
        testUser.update(id,name,surname,age);

        return testUser.getUsersList(id);
    }

    @DeleteMapping("/delete")
    public List<UserRestApp> deleteUser(@RequestParam(name="id")int id){

        ListUsersTEst testUser = new ListUsersTEst();
        testUser.dellUserApp(id);
        return testUser.getUserList();
    }


}
