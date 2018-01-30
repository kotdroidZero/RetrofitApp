package pk.error_found.com.retrofitapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by user on 27/7/17.
 */

public interface API {

    //githubRepoUrl="users/{user}/repos"
    //where { } shows the replacement means its value is defined in method parameter
    // like here user is defined in repoForUser method in Path annotation

    @GET(Constants.GITHUB_REPO_URL)
    Call<List<Example>> repoForUser(@Path("user") String user);

    
   /* @GET(Constants.GITHUB_REPO_URL)
    Call<List<Example>> repoForUser(@("user") String user);*/







}
