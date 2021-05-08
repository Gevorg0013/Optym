package jokes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jokes")
public class JokeController {

    @Autowired
    private JokeService jokeService;

    @GetMapping("/by-types")
    public ResponseEntity getByTypes(@RequestParam String type) {
        return ResponseEntity.ok(this.jokeService.getByType(type));
    }

    @GetMapping("/byalltypes")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(this.jokeService.getAll());
    }
}
