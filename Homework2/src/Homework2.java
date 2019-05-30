public class Homework2 {
    /*2019.05.30.THU 作业2（学者网）
    完成下面的作业:
    泛型排序:使用排序算法实现下面的方法public static <E extends Comparable <E>> void sort(E[] list)
    并创建main方法对上面的排序方法法进行测试，测试的数组如下:
    Integer [] array={5,67,89,34,2,0,18,18,9}
    String strings={“Java”, “Delphi”, ”C”,”C#”,”C++”,”PL/SQL”}*/

    public static <E extends Comparable<E>> void sort(E[] list) {
        for (int i = 0; i < list.length; i++) {
            for (int j = i; j < list.length; j++) {
                if (list[i].compareTo(list[j]) > 0) {  //compareTo方法比较结果为大于时，返回一个大于0的值而不一定是1
                    //System.out.print(list[i].compareTo((list[j])));
                    E tmp = list[i];
                    list[i] = list[j];
                    list[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] array = {5, 67, 89, 34, 2, 0, 18, 18, 9};
        String[] strings = {"Java", "Delphi", "C", "C#", "C++", "PL/SQL"};
        sort(array);  //在实例化泛型类的过程中，实际类型必须是引用类型，即必须是类类型，不能用int、double或char等这样的基本类型来替换类型参数T
        sort(strings);  //方法参数为数组时，是传址调用
        for (Integer i : array) {
            System.out.print(i + ",");
        }
        System.out.println();
        for (String i : strings) {
            System.out.print(i + ",");
        }
    }
}
