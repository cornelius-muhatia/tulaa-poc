package com.cm.projects.talaa.poc;

import com.cm.projects.talaa.poc.services.StewardService;
import com.cm.projects.talaa.poc.services.StewardServiceTemplate;
import static org.junit.Assert.assertSame;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TalaaPocApplicationTests {
    
    private StewardService stewardService;
    
     @Before
    public void setUp() {
        this.stewardService = new StewardServiceTemplate();
    }

    @Test
    public void testReverseString() {
        assertSame("Testing reversing string while maintaining special chars", "a,b$c", this.stewardService.reverseString("a,b$c"));
    }

}
