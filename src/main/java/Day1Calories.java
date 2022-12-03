import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day1Calories
{

    public Integer getCalories(List<Integer> calories, int numElves){
        List<Integer> elves = getPerElfCalories(calories);
        return elves.stream().sorted(Collections.reverseOrder()).limit(numElves).mapToInt(v-> v).sum();
    }

    private List<Integer> getPerElfCalories(List<Integer> calories){
        List<Integer> elves = new ArrayList<>();
        elves.add(0);

        for(Integer x:calories){
            if(x==null){
                elves.add(0);
            }
            else{
                int lastElf = elves.size()-1;
                elves.set(lastElf, elves.get(lastElf)+x);
            }
        }

        return elves;
    }
}
