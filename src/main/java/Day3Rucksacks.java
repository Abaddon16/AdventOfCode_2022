import java.util.*;

public class Day3Rucksacks{
    String priorities = " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public int priorityRucksackErrors(List<String> rucksacks){
        List<String> itemsSplit;
        List<String> pocket1;
        int priority = 0;
        
        for(String rucksack:rucksacks){
            itemsSplit=new ArrayList<>(List.of(rucksack.split("")));
            pocket1=itemsSplit.subList(0, itemsSplit.size()/2);
    
            pocket1.retainAll(itemsSplit.subList(itemsSplit.size()/2, itemsSplit.size()));
            Set<String> overlap = new HashSet<>(pocket1);
            for(String x: overlap){
                priority+=priorities.indexOf(x);
            }
        }
        return priority;
    }
    
    public int badgePriority(List<String> rucksacks){
        int priority = 0;
        for(ListIterator<String> iter =rucksacks.listIterator(); iter.hasNext();){
            List<String> rucksack1 = new ArrayList<>(List.of(iter.next().split("")));
            List<String> rucksack2 = new ArrayList<>(List.of(iter.next().split("")));
            List<String> rucksack3 = new ArrayList<>(List.of(iter.next().split("")));
            
            rucksack1.retainAll(rucksack2);
            rucksack1.retainAll(rucksack3);
    
            Set<String> overlap = new HashSet<>(rucksack1);
            for(String x: overlap){
                priority+=priorities.indexOf(x);
            }
        }
        return priority;
    }
}
