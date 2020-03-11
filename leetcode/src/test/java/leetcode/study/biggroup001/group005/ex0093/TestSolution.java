package leetcode.study.biggroup001.group005.ex0093;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Author : josan
 * @Date : 2020/3/3 0:20
 * @Package : leetcode.study.group005.ex0085
 * @ProjectName: pom-parent
 * @Description:
 */
public class TestSolution {
    @Test
    public void testRestoreIpAddresses() {
        doTestRestoreIpAddresses("25525511135", Arrays.asList("255.255.11.135", "255.255.111.35"));
        doTestRestoreIpAddresses("010010", Arrays.asList("0.10.0.10", "0.100.1.0"));
    }

    private void doTestRestoreIpAddresses(String s, List<String> expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.restoreIpAddresses(s));
    }
}
