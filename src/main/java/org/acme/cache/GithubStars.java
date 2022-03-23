package org.acme.cache;

public class GithubStars {

    private int stars;

    private long executionTimeInMs;

    public GithubStars(int stars, long executionTimeInMs) {
        this.stars = stars;
        this.executionTimeInMs = executionTimeInMs;
    }

    public int getStars() {
        return stars;
    }

    public long getExecutionTimeInMs() {
        return executionTimeInMs;
    }
}