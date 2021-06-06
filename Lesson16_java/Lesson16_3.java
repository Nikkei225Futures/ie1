public class Lesson16_3 {
    public static void main(String[] args) {
        System.out.println("---- MyQueue ----");
        MyQueue que = new MyQueue(4);
        que.enqueue("AAA");
        que.enqueue("BBB");
        que.enqueue("CCC");

        que.printAll();
        System.out.println();

        System.out.println("-- MyQueue peek --");
        System.out.println("Object at the head: " + que.peek());
        que.printAll();
        System.out.println();

        System.out.println("-- MyQueue forceEnqueue --");
        System.out.println("Enqueue DDD (position " + que.forceEnqueue("DDD") + ")");
        System.out.println("Enqueue EEE (position " + que.forceEnqueue("EEE") + ")");
        que.printAll();
        System.out.println();

        System.out.println("-- MyQueue clear --");
        que.clear();
        que.printAll();
        System.out.println();

        System.out.println("-- MyQueue peek --");
        System.out.println("Object at the head: " + que.peek());
        que.printAll();
    }
}

