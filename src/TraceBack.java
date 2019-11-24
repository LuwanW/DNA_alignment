
public class TraceBack {
    private static Alignment traceback(Sequence s1, Sequence s2, Matrix m,
            byte[][] pointers, Cell cell) {
        char[] array1 = s1.toArray();
        char[] array2 = s2.toArray();
        float[][] scores = m.getScores();

        Alignment alignment = new Alignment();
        alignment.setScore(cell.getScore());

        // maximum length after the aligned sequences
        int maxlen = s1.length() + s2.length();

        char[] reversed1 = new char[maxlen]; // reversed sequence #1
        char[] reversed2 = new char[maxlen]; // reversed sequence #2
        char[] reversed3 = new char[maxlen]; // reversed markup

        int len1 = 0; // length of sequence #1 after alignment
        int len2 = 0; // length of sequence #2 after alignment
        int len3 = 0; // length of the markup line

        int identity = 0; // count of identitcal pairs
        int similarity = 0; // count of similar pairs
        int gaps = 0; // count of gaps

        char c1, c2;

        int i = cell.getRow(); // traceback start row
        int j = cell.getCol(); // traceback start col

        // Traceback flag, where true => continue and false => stop
        boolean stillGoing = true;
        while (stillGoing) {
            switch (pointers[i][j]) {
            case Directions.UP:
                reversed1[len1++] = array1[--i];
                reversed2[len2++] = Alignment.GAP;
                reversed3[len3++] = Markups.GAP;
                gaps++;
                break;
            case Directions.DIAGONAL:
                c1 = array1[--i];
                c2 = array2[--j];
                reversed1[len1++] = c1;
                reversed2[len2++] = c2;
                if (c1 == c2) {
                    reversed3[len3++] = Markups.IDENTITY;
                    identity++;
                    similarity++;
                } else if (scores[c1][c2] > 0) {
                    reversed3[len3++] = Markups.SIMILARITY;
                    similarity++;
                } else {
                    reversed3[len3++] = Markups.MISMATCH;
                }
                break;
            case Directions.LEFT:
                reversed1[len1++] = Alignment.GAP;
                reversed2[len2++] = array2[--j];
                reversed3[len3++] = Markups.GAP;
                gaps++;
                break;
            case Directions.STOP:
                stillGoing = false;
            }
        }

        alignment.setSequence1(reverse(reversed1, len1));
        alignment.setStart1(i);
        alignment.setSequence2(reverse(reversed2, len2));
        alignment.setStart2(j);
        alignment.setMarkupLine(reverse(reversed3, len3));
        alignment.setIdentity(identity);
        alignment.setGaps(gaps);
        alignment.setSimilarity(similarity);

        return alignment;
    }

}
