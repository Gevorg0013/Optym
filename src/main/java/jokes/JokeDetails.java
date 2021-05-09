package jokes;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "joke_db")
public class JokeDetails {

    public JokeDetails() {
    }

    public JokeDetails(final JokeDetailsResponse response) {
        this.id = null;
        this.jokeId = response.getId();
        this.punchline = response.getPunchline();
        this.setup = response.getSetup();
        this.type = response.getType();
    }

    private String id;

    private long jokeId;

    private String type;

    private String setup;

    private String punchline;

    private long createTime;

    public String getId() {
        return this.id;
    }

    public long getJokeId() {
        return this.jokeId;
    }

    public String getType() {
        return this.type;
    }

    public String getSetup() {
        return this.setup;
    }

    public String getPunchline() {
        return this.punchline;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setJokeId(final int id) {
        this.jokeId = id;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public void setSetup(final String setup) {
        this.setup = setup;
    }

    public void setPunchline(final String punchline) {
        this.punchline = punchline;
    }

    public void setCreateTime(final long createTime) {
        this.createTime = createTime;
    }
}
