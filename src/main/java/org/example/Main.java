package org.example;

public class Main {
    public static void main(String[] args) {
        /*MyArrayList<String> stringList = new MyArrayList<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        stringList.addAll("d", "i");
        stringList.add(2, "f");
        stringList.remove(1);
        for (int i = 0; i < stringList.size(); i++) {
            System.out.print(stringList.get(i) + " ");
        }
        System.out.println("Размер массива: " + stringList.size());

        stringList.set(0, "g");
        System.out.println(stringList.get(0));
        System.out.println("Размер массива: " + stringList.size());

        stringList.quickSort(0, 4, Comparator.naturalOrder());
        for (int i = 0; i < stringList.size(); i++) {
            System.out.print(stringList.get(i) + " ");
        }
        System.out.println();*/

        /*MyArrayList<Integer> integerList = new MyArrayList<>();
        integerList.addAll(1, 3, 5, 7, 9, 6, 3, 4, 8, 11, 12);
        for (int k = 0; k < integerList.size(); k++) {
            System.out.print(integerList.get(k) + " ");
        }
        System.out.println();
        integerList.quickSort(0, 10, Comparator.naturalOrder());
        for (int k = 0; k < integerList.size(); k++) {
            System.out.print(integerList.get(k) + " ");
        }

        System.out.println();*/

        Pet frog = new Pet(1, "Boris");
        Pet bug = new Pet(2, "Stas");
        Pet bugCopy = new Pet(2, "Stas");

        MyArrayList<Pet> arrayList = new MyArrayList<>();
        arrayList.add(frog);
        arrayList.add(bug);
        arrayList.add(bugCopy);


    }

}

class Pet {
    private final int id;
    private final String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Pet(int id, String name) {
        this.id = id;
        this.name = name;
    }
}