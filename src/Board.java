import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Board {

    private final Square[][] squares;

    public Board(Square[][] numbers) {
        this.squares = numbers;
    }

    public void setSquare(int number, int rowIndex, int colIndex) {
        squares[rowIndex][colIndex].setNumber(number);
    }

    public Square getSquare(int rowIndex, int colIndex) {
        return squares[rowIndex][colIndex];
    }

    public List<Square> getRow(int rowIndex) {
        return Arrays.asList(squares[rowIndex]);
    }

    public List<Square> getColumn(int colIndex) {
        Square[] column = new Square[9];
        for (int i = 0; i < 9; i++) {
            column[i] = squares[i][colIndex];
        }
        return Arrays.asList(column);
    }

    public List<Square> getSubgridNumbers(int rowIndex, int colIndex) {
        Square[] subgrid = new Square[9];
        int index = 0;
        int subgridRowIndex = (rowIndex / 3) * 3;
        int subgridColIndex = (colIndex / 3) * 3;
        for (int i = subgridRowIndex; i < subgridRowIndex + 3; i++) {
            for (int j = subgridColIndex; j < subgridColIndex + 3; j++) {
                subgrid[index] = squares[i][j];
                index++;
            }
        }
        return Arrays.asList(subgrid);
    }

    public boolean isSolved() {
        boolean solved = true;
        for (int i = 0; i < 9; i++) {
            if (!Utils.complement(this.getRow(i), Sudoku.NUMBERS).equals(Collections.emptyList())) {
                solved = false;
            }
            if (!Utils.complement(this.getColumn(i), Sudoku.NUMBERS).equals(Collections.emptyList())) {
                solved = false;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!Utils.complement(this.getSubgridNumbers(i * 3, j * 3), Sudoku.NUMBERS).equals(Collections.emptyList())) {
                    solved = false;
                }
            }
        }
        return solved;
    }

    public boolean solve() {
        boolean found = false;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (this.getSquare(i, j).getNumber() == 0) {
                    List<Square> setA = Utils.union(this.getRow(i), this.getColumn(j));
                    List<Square> setB = Utils.union(setA, this.getSubgridNumbers(i, j));
                    List<Square> possibleNumbers = Utils.complement(Sudoku.NUMBERS, setB);
                    if (possibleNumbers.size() == 1) {
                        this.setSquare(possibleNumbers.get(0).getNumber(), i, j);
                        found = true;
                    }
                }
            }
        }
        return found;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            sb.append(this.getRow(i)).append('\n');
        }
        return sb.toString();
    }
}
