package spittrz.web;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;
import spittrz.Spittle;
import spittrz.data.SpittleRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class SpittleControllerTest {
    @Test
    public void shouldShowRecentSpittles() throws Exception {
        List<Spittle> expectedSpittles = createSpittleList(20);
        SpittleRepository repository = Mockito.mock(SpittleRepository.class);
        Mockito.when(repository.findSpittles(Long.MAX_VALUE, 20)).thenReturn(expectedSpittles);

        SpittleController controller = new SpittleController(repository);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp")).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/spittles"))
                .andExpect(MockMvcResultMatchers.view().name("spittles"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("spittleList"));

    }

    @Test
    public void shouldShowPagedSpittles() throws Exception {
        List<Spittle> expectedSpittles = createSpittleList(50);
        SpittleRepository repository = Mockito.mock(SpittleRepository.class);
        Mockito.when(repository.findSpittles(1024, 50)).thenReturn(expectedSpittles);

        SpittleController spittleController = new SpittleController(repository);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(spittleController).setSingleView(new InternalResourceView
                ("/WEB-INF/views/spittles.jsp")).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/spittles?max=1024&count=50")).andExpect(MockMvcResultMatchers
                .view().name("spittles")).andExpect(MockMvcResultMatchers.model().attributeExists("spittleList"))
                .andExpect(MockMvcResultMatchers.model().attribute("spittleList",Matchers.hasItems(expectedSpittles
                        .toArray())));
    }

    @Test
    public void testSpittle() throws Exception {
        Spittle expectSpittle = new Spittle("Hello", new Date());
        SpittleRepository repository = Mockito.mock(SpittleRepository.class);
        Mockito.when(repository.findOne(1234L)).thenReturn(expectSpittle);

        SpittleController spittleController = new SpittleController(repository);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(spittleController).setSingleView(new InternalResourceView
                ("/WEB-INF/views/spittles.jsp")).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/spittles/1234")).andExpect(MockMvcResultMatchers.view().name
                ("spittle")).andExpect(MockMvcResultMatchers.model().attributeExists("spittle")).andExpect
                (MockMvcResultMatchers.model().attribute("spittle", expectSpittle));
    }

    private List<Spittle> createSpittleList(int count) {
        List<Spittle> spittles = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle("Spittle " + i, new Date()));
        }
        return spittles;
    }
}
