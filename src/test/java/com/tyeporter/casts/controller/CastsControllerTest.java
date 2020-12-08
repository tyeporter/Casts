package com.tyeporter.casts.controller;

import com.tyeporter.casts.service.CastsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class CastsControllerTest {

    private CastsServiceImpl castsService;
    private CastsController controller;
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.castsService = new CastsServiceImpl();
        this.controller = new CastsController(castsService);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    // =========================================================
    // MockMvc
    // =========================================================

    @Test
    public void testGetHome_ShouldReturnCategoryPage() throws Exception {
        mockMvc.perform(get("/science"))
                .andExpect(status().isOk())
                .andExpect(view().name("category_page"));
    }

    @Test
    public void testGetHealth_ShouldReturnCategoryPage() throws Exception {
        mockMvc.perform(get("/health"))
                .andExpect(status().isOk())
                .andExpect(view().name("category_page"));
    }

    @Test
    public void testGetPolitics_ShouldReturnCategoryPage() throws Exception {
        mockMvc.perform(get("/politics"))
                .andExpect(status().isOk())
                .andExpect(view().name("category_page"));
    }

    @Test
    public void testGetSpirituality_ShouldReturnCategoryPage() throws Exception {
        mockMvc.perform(get("/spirituality"))
                .andExpect(status().isOk())
                .andExpect(view().name("category_page"));
    }

    @Test
    public void testGetSports_ShouldReturnCategoryPage() throws Exception {
        mockMvc.perform(get("/sports"))
                .andExpect(status().isOk())
                .andExpect(view().name("category_page"));
    }

    @Test
    public void testGetRelationships_ShouldReturnCategoryPage() throws Exception {
        mockMvc.perform(get("/relationships"))
                .andExpect(status().isOk())
                .andExpect(view().name("category_page"));
    }

    @Test
    public void testGetSearch_ShouldReturnSearchPage() throws Exception {
        mockMvc.perform(get("/search"))
                .andExpect(status().isOk())
                .andExpect(view().name("search_page"));
    }

    @Test
    public void testGetEpisode_ShouldReturnEpisodePage() throws Exception {
        mockMvc.perform(get("/ep?id=7b9cdb7cd911406cadb78a44a520cccd"))
                .andExpect(status().isOk())
                .andExpect(view().name("episode_page"));
    }

}
