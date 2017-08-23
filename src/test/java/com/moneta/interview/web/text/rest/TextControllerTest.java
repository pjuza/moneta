package com.moneta.interview.web.text.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.moneta.interview.web.WebApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


/**
 * Test suite for {@link TextController}.
 *
 * @author Petr Juza
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplication.class)
@AutoConfigureMockMvc
public class TextControllerTest {

    @Autowired
    private MockMvc mvc;

	@Test
	public void testTransform() throws Exception {
        mvc.perform(post(TextController.URI + "/transform").content("abc"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN_VALUE))
                .andExpect(content().string("Cba"));
    }
}