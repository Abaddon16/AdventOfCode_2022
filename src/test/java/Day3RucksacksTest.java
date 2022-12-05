import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Day3RucksacksTest{
    
    @ParameterizedTest
    @CsvSource({
            "day-3-test.txt, 157",
            "day-3-rucksacks.txt, 7581"
    })
    void getErrorPriority(String resource, int score) throws URISyntaxException, IOException
    {
        int result = new Day3Rucksacks().priorityRucksackErrors(getRucksacks(resource));
        assertThat(result).isEqualTo(score);
    }
    
    @ParameterizedTest
    @CsvSource({
            "day-3-test.txt, 70",
            "day-3-rucksacks.txt, 2525"
    })
    void getBadgePriority(String resource, int score) throws URISyntaxException, IOException
    {
        int result = new Day3Rucksacks().badgePriority(getRucksacks(resource));
        assertThat(result).isEqualTo(score);
    }
    
    private List<String> getRucksacks(String resourceName) throws URISyntaxException, IOException
    {
        URL url = getClass().getClassLoader().getResource(resourceName);
        return new ArrayList<>(Files.readAllLines(Paths.get(url.toURI())));
    }
}
