package important_stops;

import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

public class ImportantStops {
    @Test
    public void main() {
        In.open("src/important_stops/public/sample.in");
        Out.compareTo("src/important_stops/public/sample.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    private static void testCase() {

    }
}
