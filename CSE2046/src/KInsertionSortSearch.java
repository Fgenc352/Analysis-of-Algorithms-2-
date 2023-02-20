
import java.time.Duration;
import java.time.Instant;

public class KInsertionSortSearch implements KSearch
{
    private void insertionSort(int[] list)
    {
        int j, val;
        
        for (int i = 1; i < list.length; ++i) {
            val = list[i];
            j = i-1;
            
            while (j >= 0 && list[j] > val) {
                list[j+1] = list[j];
                --j;
            }
            
            list[j+1] = val;
        }
    }
    
    @Override
    public int find(int[] list, int k)
    {
        if (list == null || list.length < k)
            throw new IllegalArgumentException();
     
        insertionSort(list);
        
        return list[k-1];
    }

    @Override
    public long runBestCase(int size)
    {
        int[] arr = KUtil.generateIncreasingArray(size);
        
        Instant start = Instant.now();
        int kth = find(arr, 1);
        Instant finish = Instant.now();
        
        long timeElapsed = Duration.between(start, finish).toMillis();
        
        return timeElapsed;
    }

    @Override
    public long runWorstCase(int size)
    {
        int[] arr = KUtil.generateDecreasingArray(size);
        
        Instant start = Instant.now();
        int kth = find(arr, 1);
        Instant finish = Instant.now();
        
        long timeElapsed = Duration.between(start, finish).toMillis();
        
        return timeElapsed;
    }

    @Override
    public long runAverageCase(int size)
    {
        int[] arr = KUtil.generateRandomArray(size);
        
        Instant start = Instant.now();
        int kth = find(arr, 1);
        Instant finish = Instant.now();
        
        long timeElapsed = Duration.between(start, finish).toMillis();
        
        return timeElapsed;
    }

    @Override
    public String getName()
    {
        return "KInsertionSortSearch";
    }
}
