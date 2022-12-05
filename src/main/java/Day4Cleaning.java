import java.util.Arrays;
import java.util.List;

public class Day4Cleaning{
    
    public int getOverlaps(List<String> sectionPairs, boolean fullyOverlapped){
        int overlap = 0;
        for(String pair:sectionPairs){
            int[] splitPairs = Arrays.stream(pair.split("[,-]")).mapToInt(Integer::parseInt).toArray();
            overlap += hasOverlap(splitPairs[0], splitPairs[1], splitPairs[2], splitPairs[3], fullyOverlapped)?1:0;
        }
        return overlap;
    }
    
    public boolean hasOverlap(int x1, int x2, int y1, int y2, boolean fullOverlapOnly){
        return fullOverlapOnly ? (x1<=y1&&y2<=x2) || (y1<=x1&&x2<=y2) : (y2-x1)*(x2-y1)>=0;
    }
}
