
import java.time.Duration;
import java.time.Instant;

public class KQuickSortSearch implements KSearch
{
    private void swap(int[] list, int i, int j)
    {
        int val = list[i];
        list[i] = list[j];
        list[j] = val;
    }
    
    // Pivot is first elements
    private int partition(int[] list, int left, int right)
    {
        int pivot = list[left];
        int i = left-1;

        swap(list, left, right);
        
        for(int j = left; j <= right-1; ++j) {
            if (list[j] < pivot) {
                ++i;
                swap(list, i, j);
            }
        }
        
        swap(list, i+1, right);
        
        return i+1;
    }
    
    private void quickSort(int[] list, int left, int right)
    {
        if (left < right) {
            int pivot = partition(list, left, right);
            quickSort(list, left, pivot-1);
            quickSort(list, pivot+1, right);
        }
    }
    
    @Override
    public int find(int[] list, int k)
    {
        if (list == null || list.length < k)
            throw new IllegalArgumentException();
        
        quickSort(list, 0, list.length-1);
        
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
        int[] arr = KUtil.generateIncreasingArray(size);
        
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
        return "KQuickSortSearch";
    }
}
