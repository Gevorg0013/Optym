package jokes;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class JokeService {

    @Autowired
    private JokeClient jokeClient;

    @Autowired                                                                                         
    private JokeRepo jokeRepo;

    public void generate() {

        boolean added = false;
        int triesCount = 0;
        do {
            ++triesCount;
            final Optional<JokeDetailsResponse> details = this.jokeClient.getJoke();
            if (details.isEmpty()) {
                continue;
            }
            if (jokeRepo.countByJokeId(details.get().getId()) != 0) {
                continue;
            }
            final JokeDetails newJoke = new JokeDetails(details.get());
            newJoke.setCreateTime(ZonedDateTime.now().toEpochSecond());
            this.jokeRepo.save(newJoke);
            added = true;
        } while (!added && triesCount != 100);
    }

    public List<JokeDetails> getByType(final String type) {
        final List<JokeDetails> result = this.jokeRepo.findByType(type);
        System.out.println("Count of jokes: " + result.size());
        return result;
    }

    public List<JokeDetails> getAll() {
        return this.jokeRepo.findAll();
    }

    public List<JokeDetails> findByPunchlineLikeOrSetupLike(final String pattern) {
        return this.jokeRepo.findByPunchlineLikeOrSetupLike(pattern, pattern);
    }

    public List<JokeDetails> findBySetupOrPunchline(final String key) {
        return this.jokeRepo.findBySetupOrPunchline(key, key);
    }

    @Scheduled(fixedDelay = 80000)
    public void generateRunReport() {

        System.out.println("Scheduler startes execution: " + ZonedDateTime.now());
        this.generate();
        System.out.println("Scheduler ends the execution: " + ZonedDateTime.now());
    }
}
