package jokes;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JokeRepo extends MongoRepository<JokeDetails, String> {

    public List<JokeDetails> findByType(final String type);

    public long countByJokeId(final long jokeId);
}
