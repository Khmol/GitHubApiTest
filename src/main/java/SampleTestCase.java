import models.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class SampleTestCase {
    private RestTemplate restTemplate;
    private final String API_BASE = "https://api.github.com";
    @Before
    public void setUp(){
        restTemplate = new RestTemplate();
    }

    @Test
    public void testUserInfoResponse(){
        User user = restTemplate.getForObject(API_BASE + "/users/Khmol", User.class);
        Assert.assertTrue(user.getHtml_url().contains("https://github.com/Khmol"));
    }

    @Test
    public void testUserFollower(){
        User[] user = restTemplate.getForObject(API_BASE + "/users/Khmol/followers", User[].class);
        Assert.assertTrue(user.length == 0);
    }
}
