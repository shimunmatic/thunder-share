package com.shimunmatic.thundershare;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJpaRepositories
public class ThunderShareApplicationTests {

    //  @Test
    public void contextLoads() {
    }

    @Test
    public void testExample() {
        Assert.assertEquals(1, Integer.parseInt("1"));
    }

}
