package Projects.proj1b.tests;

import Projects.proj1b.src.ArrayDeque;
import jh61b.utils.Reflection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class ArrayDequeTest {

    // @Test
    // @DisplayName("ArrayDeque has no fields besides backing array and primitives")
    // void noNonTrivialFields() {
    //     List<Field> badFields = Reflection.getFields(ArrayDeque.class)
    //             .filter(f -> !(f.getType().isPrimitive() || f.getType().equals(Object[].class) || f.isSynthetic()))
    //             .toList();

    //     assertWithMessage("Found fields that are not array or primitives").that(badFields).isEmpty();
    // }

    @Test
    void testAddFirstLastGet() {
        ArrayDeque test = new ArrayDeque();
        for (int x = 0; x < 9; x++) {
            test.addFirst(x);
            test.addLast(x);
        }
        assertThat(test.get(0)).isEqualTo(8);
        assertThat(test.get(9)).isEqualTo(0);
        assertThat(test.get(10)).isEqualTo(1);
        System.out.println(test.get(0));
    }

    @Test
    void removeLast() {
//        ArrayDeque test = new ArrayDeque();
//        for (int x = 0; x < 9; x++) {
//            test.addFirst(x);
//            test.addLast(x);
//        }
//        assertThat(test.get(0)).isEqualTo(8);
//        assertThat(test.get(9)).isEqualTo(0);
//        assertThat(test.get(10)).isEqualTo(1);
//        System.out.println(test.get(0));
    }



}
