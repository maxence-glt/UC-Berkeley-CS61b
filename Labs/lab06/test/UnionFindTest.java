package Labs.lab06.test;

import Labs.lab06.src.UnionFind;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;
import static org.junit.Assert.fail;

public class UnionFindTest {

    /**
     * Checks that the initial state of the disjoint sets are correct (this will pass with the skeleton
     * code, but ensure it still passes after all parts are implemented).
     */
    @Test
    public void test1() {
        UnionFind uf = new UnionFind(4);
        assertThat(uf.connected(0, 1)).isFalse();
        assertThat(uf.connected(0, 2)).isFalse();
        assertThat(uf.connected(0, 3)).isFalse();
        assertThat(uf.connected(1, 2)).isFalse();
        assertThat(uf.connected(1, 3)).isFalse();
        assertThat(uf.connected(2, 3)).isFalse();
    }

    /**
     * Checks that invalid inputs are handled correctly.
     */
    @Test
    public void test2() {
        UnionFind uf = new UnionFind(4);
        try {
            uf.find(10);
            fail("Cannot find an out of range vertex!");
        } catch (IllegalArgumentException e) {
            return;
        }
        try {
            uf.union(1, 10);
            fail("Cannot union with an out of range vertex!");
        } catch (IllegalArgumentException e) {
            return;
        }
    }

    /**
     * Checks that that union is done correctly (including the tie-breaking scheme).
     */
    @Test
    public void test3() {
        UnionFind uf = new UnionFind(10);
        uf.union(0, 1);
        assertThat(uf.find(0)).isEqualTo(1);
        uf.union(2, 3);
        assertThat(uf.find(2)).isEqualTo(3);
        uf.union(0, 2);
        assertThat(uf.find(1)).isEqualTo(3);

        uf.union(4, 5);
        uf.union(6, 7);
        uf.union(8, 9);
        uf.union(4, 8);
        uf.union(4, 6);

        assertThat(uf.find(5)).isEqualTo(9);
        assertThat(uf.find(7)).isEqualTo(9);
        assertThat(uf.find(8)).isEqualTo(9);

        uf.union(9, 2);
        assertThat(uf.find(3)).isEqualTo(9);
    }

    /**
     * Unions the same item with itself. Calls on find and checks that the outputs are correct.
     */
    @Test
    public void test4() {
        UnionFind uf = new UnionFind(4);
        uf.union(1, 1);
        for (int i = 0; i < 4; i += 1) {
            assertThat(uf.find(i)).isEqualTo(i);
        }
    }

    // own tests
    @Test
    public void test5 () {
        //TODO IF YOU USE THIS TEST YOU MUST UNCOMMENT OUT THE LAST 3 LINES IN UNION
        // this is because the lab specs and lab examples use different Union tiebreaks

        int[] testData = {-4, 0, 0, 2, -1};
        UnionFind uf = new UnionFind(5);
        uf.union(0, 1);
        uf.union(2, 3);
        uf.union(0, 2);

        assertThat(uf.returnData()).isEqualTo(testData);

        int[] testData2 = {5, 0, 0, 2, -1, -9, 5, 5, 7, 5};
        UnionFind uf2 = new UnionFind(10);
        uf2.union(0, 1);
        uf2.union(2, 3);
        uf2.union(0, 2);
        uf2.union(5, 6);
        uf2.union(7, 8);
        uf2.union(5, 8);
        uf2.union(5, 9);
        uf2.union(7, 2);

        assertThat(uf2.returnData()).isEqualTo(testData2);
        assertThat(uf2.connected(3, 8)).isTrue();
    }

    @Test
    public void test6() {
        int[] testWeightedData = {1, -6, 1, 1, 1, 1};
        UnionFind weighted_uf = new UnionFind(5);

        weighted_uf.union(0, 1);
        weighted_uf.union(2, 1);
        weighted_uf.union(3, 2);
        weighted_uf.union(4, 3);
        weighted_uf.union(5, 4);

        assertThat(weighted_uf.returnData()).isEqualTo(testWeightedData);
    }
}


