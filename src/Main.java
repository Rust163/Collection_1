import java.util.*;

public class Main {
    private static final List<String> NAMES = List.of(
            "Николай", "Коля", "Паша", "Петр", "Василий", "Виктор", "Владислав", "Евгений", "Коля", "Паша", "Петр", "Василий", "Виктор", "Владислав", "Евгений", "Максим", "Гриша", "Иван", "Александр", "Руслан", "Елена", "Светлана", "Ирина","Маргарита");
    private static final Random RANDOM = new Random();
    private static final int MAX_SIZE = 5;
    public static void main(String[] args) {
        Queue<String> queue1 = new ArrayDeque<>();
        Queue<String> queue2 = new ArrayDeque<>();
        Queue<String> queue3 = new ArrayDeque<>();
        fillingTheQueue(queue1);
        fillingTheQueue(queue2);
        fillingTheQueue(queue3);
        System.out.println("Очередь в 1ую кассу" + queue1);
        System.out.println("Очередь во 2ую кассу" + queue2);
        System.out.println("Очередь во 3ую кассу" + queue3);

        add("Паша", queue1, queue2, queue3);
        System.out.println("Очередь в 1ую кассу" + queue1);
        System.out.println("Очередь во 2ую кассу" + queue2);
        System.out.println("Очередь во 3ую кассу" + queue3);

        remove(queue1, queue2, queue3);
        System.out.println("Очередь в 1ую кассу" + queue1);
        System.out.println("Очередь во 2ую кассу" + queue2);
        System.out.println("Очередь во 3ую кассу" + queue3);

        example();
    }
    private static void add(String name, Queue<String> queue1, Queue<String> queue2, Queue<String> queue3) {
        if(queue1.size() ==MAX_SIZE && queue2.size() == MAX_SIZE && queue3.size() == MAX_SIZE) {
            System.out.println("Сколько можно!?!?!?!?! Зовите Галю!");
            return;
        }
        if(queue1.size() < queue2.size()) {
            queue1.offer(name);
        } else if(queue2.size() < queue3.size()) {
            queue2.offer(name);
        } else {
            queue3.offer(name);
        }
    }
    private static void remove (Queue<String> queue1, Queue<String> queue2, Queue<String> queue3) {
        if(RANDOM.nextBoolean()) {
            queue1.poll();
        } else if (RANDOM.nextBoolean()){
            queue2.poll();
        } else {
            queue3.poll();
        }
    }
    private static void fillingTheQueue(Queue<String> queue) {
        int size = RANDOM.nextInt(MAX_SIZE + 1);
        for (int i = 0; i < size; i++) {
            queue.offer(NAMES.get(RANDOM.nextInt(NAMES.size())));
        }
    }
    private static void example() {
        List<List<String>> biDemArrList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            biDemArrList.add(i, new ArrayList<>());
            for (int j = 0; j < 8; j++) {
                biDemArrList.get(i).add((i + j) % 2 == 1 ? "●" : "◯");
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(biDemArrList.get(i).get(j) + " ");
            }
            System.out.println(" ");
        }
    }
}