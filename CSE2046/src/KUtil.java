
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class KUtil
{
    private final static Random random = new Random();
    
    static int[] clone(int[] list)
    {
        int[] newList = new int[list.length];
        System.arraycopy(list, 0, newList, 0, newList.length);
        
        return newList;
    }
    
    static void print(int[] list)
    {
        for (int i = 0; i < list.length; ++i) {
            System.out.print(list[i] + " ");
        }
        
        System.out.println();
    }
    
    static int[] generateIncreasingArray(int size)
    {
        int[] arr = new int[size];
        
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = (i+1);
        }
        
        return arr;
    }
    
    static int[] generateDecreasingArray(int size)
    {
        int[] arr = new int[size];
        
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = size - i;
        }
        
        return arr;
    }
    
    static int[] generateRandomArray(int size)
    {
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[size];
        
        for (int i = 0; i < size; ++i) {
            list.add(i+1);
        }
        
        for (int i = 0; i < size; ++i) {
            int pos = random.nextInt(list.size());
            arr[i] = list.remove(pos);
        }
        
        return arr;
    }
}
