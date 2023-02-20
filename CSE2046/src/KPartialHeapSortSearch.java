
import java.time.Duration;
import java.time.Instant;

public class KPartialHeapSortSearch implements KSearch
{
    private void swap(int[] list, int i, int j)
    {
        int val = list[i];
        list[i] = list[j];
        list[j] = val;
    }
    
    private void heapify(int[] list, int n, int i)
    {
        int maxIndex = i;
        int left = 2*i+1;
        int right = 2*i+2;
        
        if ((left < n) && (list[left] > list[maxIndex]))
            maxIndex = left;
        
        if ((right < n) && (list[right] > list[maxIndex]))
            maxIndex = right;
        
        if (maxIndex != i) {
            swap(list, i, maxIndex);
            
            heapify(list, n, maxIndex);
        }
    }
    
    private void partialHeapSort(int[] list, int k)
    {
        int n = list.length;
 
        for (int i = n / 2 - 1; i >= 0; --i)
            heapify(list, n, i);
 
        for (int i = n - 1; i >= (k - 1); --i) {
            swap(list, 0, i);
            
            heapify(list, i, 0);
        }
    }
    
    @Override
    public int find(int[] list, int k)
    {
        if (list == null || list.length < k)
            throw new IllegalArgumentException();
        
        partialHeapSort(list, k);
        
        return list[k-1];
    }
    
    @Override
    public long runBestCase(int size)
    {
        int[] arr = KUtil.generateRandomArray(size);
        
        Instant start = Instant.now();
        int kth = find(arr, size);
        Instant finish = Instant.now();
        
        long timeElapsed = Duration.between(start, finish).toMillis();
        
        return timeElapsed;
    }

    @Override
    public long runWorstCase(int size)
    {
        int[] arr = KUtil.generateRandomArray(size);
        
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
        int kth = find(arr, size/2);
        Instant finish = Instant.now();
        
        long timeElapsed = Duration.between(start, finish).toMillis();
        
        return timeElapsed;
    }

    @Override
    public String getName()
    {
        return "KPartialHeapSortSearch";
    }
}
