package pk.error_found.com.retrofitapp;

/**
 * Created by user on 27/7/17.
 */

class GitHubRepo {

    private String name;
    private int id;

    public GitHubRepo(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
