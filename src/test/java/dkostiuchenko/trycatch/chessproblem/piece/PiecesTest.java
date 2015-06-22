package dkostiuchenko.trycatch.chessproblem.piece;

import dkostiuchenko.trycatch.chessproblem.Board;
import org.junit.Test;

import static dkostiuchenko.trycatch.chessproblem.TestUtils.failureMsg;
import static dkostiuchenko.trycatch.chessproblem.piece.Pieces.BISHOP;
import static dkostiuchenko.trycatch.chessproblem.piece.Pieces.KING;
import static dkostiuchenko.trycatch.chessproblem.piece.Pieces.KNIGHT;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PiecesTest {

    @Test
    public void kingCanAttack() {
        Board b;

        b = new Board(5, 5);
        b.set(BISHOP, 2, 3);
        assertTrue(failureMsg(b), KING.canAttackFrom(b, 2, 2));

        b = new Board(5, 5);
        b.set(BISHOP, 3, 3);
        assertTrue(failureMsg(b), KING.canAttackFrom(b, 2, 2));

        b = new Board(5, 5);
        b.set(BISHOP, 3, 2);
        assertTrue(failureMsg(b), KING.canAttackFrom(b, 2, 2));

        b = new Board(5, 5);
        b.set(BISHOP, 3, 1);
        assertTrue(failureMsg(b), KING.canAttackFrom(b, 2, 2));

        b = new Board(5, 5);
        b.set(BISHOP, 2, 1);
        assertTrue(failureMsg(b), KING.canAttackFrom(b, 2, 2));

        b = new Board(5, 5);
        b.set(BISHOP, 1, 1);
        assertTrue(failureMsg(b), KING.canAttackFrom(b, 2, 2));

        b = new Board(5, 5);
        b.set(BISHOP, 1, 2);
        assertTrue(failureMsg(b), KING.canAttackFrom(b, 2, 2));

        b = new Board(5, 5);
        b.set(BISHOP, 1, 3);
        assertTrue(failureMsg(b), KING.canAttackFrom(b, 2, 2));
    }

    @Test
    public void kingCanNotAttack() {
        Board b = new Board(5, 5);
        b.set(BISHOP, 0, 0);
        b.set(BISHOP, 1, 0);
        b.set(BISHOP, 2, 0);
        b.set(BISHOP, 3, 0);
        b.set(BISHOP, 4, 0);
        b.set(BISHOP, 4, 1);
        b.set(BISHOP, 4, 2);
        b.set(BISHOP, 4, 3);
        b.set(BISHOP, 4, 4);
        b.set(BISHOP, 3, 4);
        b.set(BISHOP, 2, 4);
        b.set(BISHOP, 1, 4);
        b.set(BISHOP, 0, 4);
        b.set(BISHOP, 0, 3);
        b.set(BISHOP, 0, 2);
        b.set(BISHOP, 0, 1);

        assertFalse(failureMsg(b), KING.canAttackFrom(b, 2, 2));
    }


    @Test
    public void knightCanAttack() {
        Board b;

        b = new Board(5, 5);
        b.set(BISHOP, 0, 3);
        assertTrue(failureMsg(b), KNIGHT.canAttackFrom(b, 2, 2));

        b = new Board(5, 5);
        b.set(BISHOP, 1, 4);
        assertTrue(failureMsg(b), KNIGHT.canAttackFrom(b, 2, 2));

        b = new Board(5, 5);
        b.set(BISHOP, 3, 4);
        assertTrue(failureMsg(b), KNIGHT.canAttackFrom(b, 2, 2));

        b = new Board(5, 5);
        b.set(BISHOP, 4, 3);
        assertTrue(failureMsg(b), KNIGHT.canAttackFrom(b, 2, 2));

        b = new Board(5, 5);
        b.set(BISHOP, 4, 1);
        assertTrue(failureMsg(b), KNIGHT.canAttackFrom(b, 2, 2));

        b = new Board(5, 5);
        b.set(BISHOP, 3, 0);
        assertTrue(failureMsg(b), KNIGHT.canAttackFrom(b, 2, 2));

        b = new Board(5, 5);
        b.set(BISHOP, 1, 0);
        assertTrue(failureMsg(b), KNIGHT.canAttackFrom(b, 2, 2));

        b = new Board(5, 5);
        b.set(BISHOP, 0, 1);
        assertTrue(failureMsg(b), KNIGHT.canAttackFrom(b, 2, 2));
    }
    @Test
    public void knightCanNotAttack() {
        Board b = new Board(5, 5);
        fillInBoard(b, BISHOP);
        b.set(null, 0, 3);
        b.set(null, 1, 4);
        b.set(null, 3, 4);
        b.set(null, 4, 3);
        b.set(null, 4, 1);
        b.set(null, 3, 0);
        b.set(null, 1, 0);
        b.set(null, 0, 1);

        assertFalse(failureMsg(b), KNIGHT.canAttackFrom(b, 2, 2));
    }

    private void fillInBoard(Board b, Pieces piece) {
        for (int rank = 0; rank < b.ranks(); rank++) {
            for(int file = 0; file < b.files(); file++) {
                b.set(piece, file, rank);
            }
        }
    }
}