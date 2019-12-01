package CodeCracking_LinkedList;

public class Main {


    public static void main(String[] argc) {
        MyLinkedList<String> stringMyLinkedList = new MyLinkedList<>("node1");
        System.out.println("first value = " + stringMyLinkedList.first.value + " " +
                " last value = " + stringMyLinkedList.last.value);
        stringMyLinkedList.appendToTail("node2");
        System.out.println("first value = " + stringMyLinkedList.first.value + " " +
                " last value = " + stringMyLinkedList.last.value);
        stringMyLinkedList.appendToTail("node4");
        System.out.println("first value = " + stringMyLinkedList.first.value + " " +
                " last value = " + stringMyLinkedList.last.value);
        stringMyLinkedList.appendToTail("node3");
        System.out.println("first value = " + stringMyLinkedList.first.value + " " +
                " last value = " + stringMyLinkedList.last.value);


        System.out.println(stringMyLinkedList.toString());

        stringMyLinkedList.removeFirstFindValue("node1");
        stringMyLinkedList.removeFirstFindValue("node4");
        stringMyLinkedList.removeFirstFindValue("node2");

        System.out.println(stringMyLinkedList.toString());

    }

    private static class MyLinkedList<E> {
        MyLinkedList prev = null;
        MyLinkedList next = null;
        E value;

        MyLinkedList first;
        MyLinkedList last;

        private MyLinkedList(E value) {
            this.value = value;
            first = this;
            last = this;
        }

        private void appendToTail(E value) {
            MyLinkedList end = new MyLinkedList<>(value);
            end.first = first;
            MyLinkedList n = this;

            while (n.next != null) {
                n.last = end;
                n = n.next;
            }

            n.next = end;
            n.last = end;
            end.prev = n;
            end.last = end;
        }

        private void removeFirstFindValue(E searchValue) {
            MyLinkedList n = this;
            boolean find = false;
            while (n != null) {
                if (n.value == searchValue) {
                    find = true;
                    break;
                }
                n = n.next;
            }

            if (!find) {
                return;
            }

            if ((n.prev != null) && (n.next != null)) { //midle ellement
                n.prev.next = n.next;
                n.next.prev = n.prev;
            } else if ((n.prev == null) && (n.next == null)) { //onle one ellement
                n.value = null;
            } else if (n.prev != null) { //for last ellement
                n.prev.next = null;
            } else if (n.next != null) { //for first ellement
                n.value = n.next.value; //move value
                n.prev = null; //modev prev node
                n.next = n.next.next; //move next node
            }
        }

        @Override
        public String toString() {
            MyLinkedList n = this;
            StringBuilder ret = new StringBuilder();
            ret.append("[");
            while (n.next != null) {
                ret.append(n.value).append(",");
                n = n.next;
            }
            ret.append(n.value).append("]");
            return ret.toString();
        }
    }
}
