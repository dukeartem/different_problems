package minStack;

public class Main {

    public static void main(String[] argc) {

//        MinStack minStack = new MinStack();
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        System.out.println(minStack.getMin());   //--> Returns -3.
//        minStack.pop();
//        minStack.top();      //--> Returns 0.
//        System.out.println(minStack.getMin());   //--> Returns -2.

/*
["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
[[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]

expect: [null,null,null,null,2147483647,null,2147483646,null,2147483646,null,null,
2147483647,2147483647,null,-2147483648,-2147483648,null,2147483647]
 */
        MinStack minStack = new MinStack();     //null
        minStack.push(2147483646);           //null
        minStack.push(2147483646);           //null
        minStack.push(2147483647);           //null
        minStack.top();                         //2147483647
        minStack.pop();                         //null
        System.out.println(minStack.getMin());  //2147483646
        minStack.pop();                         //null
        System.out.println(minStack.getMin());  //2147483646
        minStack.pop();                         //null
        minStack.push(2147483647);           //null
        minStack.top();                         //2147483647
        System.out.println(minStack.getMin());  //2147483647
        minStack.push(-2147483648);          //null
        minStack.top();                         //-2147483648
        System.out.println(minStack.getMin());  //-2147483648
        minStack.pop();                         //null
        System.out.println(minStack.getMin());  //2147483647
    }


    private static class MinStack {
        private int data;
        private int min;

        private int size;

        private MinStack next;

        /** initialize your data structure here. */
        private MinStack() {

        }

        private MinStack(int d, int m, int s, MinStack n) {
            data = d;
            min = m;
            size = s;
            next = n;
        }

        private void push(int x) {
            if (size == 0) {
                data = x;
                min = x;
                size += 1;
            } else {

                int moreMin =  min;
                if (x < min) {
                    moreMin = x;
                }

                MinStack n = new MinStack(data, min, size+1, next);
                data = x;
                min = moreMin;
                next = n;
            }

        }

        private void pop() {
            if (next != null) {
                data = next.data;
                min = next.min;
                size = next.size-1;
                next = next.next;
            } else {
                size = 0;
            }
        }

        private int top() {
            return data;
        }

        private int getMin() {
            return min;
        }
    }
}
