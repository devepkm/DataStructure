

/**
 * @Auther: dev
 * @Date: 16/11/2020 10:17
 * @Description:
 */
public class ArrayListTest {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.addLast(i);
        }
        System.out.println(arrayList);

        arrayList.insert(1, 100);
        System.out.println(arrayList);

        arrayList.addFirst(-1);
        System.out.println(arrayList);

        Integer integer = arrayList.get(1);
        System.out.println(integer);

        Integer remove = arrayList.remove(1);
        System.out.println(arrayList);
        System.out.println(remove);

        Integer integer1 = arrayList.removeFirst();
        System.out.println(integer1);
        System.out.println(arrayList);

        Integer integer2 = arrayList.removeLast();
        System.out.println(integer2);
        System.out.println(arrayList);

    }


}