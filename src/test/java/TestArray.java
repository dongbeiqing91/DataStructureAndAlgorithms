import org.junit.Test;

/**
 * @author Bei
 * @date 2022/4/23
 */
public class TestArray {

    @Test
    public void Test1() {
        String[] strArray = {"1", "2", "3"};
        TestArray testArray = new TestArray();
        testArray.ReplaceArrayItem(strArray);
        System.out.println(strArray[0]);
    }

    private void ReplaceArrayItem(String[] strArray) {
        strArray[0] = "4";
    }
}
