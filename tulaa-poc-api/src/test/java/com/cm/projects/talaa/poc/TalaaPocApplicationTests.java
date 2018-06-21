package com.cm.projects.talaa.poc;

import com.cm.projects.talaa.poc.services.StewardService;
import com.cm.projects.talaa.poc.services.StewardServiceTemplate;
import static org.junit.Assert.assertEquals;
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
        assertEquals("Testing reversing string while maintaining special chars","c,b$a", this.stewardService.reverseString("a,b$c"));
    }
    
    @Test
    public void testTripletArray(){
        int input[] = {3, 1, 4, 6, 5};
        assertEquals("Testing if an array is triplet", true, this.stewardService.isTripletArray(input));
    }
    
    @Test
    public void testCodeBlocks(){
        assertEquals("Test correct order brackets", false, this.stewardService.compileCodeBlock("{{{]"));
    }

}
