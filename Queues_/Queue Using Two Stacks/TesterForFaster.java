import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

import org.junit.Test;

public class TesterForFaster {

    @Test
    public void randomTest() {
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(1, 2, 3));
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        boolean areEqual = linkedList.equals(stack);
        System.out.println(areEqual); // Output: true
    }

    @Test
    public void testEnqueue() {
        FasterSolution x = new FasterSolution();

        FasterSolution.Queue<Integer> queue = x.new Queue<Integer>();

        Stack<Integer> equivalentStack = new Stack<Integer>();

        // use assertEquals
        equivalentStack.push(1);
        queue.enqueue(1);
        assertEquals(equivalentStack, queue.stack_reverse_queue);

        equivalentStack.push(2);
        queue.enqueue(2);
        assertEquals(equivalentStack, queue.stack_reverse_queue);

        equivalentStack.push(3);
        queue.enqueue(3);
        assertEquals(equivalentStack, queue.stack_reverse_queue);
    }

    @Test
    public void getReverseTest1() {
        FasterSolution x = new FasterSolution();

        FasterSolution.Queue<Integer> queue = x.new Queue<Integer>();

        Stack<Integer> equivalentStack = new Stack<Integer>();

        // enqueue some
        equivalentStack.push(1);
        equivalentStack.push(2);
        equivalentStack.push(3);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // getReverse
        Stack<Integer> reverseStack = queue.getReverse(queue.stack_reverse_queue);
        Stack<Integer> expectedStack = new Stack<Integer>();
        expectedStack.push(3);
        expectedStack.push(2);
        expectedStack.push(1);

        assertEquals(expectedStack, reverseStack);
    }

    @Test
    public void getReverseTest2() {
        //test getReverse() method

        FasterSolution x = new FasterSolution();
        
        FasterSolution.Queue<Integer> queue = x.new Queue<Integer>();

        Stack<Integer> equivalentStack = new Stack<Integer>();

        // enqueue some
        equivalentStack.push(1);
        equivalentStack.push(2);
        equivalentStack.push(3);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // getReverse
        Stack<Integer> reverseStack = queue.getReverse(queue.stack_reverse_queue);
        Stack<Integer> expectedStack = new Stack<Integer>();
        expectedStack.push(3);
        expectedStack.push(2);
        expectedStack.push(1);

        assertEquals(expectedStack, reverseStack);
    }

    @Test
    public void testDequeue() {
        FasterSolution x = new FasterSolution();

        FasterSolution.Queue<Integer> queue = x.new Queue<Integer>();

        // use assertEquals
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);

        assertEquals(Integer.valueOf(1), queue.dequeue());
        assertEquals(Integer.valueOf(2), queue.dequeue());
        assertEquals(Integer.valueOf(3), queue.dequeue());
        assertEquals(Integer.valueOf(4), queue.dequeue());

        // peeks
        assertEquals(Integer.valueOf(5), queue.peek());
        assertEquals(Integer.valueOf(5), queue.peek());

        assertEquals(Integer.valueOf(5), queue.dequeue());

        assertEquals(Integer.valueOf(6), queue.peek());
        assertEquals(Integer.valueOf(6), queue.peek());

    }
}
