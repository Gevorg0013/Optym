package jokes;

import io.vavr.control.Try;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JokeClient {


    @Autowired
    private RestTemplate restTemplate;

    private static final String JOKE_API = "https://official-joke-api.appspot.com/jokes/random";

    public Optional<JokeDetailsResponse> getJoke() {

        final Try<JokeDetailsResponse> response = Try.of(()
                -> this.restTemplate.getForObject(JOKE_API, JokeDetailsResponse.class));

        if (!response.isSuccess()) {
            System.err.println("Couldn't get joke details!");
            return Optional.empty();
        }

        return Optional.of(response.get());
    }
}