import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Day1CaloriesTest
{
    @ParameterizedTest
    @CsvSource({
            "day-1-test.txt, 24000",
            "day-1-calories.txt, 66616"
    })
    void getCaloriesTopElf(String resource, int mostCalories) throws URISyntaxException, IOException
    {
        int result = new Day1Calories().getCalories(getCalories(resource), 1);
        assertThat(result).isEqualTo(mostCalories);
    }

    @ParameterizedTest
    @CsvSource({
            "day-1-test.txt, 45000",
            "day-1-calories.txt, 199172"
    })
    void getCaloriesTopThreeElves(String resource, int topThreeCalories) throws URISyntaxException, IOException
    {
        Integer result = new Day1Calories().getCalories(getCalories(resource), 3);
        assertThat(result).isEqualTo(topThreeCalories);
    }


    private List<Integer> getCalories(String resourceName) throws URISyntaxException, IOException
    {
        URL url = getClass().getClassLoader().getResource(resourceName);
        return Files.readAllLines(Paths.get(url.toURI())).stream()
                .map(str -> (str.isBlank()||str.isEmpty())?null:Integer.parseInt(str))
                .collect(Collectors.toList());
    }
}
