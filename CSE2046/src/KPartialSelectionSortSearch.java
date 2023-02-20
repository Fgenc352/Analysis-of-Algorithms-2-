
import java.time.Duration;
import java.time.Instant;

public class KPartialSelectionSortSearch implements KSearch 
{
    private void swap(int[] list, int i, int j)
    {
        int val = list[i];
        list[i] = list[j];
        list[j] = val;
    }
    
    private void partialSelectionSort(int[] list, int k)
    {
        for (int i = 0; i < k; ++i) {
            int minIndex = i;
            
            for (int j = i+1; j < list.length; ++j)
                if (list[j] < list[minIndex])
                    minIndex = j;
  
            swap(list, i, minIndex);
        }
    }
    
    @Override
    public int find(int[] list, int k)
    {
        if (list == null || list.length < k)
            throw new IllegalArgumentException();
        
        partialSelectionSort(list, k);
        
        return list[k-1];
    }
    
    @Override
    public long runBestCase(int size)
    {
        int[] arr = KUtil.generateRandomArray(size);
        
        Instant start = Instant.now();
        int kth = find(arr, 1);
        Instant finish = Instant.now();
        
        long timeElapsed = Duration.between(start, finish).toMillis();
        
        return timeElapsed;
    }

    @Override
    public long runWorstCase(int size)
    {
        int[] arr = KUtil.generateRandomArray(size);
        
        Instant start = Instant.now();
        int kth = find(arr, size);
        Instant finish = Instant.now();
        
        long timeElapsed = Duration.between(start, finish).toMillis();
        
        return timeElapsed;
    }

    @Override
    public long runAverageCase(int size)
    {
        int[] arr = KUtil.generateRandomArray(size);
        
        Instant start = Instant.now();
        int kth = find(arr, size/2);
        Instant finish = Instant.now();
        
        long timeElapsed = Duration.between(start, finish).toMillis();
        
        return timeElapsed;
    }
    
    @Override
    public String getName()
    {
        return "KPartialSelectionSortSearch";
    }
}
