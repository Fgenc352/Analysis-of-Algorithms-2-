
import java.time.Duration;
import java.time.Instant;

public class KMergeSortSearch implements KSearch
{
    void merge(int[] list, int begin, int middle, int end)
    {
        int startIndex = middle+1;
        
        if (list[middle] <= list[startIndex]) {
            return;
        }
        
        while (begin <= middle && startIndex <= end) {
            if (list[begin] <= list[startIndex]) {
                ++begin;
            }
            else {
                int i = startIndex;
                int val = list[startIndex];
                
                while (i != begin) {
                    list[i] = list[i-1];
                    --i;
                }
                
                list[begin] = val;
                
                ++begin;
                ++middle;
                ++startIndex;
            }
        }
    }
    
    private void mergeSort(int[] list, int left, int right)
    {
        if (left < right) {
            int middle = left + (right-left) / 2;
            
            mergeSort(list, left, middle);
            mergeSort(list, middle+1, right);
            merge(list, left, middle, right);
        }
    }
    
    @Override
    public int find(int[] list, int k)
    {
        if (list == null || list.length < k)
            throw new IllegalArgumentException();
        
        mergeSort(list, 0, list.length-1);
        
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
        int kth = find(arr, 1);
        Instant finish = Instant.now();
        
        long timeElapsed = Duration.between(start, finish).toMillis();
        
        return timeElapsed;
    }
    
    @Override
    public String getName()
    {
        return "KMergeSortSearch";
    }
}
