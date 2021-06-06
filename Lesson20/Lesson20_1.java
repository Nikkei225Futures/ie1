public class Lesson20_1 {
  public static void main(String[] args){
    int[] sort_array = {2, 9, 7, 4, 3, 10, 5, 1, 6, 8};

    InsertionSort is = new InsertionSort(sort_array);
    System.out.println("Check InsertionSort (Array size = " + sort_array.length + ")");
    System.out.println();

    System.out.print("Array before sort: ");
    is.display();

    is.insertionSort();

    System.out.print("Array after sort: ");
    is.display();

  }
}
