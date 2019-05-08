import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SuiteTest1 {

    @Test
    public void printTest() throws Exception {
        PrintGrades pg = new PrintGrades();
        int myAssignmentMark = 98;
        String result = pg.print(myAssignmentMark);
        assertEquals("You got an A!", result);
    }

}



