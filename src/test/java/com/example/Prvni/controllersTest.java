package com.example.Prvni;

import org.apache.tomcat.util.json.JSONParser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.logging.ConsoleHandler;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers.class)
class controllersTest {


    @Autowired
    private MockMvc mvc;
    @Test
    void getUser() throws Exception {
        int id = 2;
        ListUsersTEst testUser = new ListUsersTEst();
        RequestBuilder request = MockMvcRequestBuilders.get("/user/getUser?id=2").contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mvc.perform(request).andReturn();

        String test="{\"name\":\""+testUser.getUsersList(id).getName()+"\",\"surname\":\"" + testUser.getUsersList(id).getSurname()+
                "\",\"age\":"+testUser.getUsersList(id).getAge()+"}";

        assertEquals(test,result.getResponse().getContentAsString());

    }

    @Test
    void createUser() throws Exception {
        UserRestApp testUser = new UserRestApp("test","testPrijmeni",2);
        RequestBuilder request = MockMvcRequestBuilders.post("/user/create?name=test&surname=testPrijmeni&age=2");
        MvcResult result = mvc.perform(request).andReturn();

        String test="{\"name\":\""+testUser.getName()+"\",\"surname\":\"" + testUser.getSurname()+
                "\",\"age\":"+testUser.getAge()+"}";

        assertEquals(test,result.getResponse().getContentAsString());
    }

    @Test
    void updateUser() throws Exception {



        RequestBuilder request = MockMvcRequestBuilders.put("/user/update?id=1&name=test&surname=testPrijmeni&age=2");
        MvcResult result = mvc.perform(request).andReturn();

        //String test="{\"name\":\""+testUser.getName()+"\",\"surname\":\"" + testUser.getSurname()+
          //      "\",\"age\":"+testUser.getAge()+"}";

        //assertEquals(test,result.getResponse().getContentAsString());

        String test="{\"name\":\"test\",\"surname\":\"testPrijmeni" +
                "\",\"age\":2}";

        assertEquals(test,result.getResponse().getContentAsString());


    }

    @Test
    void deleteUser() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.delete("/user/delete?id=1");
        MvcResult result = mvc.perform(request).andReturn();
        String test="[{\"name\":\"jedna\",\"surname\":\"dfgs\",\"age\":5},{\"name\":\"tri\"," +
                "\"surname\":\"gsdfg\",\"age\":7},{\"name\":\"ctiry\",\"surname\":\"eg\",\"age\":8},{\"name\":\"pet\",\"surname\":\"awdawdaw\",\"age\":9}]";
        assertEquals(test,result.getResponse().getContentAsString());
    }
}