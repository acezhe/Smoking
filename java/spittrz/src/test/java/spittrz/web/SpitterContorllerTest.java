package spittrz.web;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.verification.VerificationMode;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import spittrz.Spitter;
import spittrz.data.SpitterRepository;

import static org.junit.Assert.*;

public class SpitterContorllerTest {

    @Test
    public void testShowRegistrationForm() throws Exception {
        SpitterRepository spitterRepository = Mockito.mock(SpitterRepository.class);


        SpitterContorller spitterContorller = new SpitterContorller(spitterRepository);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(spitterContorller).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/spitter/register")).andExpect(MockMvcResultMatchers.view().name
                ("registerForm"));
    }

    @Test
    public void testProcessRegistration() throws Exception {
        Spitter unsaved = new Spitter("zhangzhe", "password", "zhang", "zhe", "zhangzhe@qq.com");
        Spitter saved = new Spitter(1L, "zhangzhe", "password", "zhang", "zhe", "zhangzhe@qq.com");

        SpitterRepository spitterRepository = Mockito.mock(SpitterRepository.class);
        Mockito.when(spitterRepository.save(unsaved)).thenReturn(saved);

        SpitterContorller spitterContorller = new SpitterContorller(spitterRepository);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(spitterContorller).build();
        mockMvc.perform(MockMvcRequestBuilders.post("/spitter/register").param("username", "zhangzhe").param
                ("password", "password").param("firstName", "zhang").param("lastName", "zhe").param("email",
                "zhangzhe@qq.com")).andExpect(MockMvcResultMatchers.redirectedUrl("/spitter/zhangzhe"));
        Mockito.verify(spitterRepository, Mockito.atLeastOnce()).save(unsaved);
    }

    @Test
    public void testShowSpitterProfile() throws Exception {
        Spitter expectSpitter = new Spitter(1L, "zhangzhe", "password", "zhang", "zhe", "zhangzhe@qq.com");
        SpitterRepository spitterRepository = Mockito.mock(SpitterRepository.class);
        Mockito.when(spitterRepository.findByUsername("zhangzhe")).thenReturn(expectSpitter);

        SpitterContorller contorller = new SpitterContorller(spitterRepository);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(contorller).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/spitter/zhangzhe")).andExpect(MockMvcResultMatchers.view().name
                ("profile")).andExpect(MockMvcResultMatchers.model().attributeExists("spitter")).andExpect
                (MockMvcResultMatchers.model().attribute("spitter", expectSpitter));
    }
}