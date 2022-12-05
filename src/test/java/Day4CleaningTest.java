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

public class Day4CleaningTest{
    
    @ParameterizedTest
    @CsvSource({
            "day-4-test.txt, 2",
            "day-4-cleaning.txt, 471"
    })
    void getFullyOverlappingSections(String resource, int overlaps) throws URISyntaxException, IOException
    {
        int result = new Day4Cleaning().getOverlaps(getSections(resource), true);
        assertThat(result).isEqualTo(overlaps);
    }
    
    @ParameterizedTest
    @CsvSource({
            "day-4-test.txt, 4",
            "day-4-cleaning.txt, 888"
    })
    void getPartiallyOverlappingSections(String resource, int overlaps) throws URISyntaxException, IOException
    {
        int result = new Day4Cleaning().getOverlaps(getSections(resource), false);
        assertThat(result).isEqualTo(overlaps);
    }
    
    private List<String> getSections(String resourceName) throws URISyntaxException, IOException
    {
        URL url = getClass().getClassLoader().getResource(resourceName);
        return new ArrayList<>(Files.readAllLines(Paths.get(url.toURI())));
    }
}
