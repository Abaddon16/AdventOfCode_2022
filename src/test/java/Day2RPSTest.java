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

public class Day2RPSTest
{
    @ParameterizedTest
    @CsvSource({
            "day-2-test.txt, 15",
            "day-2-rps.txt, 15691"
    })
    void getScore(String resource, int score) throws URISyntaxException, IOException
    {
        int result = new Day2RPS().getScore(getPlays(resource));
        assertThat(result).isEqualTo(score);
    }

    @ParameterizedTest
    @CsvSource({
            "day-2-test.txt, 12",
            "day-2-rps.txt, 12989"
    })
    void getScore2(String resource, int score) throws URISyntaxException, IOException
    {
        int result = new Day2RPS().getScore2(getPlays(resource));
        assertThat(result).isEqualTo(score);
    }


    private List<String> getPlays(String resourceName) throws URISyntaxException, IOException
    {
        URL url = getClass().getClassLoader().getResource(resourceName);
        return new ArrayList<>(Files.readAllLines(Paths.get(url.toURI())));
    }
}
