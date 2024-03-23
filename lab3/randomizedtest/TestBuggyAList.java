package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> stable = new AListNoResizing<>();
        BuggyAList<Integer> unstable = new BuggyAList<>();

        stable.addLast(3);
        unstable.addLast(3);
        stable.addLast(5);
        unstable.addLast(5);
        stable.addLast(7);
        unstable.addLast(7);

        assertEquals(stable.removeLast(), unstable.removeLast());
        assertEquals(stable.removeLast(), unstable.removeLast());
        assertEquals(stable.removeLast(), unstable.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> BL = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                BL.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int Bsize = BL.size();
                assertEquals(size, Bsize);
            } else if (L.size() != 0) {
                if (operationNumber == 2) {
                    int last = L.getLast();
                    int Blast = BL.getLast();  // a cool name
                    assertEquals(last, Blast);
                } else if (operationNumber == 3) {
                    int removed = L.removeLast();
                    int Bremoved = BL.removeLast();
                    assertEquals(removed, Bremoved);
                }
            }
        }
    }
}
