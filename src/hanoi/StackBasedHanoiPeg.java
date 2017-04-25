package hanoi;

import structures.LinkedStack;
import structures.StackInterface;

/**
 * A {@link StackBasedHanoiPeg} is a {@link HanoiPeg} backed by a
 * {@link LinkedStack}
 * 
 * @author jcollard
 *
 */
public class StackBasedHanoiPeg implements HanoiPeg {
	
	private StackInterface<HanoiRing> stack;
	public StackBasedHanoiPeg() {
		stack = new LinkedStack<HanoiRing>();
	}

	@Override
	public void addRing(HanoiRing ring) throws IllegalHanoiMoveException {
		if(ring == null) {
			throw new NullPointerException("ring is null");
		}
		if(!stack.isEmpty() && stack.peek().getSize() <= ring.getSize()){
			throw new IllegalHanoiMoveException("ring must be smaller than the top ring of the peg");
		}
		stack.push(ring);
	}

	@Override
	public HanoiRing remove() throws IllegalHanoiMoveException {
        if(stack.isEmpty()) {
        	throw new IllegalHanoiMoveException("Cannot call remove on empty peg");
        }
        return stack.pop();
	}

	@Override
	public HanoiRing getTopRing() throws IllegalHanoiMoveException {
        if(stack.isEmpty()) {
        	throw new IllegalHanoiMoveException("No ring to return");
        }
        return stack.peek();
	}

	@Override
	public boolean hasRings() {
        return(!stack.isEmpty());
	}
}
