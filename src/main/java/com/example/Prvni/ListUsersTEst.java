package com.example.Prvni;

import java.util.ArrayList;
import java.util.List;

public class ListUsersTEst {
    private  List usersList = new ArrayList<>();

    public ListUsersTEst() {

        this.usersList.add(new UserRestApp("jedna","dfgs",5));
        this.usersList.add(new UserRestApp("dva","erg",6));
        this.usersList.add(new UserRestApp("tri","gsdfg",7));
        this.usersList.add(new UserRestApp("ctiry","eg",8));
        this.usersList.add(new UserRestApp("pet","awdawdaw",9));

    }
    public List getUserList(){

        return usersList;

    }
    public UserRestApp getUsersList(int id) {
        return (UserRestApp) usersList.get(id);
    }

    public String addUserApp(UserRestApp UserRestApp){

        this.usersList.add(UserRestApp);

        return "add";

    }

    public String dellUserApp(int id){

        this.usersList.remove(id);

        return "delete";

    }

    public String update(int id,String name, String surname,int age){
        UserRestApp upUse = (UserRestApp) usersList.get(id);
        ((UserRestApp) usersList.get(id)).update(name,surname,age);

        return "update";

    }

}
