import java.io.*;
import java.util.*;
import java.util.stream.*;

public class FasterSolution {

    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */

        Scanner scan = new Scanner(System.in);
        FasterSolution solution = new FasterSolution();

        int querry_count;
        int given_querry_count = 0;
        int firstInput;
        int secondInput;

        querry_count = scan.nextInt();

        Queue<Integer> queue = solution.new Queue<Integer>();

        while (given_querry_count < querry_count) {
            firstInput = scan.nextInt();

            switch (firstInput) {
                case 1:
                    secondInput = scan.nextInt();
                    queue.enqueue(secondInput);
                    break;

                case 2:
                    queue.dequeue();
                    break;

                case 3:
                    queue.print();
                    break;
            }
            given_querry_count++;
        }

    }

    /**
     * Queue behaves in this way:
     * 3 operations:
     * 1. Enqueue (offer): Add an element to the end of the queue
     * 2. Dequeue (poll): Remove the element from the front of the queue
     * 3. Print (peek): Print the element at the front of the queue
     */
    public class Queue<T> {
        Stack<T> stack_reverse_queue;
        Stack<T> stack_queue;
        int size;

        Queue() {
            stack_reverse_queue = new Stack<>();

            stack_queue = new Stack<>();

        }

        Queue(List<T> queueList) {
            stack_queue = new Stack<>();
            stack_reverse_queue = new Stack<>();

            stack_reverse_queue.addAll(queueList);

        }

        /*
         * Initialization: take input as list, put into stack.
         * Dequeue: When polling x reverse everything take x
         * Enqeueue: When offering x, add to the back.
         * Print: When peeking, reverse and putback.
         */

        /*
         * reversing is done by storing everything in the reverse_queue.
         */

        public Stack<T> getReverse() {
            stack_queue = new Stack<>();
            
            ListIterator<T> resultIt = stack_queue.listIterator();

            //since Stack is implemented as a vector and not a linked list, we can't use listIterator() to traverse in reverse order
            //since it is a vector, this operation is O(1) and not O(n)
            ListIterator<T> sourceIt = stack_reverse_queue.listIterator(stack_reverse_queue.size()); 

            while (sourceIt.hasPrevious()) {
                resultIt.add(sourceIt.previous());
            }

            return stack_queue;
        }

        public Stack<T> getReverse(Stack<T> stack) {
            Stack<T> reversedStack = new Stack<T>();
            Stack<T> temp = stack;

            while (!temp.isEmpty()) {
                T element = temp.pop();
                reversedStack.push(element);
            }

            return reversedStack;
        }

        private Stack<T> makeQueue() {
            return getReverse();
        }

        public Queue<T> enqueue(T target) {
            stack_reverse_queue.add(target);
            return this;
        }

        public T dequeue() {
            Stack<T> queue = getReverse();
            T temp;
            stack_reverse_queue = new Stack<T>();

            temp = queue.pop();

            while (queue.isEmpty() == false) {
                stack_reverse_queue.push(queue.pop());
            }

            return temp;
        }

        /*
         * doesnt work, why? because you don't empty before adding.
         * 
         * public T dequeue() {
         * T temp;
         * Stack<T> queue = getReverse();
         * temp = queue.pop();
         * stack_reverse_queue.push
         * 
         * return temp;
         * }
         * 
         */

        public Queue<T> print() {
            System.out.println(peek());
            // System.out.println(stack_reverse_queue.peek());
            return this;
        }

        public T peek() {
            return stack_reverse_queue.get(0);

        }

    }
}