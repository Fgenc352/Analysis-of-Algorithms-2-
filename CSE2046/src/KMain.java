
public class KMain
{
    public static void main(String[] args)
    {
        int[] setSizes = { 8192, 16384, 32768, 65536, 131072, 262144, 524288 };
        
        KSearch[] kSearches = {
            new KInsertionSortSearch(),
            new KMergeSortSearch(),
            new KQuickSortSearch(),
            new KPartialSelectionSortSearch(),
            new KPartialHeapSortSearch(),
            new KQuickSelectFirstSearch(),
            new KQuickSelectMedianSearch()
        };
        
        for (int i = 0; i < kSearches.length; ++i) {
            System.out.println("---------------------------------------");
            System.out.println(kSearches[i].getName() + ":");
            System.out.println("---------------------------------------");
            
            System.out.println("********** Best Case **********");
            for (int j = 0; j < setSizes.length; ++j)
            {
                long timeElapsed = kSearches[i].runBestCase(setSizes[j]);
                System.out.println("Set length: " + setSizes[j] + "\t" + "Time(ms): " + timeElapsed);
            }
            
            System.out.println("********** Worst Case **********");
            
            for (int j = 0; j < setSizes.length; ++j)
            {
                long timeElapsed = kSearches[i].runWorstCase(setSizes[j]);
                System.out.println("Set length: " + setSizes[j] + "\t" + "Time(ms): " + timeElapsed);
            }
            
            System.out.println("********** Average Case **********");
            
            for (int j = 0; j < setSizes.length; ++j)
            {
                long timeElapsed = kSearches[i].runAverageCase(setSizes[j]);
                System.out.println("Set length: " + setSizes[j] + "\t" + "Time(ms): " + timeElapsed);
            }
            
            System.out.println("---------------------------------------");
        }
    }
}


