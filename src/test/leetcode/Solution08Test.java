package test.leetcode; 

import leetcode.Solution08;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import static org.junit.Assert.assertEquals;

/** 
* Solution08 Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 7, 2017</pre> 
* @version 1.0 
*/ 
public class Solution08Test {
    Solution08 solution08 = new Solution08();
@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: myAtoi(String str) 
* 
*/ 
@Test
public void testMyAtoi() throws Exception { 
//TODO: Test goes here...
    assertEquals(solution08.myAtoi("9223372036854775809"), 2147483647);
}

@Test
public void testMyAtoi2() throws Exception {
    assertEquals(solution08.myAtoi2("-2147483650"),  -2147483648);
}


} 
