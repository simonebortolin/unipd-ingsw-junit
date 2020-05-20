import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class TargetTest {

    Class targetClass = ObjectAdapter.class;
    Target<Integer> target;

    @org.junit.Before
    public void setTargetInstance() {

        try {
            target = (Target<Integer>) Arrays.stream(targetClass.getConstructors()).filter(i -> i.getParameterCount() == 0).findFirst().get().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | ClassCastException e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void empty() {
        assertTrue(target.empty());
        target.push(10);
        assertFalse(target.empty());
        target.peek();
        assertFalse(target.empty());
        target.pop();
        assertTrue(target.empty());
    }

    @org.junit.Test(expected = EmptyStackException.class)
    public void peekEmpty() {
        target.peek();
    }

    @org.junit.Test
    public void peek() {
        int[] arr = new int[]{10, 20, 40, 60, 80, 100, 20, 1, 4, 3};
        for (int item : arr) {
            target.push(item);
            assertEquals(target.peek(), (Integer) item);
        }
        int last = arr.length -1;
        while (!target.empty()) {
            assertEquals(target.pop(), (Integer) arr[last--]);
        }
    }

    @org.junit.Test(expected = EmptyStackException.class)
    public void popEmpty() {
        target.peek();
    }

    @org.junit.Test
    public void pop() {
        int[] arr = new int[]{5,6,10,4,3,2,5,4,32,2,45,3,1,3,4,3};
        for (int item : arr) {
            target.push(item);
            assertEquals(target.peek(), (Integer) item);
            assertEquals(target.pop(), (Integer) item);
            assertTrue(target.empty());
        }
    }

    @org.junit.Test
    public void push() {
        int[] arr = new int[]{7,11,-10,3,4,3,2,4,3,2,3,4,3,30,10,-11,34,-33};
        for (int item : reverse(arr)) {
            target.push(item);
            assertEquals(target.peek(), (Integer) item);
            assertFalse(target.empty());
        }
        for (int item : arr) {
            assertEquals(target.pop(), (Integer) item);
        }
    }

    @org.junit.Test
    public void search() {
        int[] arr = new int[]{66,-55,44,33,55,33,43,22};
        assertEquals(target.search((Integer) 66), -1);
        assertEquals(target.search((Integer) 55), -1);

        for(int item : arr) {
            target.push((Integer) item);
            assertEquals(target.search((Integer) item), 1);
            assertFalse(target.empty());

        }

        assertEquals(target.search((Integer) 22), 1);
        assertEquals(target.search((Integer) 43), 2);
        assertEquals(target.search((Integer) 33), 3);
        assertEquals(target.search((Integer) 55), 4);

        assertEquals(target.search((Integer) (-55)), 7);
        assertEquals(target.search((Integer) 66), 8);

        //assertEquals(target.search((Integer) 55), 5);

        int last = arr.length -1;
        while (!target.empty()) {
            assertEquals(target.pop(), (Integer) arr[last--]);
        }
        assertTrue(target.empty());

    }

    private static int[] reverse(int a[], int n)
    {
        int[] b = new int[n];
        int j = n;
        for (int i = 0; i < n; i++) {
            b[j - 1] = a[i];
            j = j - 1;
        }

        return b;
    }

    private static int[] reverse(int a[]) {

        return reverse(a, a.length);
    }

}