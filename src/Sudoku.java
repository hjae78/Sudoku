import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sudoku {

    static int[][] input = {{0,0,0,0,5,8,4,0,0},
    {2,0,0,0,0,0,0,8,3},
    {0,0,7,4,0,0,9,1,0},
    {5,3,0,1,0,0,0,6,4},
    {0,6,0,0,7,4,5,9,0},
    {4,0,0,0,0,5,0,3,0},
    {8,9,0,0,4,3,2,5,0},
    {0,0,6,0,0,1,3,0,9},
    {0,0,5,2,0,0,8,7,1}};

    static final List<Square> NUMBERS = Arrays.asList(new Square(1), new Square(2), new Square(3),
            new Square(4), new Square(5), new Square(6), new Square(7), new Square(8),
            new Square(9));


    public static void main(String[] args) {

        Square[][] numbers = new Square[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                numbers[i][j] = new Square(input[i][j]);
            }
        }
        Board board = new Board(numbers);
        System.out.println(board.toString());
        long time = System.currentTimeMillis();
        while (!board.isSolved()) {
            if (!board.solve()) {
                System.out.println("Something's wrong.");
                System.out.println(board.toString());
                break;
            }
        }
        System.out.println(board);
        System.out.println("Solved in: " + (System.currentTimeMillis() - time) + " milliseconds.");

    }


}
