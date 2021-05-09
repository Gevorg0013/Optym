package jokes;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JokeRepo extends MongoRepository<JokeDetails, String> {

    public List<JokeDetails> findByTypeOrderByCreateTimeDesc(final String type);

    public List<JokeDetails> findByPunchlineLikeOrSetupLikeOrderByCreateTimeDesc(final String puchline, final String setup);

    public List<JokeDetails> findBySetupOrPunchlineOrderByCreateTimeDesc(final String punchline, final String setup);

    public long countByJokeId(final long jokeId);

    public List<JokeDetails> findByType(String type);

    public List<JokeDetails> findByPunchlineLikeOrSetupLike(String pattern, String pattern0);

    public List<JokeDetails> findBySetupOrPunchline(String key, String key0);
}
