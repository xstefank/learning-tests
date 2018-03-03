package org.xstefank.lt;

import org.eclipse.egit.github.core.PullRequest;
import org.eclipse.egit.github.core.RepositoryId;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.PullRequestService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

@Path("/")
public class StatusEndpoint {

    private static Properties config;

    static {
        InputStream is = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("config.properties");

        config = new Properties();
        try {
            config.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GET
    @Path("/get")
    public String testGet() throws IOException {

        GitHubClient client = new GitHubClient();
        client.setCredentials(config.getProperty("github.user"), config.getProperty("github.password"));

        PullRequestService service = new PullRequestService(client);
        RepositoryId repo = new RepositoryId("xstefank", "test-repo");
        List<PullRequest> open = service.getPullRequests(repo, "open");

        return open.stream().map(pr -> pr.getTitle()).collect(Collectors.toList()).toString();
    }
}
