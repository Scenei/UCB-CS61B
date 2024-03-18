public class IntList {
	public int first;
	public IntList rest;

	/** Constructor */
	public IntList(int f, IntList r) {
		first = f;
		rest = r;
	}

	/** Return the size of the list using... recursion! */
	public int size() {
		if (this.rest == null) {
			return 1;
		}
		else {
			return 1 + this.rest.size();
		}
	}

	/** Return the size of the list using no recursion! */
	public int iterativeSize() {
		int total = 0;
		IntList p = this;
		while (p != null) {
			total += 1;
			p = p.rest;
		}
		return total;
	}

	/** Returns the ith value in this list.*/
	public int get(int i) {
		if (i == 0) {
			return this.first;
		}
		else {
			return this.rest.get(i-1);
		}
	}

	/** Returns an IntList identical to L, but with
	 * each element incremented by x. L is not allowed
	 * to change. */
	public static IntList incrList(IntList L, int x) {
		/* Your code here. */
		if (L == null) {
			return null;
		}
		else {
			IntList p = new IntList(L.first + x, null);
			p.rest = incrList(L.rest, x);
			return p;
		}
	}

	/** Returns an IntList identical to L, but with
	 * each element incremented by x. Not allowed to use
	 * the 'new' keyword. */
	public static IntList dincrList(IntList L, int x) {
		/* Your code here. */
		IntList p = L;
		while (p != null) {
			p.first += x;
			p = p.rest;
		}
		return L;
	}

	public static void main(String[] args) {
		IntList L = new IntList(15, null);
		L = new IntList(10, L);
		L = new IntList(5, L);
		L = new IntList(1, L);

		// System.out.println(L.size());
		// System.out.println(L.iterativeSize());
		// System.out.println(L.get(2));
	}
}