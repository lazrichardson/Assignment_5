public class Sorting {


    public static int[] simpleSort(int priorities[]) // can use this instead of bubble sort
    { for (int i = 0; i < priorities.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < priorities.length; j++)
                if (priorities[j] < priorities[index])
                    index = j;

            int smallerNumber = priorities[index];
            priorities[index] = priorities[i];
            priorities[i] = smallerNumber;
        }
        return priorities;
    }



    public static int[] bubbleSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    // swap temp and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
                return arr;
    }
}
