package com.example.crmtestexample.apidoc.loggerMenu;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@AutoConfigureRestDocs
public class loggerMenuTest {

    @Autowired
    private MockMvc mockMvc;

    @Rule
    public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation();

    @Transactional
    @Test
    public void logger_structure_test() throws Exception{
        mockMvc.perform(post("/loggerMenu/checkStructure")
            .content(loggerStructureTest())
            .accept(MediaType.APPLICATION_JSON))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andDo(document("loggerStructureTest",
                    responseFields(
                            fieldWithPath("data").description("data"),
                            fieldWithPath("status").description("SUCCESS"),
                            fieldWithPath("msg").description("msg"),
                            fieldWithPath("processCnt").description("count")
                    )));

    }


    /***
     * Test Mock Data setting
     * */
    String loggerStructureTest() throws JSONException{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",5899);
        jsonObject.put("status","SUCCESS");
        jsonObject.put("msg" , "structure test");
        jsonObject.put("processCnt",0);

        String jsonBody = jsonObject.toString();

        return jsonBody;
    }

}
