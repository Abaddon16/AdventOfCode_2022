import java.util.List;

public class Day2RPS
{
    int WIN = 6;
    int TIE = 3;
    int LOSE = 0;
    int ROCK = 1;
    int PAPER = 2;
    int SCISSORS = 3;
    public int getScore(List<String> plays){
        int score = 0;
        for(String play:plays){
            String[] hands = play.split(" ");
            switch (hands[1])
            {
                case "X" -> { // rock
                    score += ROCK;
                    switch(hands[0]){
                        case "A" -> score+=TIE;// rock
                        case "B" -> score+=LOSE; // paper
                        case "C" -> score+=WIN; // scissors
                        default -> throw new IllegalStateException("Unexpected value: " + hands[0]);
                    }
                }
                case "Y" -> {
                    score += PAPER;
                    switch(hands[0]){
                        case "A" -> score+=WIN;// rock
                        case "B" -> score+=TIE; // paper
                        case "C" -> score+=LOSE; // scissors
                        default -> throw new IllegalStateException("Unexpected value: " + hands[0]);
                    }
                }
                case "Z" -> {
                    score += SCISSORS;
                    switch(hands[0]){
                        case "A" -> score+=LOSE;// rock
                        case "B" -> score+=WIN; // paper
                        case "C" -> score+=TIE; // scissors
                        default -> throw new IllegalStateException("Unexpected value: " + hands[0]);
                    }
                }
                default -> throw new IllegalStateException("Unexpected value: " + hands[1]);
            }
        }
        return score;
    }

    public int getScore2(List<String> plays){
        int score = 0;
        for(String play:plays){
            String[] hands = play.split(" ");
            switch (hands[1])
            {
                case "X" -> { // rock
                    score += LOSE;
                    switch(hands[0]){
                        case "A" -> score+=SCISSORS;// rock
                        case "B" -> score+=ROCK; // paper
                        case "C" -> score+=PAPER; // scissors
                        default -> throw new IllegalStateException("Unexpected value: " + hands[0]);
                    }
                }
                case "Y" -> {
                    score += TIE;
                    switch(hands[0]){
                        case "A" -> score+=ROCK;// rock
                        case "B" -> score+=PAPER; // paper
                        case "C" -> score+=SCISSORS; // scissors
                        default -> throw new IllegalStateException("Unexpected value: " + hands[0]);
                    }
                }
                case "Z" -> {
                    score += WIN;
                    switch(hands[0]){
                        case "A" -> score+=PAPER;// rock
                        case "B" -> score+=SCISSORS; // paper
                        case "C" -> score+=ROCK; // scissors
                        default -> throw new IllegalStateException("Unexpected value: " + hands[0]);
                    }
                }
                default -> throw new IllegalStateException("Unexpected value: " + hands[1]);
            }
        }
        return score;
    }
}
