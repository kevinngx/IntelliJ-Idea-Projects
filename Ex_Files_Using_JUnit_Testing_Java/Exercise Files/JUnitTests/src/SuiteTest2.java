import org.junit.Test;

import static junit.framework.TestCase.assertNull;

public class SuiteTest2 {

    @Test
    public void soulExists() throws Exception {
        Pshycic blair = new Pshycic();
        String person = "Kevin";
        Soul soul  = blair.findSoul(person);
        assertNull(soul);
    }

}






