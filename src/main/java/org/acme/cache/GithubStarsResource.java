package org.acme.cache;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.jboss.resteasy.annotations.jaxrs.QueryParam;

@Path("/stars")
public class GithubStarsResource {

    @Inject
    GithubStarsService service;

    @GET
    public GithubStars getStarsCount(@QueryParam String user, @QueryParam String repo) { 
        long executionStart = System.currentTimeMillis();
        int starsCount = service.getStarsCountForRepo(user, repo);
        long executionEnd = System.currentTimeMillis();
        return new GithubStars(starsCount, executionEnd - executionStart);
    }
}