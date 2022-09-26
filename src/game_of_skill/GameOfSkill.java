package game_of_skill;

import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

public class GameOfSkill {
    @Test
    public void main() {
        In.open("src/game_of_skill/public/test1.in");
        Out.compareTo("src/game_of_skill/public/test1.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    private void testCase() {

    }
}
