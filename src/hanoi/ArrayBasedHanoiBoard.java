package hanoi;

/**
 * A {@link ArrayBasedHanoiBoard} is a simple implementation of
 * {@link HanoiBoard}
 * 
 * @author jcollard
 * 
 */
public class ArrayBasedHanoiBoard implements HanoiBoard {


	/**
	 * Creates a {@link ArrayBasedHanoiBoard} with three empty {@link HanoiPeg}s
	 * and {@code n} rings on peg 0.
	 */
	HanoiPeg[] board = new HanoiPeg[3];
	public ArrayBasedHanoiBoard(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("n must be positive");
		}
		for(int i = 0; i < 3; i++) {
			board[i] = new StackBasedHanoiPeg();
		}
		for(int i = 0; i < n; i++) {
			board[0].addRing(new HanoiRing(n - i));
		}
	}

	@Override
	public void doMove(HanoiMove move) throws IllegalHanoiMoveException {
		HanoiPeg from = board[move.getFromPeg()];
		HanoiPeg to = board[move.getToPeg()];
		if(isLegalMove(move)) {
			to.addRing(from.remove());
		}
		else throw new IllegalHanoiMoveException("");
	}

	@Override
	public boolean isSolved() {
		return !board[0].hasRings() && !board[1].hasRings();
	}

	/**
	 * <p>
	 * A {@link HanoiMove} is not legal if either is true:
	 * 
	 * <ul>
	 * <li>The from peg has no rings</li>
	 * <li>The to peg has rings AND the ring to be moved has a size larger than
	 * the topmost ring on the to peg.</li>
	 * </ul>
	 * 
	 * Otherwise, the move is legal.
	 * </p>
	 */
	@Override
	public boolean isLegalMove(HanoiMove move) {
		HanoiPeg from = board[move.getFromPeg()];
		HanoiPeg to = board[move.getToPeg()];
        if(!from.hasRings()) {
        	return false;
        }
        if(to.hasRings() && to.getTopRing().getSize() <= from.getTopRing().getSize()) {
        	return false;
        }
        return true;
	}
}
