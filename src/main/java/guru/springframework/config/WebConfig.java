package guru.springframework.config;

import guru.springframework.domain.Recipe;
import guru.springframework.services.RecipeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration
public class WebConfig
{
    @Bean
    public RouterFunction<ServerResponse> routes(RecipeService recipeService){
        return RouterFunctions.route(GET("/api/recipes"),
            serverRequest -> ServerResponse.ok()
                .body(recipeService.getRecipes(), Recipe.class)
        );
    }
}
