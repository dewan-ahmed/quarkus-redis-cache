package org.acme.cache;

import java.net.http.HttpClient;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.net.http.HttpResponse.BodyHandlers;
import java.io.IOException;
import java.net.URI;

import javax.enterprise.context.ApplicationScoped;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import io.quarkus.cache.CacheResult;

@ApplicationScoped
public class GithubStarsService {

    @CacheResult(cacheName = "github-cache")
    public int getStarsCountForRepo(String user, String repo) {
        int numOfStars = 0;
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        numOfStars = makeGithubAPIcall(user, repo);
        return numOfStars;

    }

    private static int makeGithubAPIcall(String user, String repo) {
        String apiURI = "https://api.github.com/repos/" + user + "/" + repo;
        int result = 0;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiURI))
                .build();

        try {
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            result = stringToJSON(response.body());
            return result;

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    private static int stringToJSON(String inputString) {

        JSONParser parser = new JSONParser();
        JSONObject json;
        String stargazersCount;
        try {
            json = (JSONObject) parser.parse(inputString);
            stargazersCount = json.get("stargazers_count").toString();
            return stringToInt(stargazersCount);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }

    private static int stringToInt(String input) {
        return Integer.parseInt(input);
    }
}