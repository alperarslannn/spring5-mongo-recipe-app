package guru.springframework.controllers;

import guru.springframework.domain.Recipe;
import guru.springframework.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.ui.Model;
import reactor.core.publisher.Flux;
import static org.mockito.Mockito.*;

/**
 * Created by jt on 6/17/17.
 */
@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@WebFluxTest(IndexController.class)
@Import({ThymeleafAutoConfiguration.class})
public class IndexControllerTest {

    @Autowired
    WebTestClient webTestClient;

    @MockBean
    RecipeService recipeService;

    /*@Mock
    Model model;*/

    /*IndexController controller;*/

    @Before
    public void setUp() throws Exception {
        /*MockitoAnnotations.initMocks(this);

        controller = new IndexController(recipeService);*/
    }

    @Test
    public void testMockMVC() throws Exception {
        /*MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        Recipe recipe = new Recipe();
        when(recipeService.getRecipes()).thenReturn(Flux.just(recipe));

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));*/
        Recipe recipe = new Recipe();
        recipe.setId("1");
        when(recipeService.getRecipes()).thenReturn(Flux.just(recipe));

        webTestClient.get().uri("/index")
            .exchange()
            .expectStatus().isOk()
            .expectBody();
    }

    /*@Test
    public void getIndexPage() throws Exception {
        //given
        Recipe recipe = new Recipe();
        recipe.setId("1");

        Recipe recipe2 = new Recipe();
        recipe.setId("2");

        Set<Recipe> recipes = new HashSet<>();
        recipes.add(recipe);
        recipes.add(recipe2);

        when(recipeService.getRecipes()).thenReturn(Flux.fromIterable(recipes));

        ArgumentCaptor<List<Recipe>> argumentCaptor = ArgumentCaptor.forClass(List.class);

        //whenw
        String viewName = controller.getIndexPage(model);

        //then
        assertEquals("index", viewName);
        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
        List<Recipe> setInController = argumentCaptor.getValue();
        assertEquals(2, setInController.size());
    }*/

}