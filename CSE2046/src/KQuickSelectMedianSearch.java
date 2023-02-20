
import java.time.Duration;
import java.time.Instant;

public class KQuickSelectMedianSearch implements KSearch
{
    private void swap(int[] list, int i, int j)
    {
        int val = list[i];
        list[i] = list[j];
        list[j] = val;
    }
    
    public int medianOfThree(int[] list, int left, int right)
    {
        int center = (left + right) / 2;
        
        if (list[left] > list[center])
            swap(list, left, center);
        
        if (list[left] > list[right])
            swap(list, left, right);
        
        if (list[center] > list[right])
            swap(list, center, right);
        
        swap(list, center, right);
        
        return list[right];
    }
    
    // Pivot is median of three elements
    private int partition(int[] list, int left, int right)
    {
        int pivot = medianOfThree(list, left, right);
        int i = left-1;
        
        for (int j = left; j <= right-1; ++j) {
            if (list[j] < pivot) {
                ++i;
                swap(list, i, j);
            }
        }
        
        swap(list, i+1, right);
        
        return i+1;
    }
    
    public int quickSelect(int[] list, int left, int right, int k)
    {
        int pivot = partition(list, left, right);
 
        if (pivot == k-1) {
            return list[pivot];
        }
        else if (pivot < k-1) {
            return quickSelect(list, pivot+1, right, k);
        }
        else {
            return quickSelect(list, left, pivot-1, k);
        }
    }
    
    @Override
    public int find(int[] list, int k)
    {
        if (list == null || list.length < k)
            throw new IllegalArgumentException();
        
        return quickSelect(list, 0, list.length-1, k);
    }
    
    @Override
    public long runBestCase(int size)
    {
        int[] arr = KUtil.generateIncreasingArray(size);
        
        Instant start = Instant.now();
        int kth = find(arr, size/2);
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
        return "KQuickSelectMedianSearch";
    }
}
