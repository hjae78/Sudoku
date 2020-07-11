import java.util.*;

public class Utils {

    public static List<Square> intersection(Collection<Square> setA, Collection<Square> setB) {
        List<Square> result = new ArrayList<Square>();
        for (Square squareA : setA) {
            for (Square squareB : setB) {
                if (squareA.equals(squareB) && squareA.getNumber() != 0) {
                    result.add(squareA);
                }
            }
        }
        return result;
    }

    public static List<Square> symmetricDifference(Collection<Square> setA, Collection<Square> setB) {
        List<Square> result = new ArrayList<>();
        for (Square squareA : setA) {
            if (!setB.contains(squareA)) {
                result.add(squareA);
            }
        }
        for (Square squareB : setB) {
            if (!setA.contains(squareB)) {
                result.add(squareB);
            }
        }
        return result;
    }

    public static List<Square> union(Collection<Square> setA, Collection<Square> setB) {
        Set<Square> result = new HashSet<>();
        for (Square squareA : setA) {
            result.add(squareA);
        }
        for (Square squareB : setB) {
            result.add(squareB);
        }
        return new ArrayList<>(result);
    }

    public static List<Square> complement(Collection<Square> setA, Collection<Square> setB) {
        List<Square> result = new ArrayList<>();
        boolean matched;
        for (Square squareA : setA) {
            matched = false;
            for (Square squareB : setB) {
                if (squareA.equals(squareB)) {
                    matched = true;
                }
            }
            if (!matched) {
                result.add(squareA);
            }
        }
        return result;
    }
}
