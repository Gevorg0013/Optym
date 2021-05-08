package jokes;

public class JokeDetailsResponse {

    private long id;

    private String type;

    private String setup;

    private String punchline;

    public long getId() {
        return this.id;
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

    public void setId(final int id) {
        this.id = id;
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
}
