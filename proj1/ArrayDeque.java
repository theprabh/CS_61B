class ArrayDeque<Item> {

	Item[] items;
	private int size;

	public ArrayDeque() {
		size = 0;
		items = (Item[]) new Object[8];
	}

	private void resize(int capacity) {
		Item[] temp = (Item[]) new Object[capacity];
		System.arraycopy(items, 0, temp, 0, size - 1);
		items = temp;
	}

	private double getUsageRatio() {
		double ratio = (double) size / items.length;
		return ratio;
	}

	private void addCheck() {
		if (size == items.length) {
			resize(size * 2);
		}
	}

	private void deleteCheck() {
		System.out.println(getUsageRatio());
		if (getUsageRatio() < .25) {
			resize(items.length / 2);
		}
	}

	/** Adds an item to the front of the Deque */
	public void addFirst(Item x) {
		addCheck();
		Item[] temp = (Item[]) new Object[items.length];
		temp[0] = x;
		System.arraycopy(items, 0, temp, 1, size);
		items = temp;
		size += 1;
	}

	/** Adds an item to the back of the Deque */
	public void addLast(Item x) {
		addCheck();
		items[size] = x;
		size += 1;
	}

	/** Returns true if deque is empty, false otherwise. */
	public boolean isEmpty() {
		if (items[0] == null) {
			return true;
		}
		else {
			return false;
		}
	}

	/** Returns the number of items in the Deque */
	public int size() {
		return size;
	}

	/** Prints the items in the Deque form first to last, sperated by a space. */
	public void printDeque() {
		for (int i = 0; i < size; i++) {
			System.out.println(items[i]);
		}
	}

	/** Removes and returns the item at the front of the Deque. If no such item exists, returns null. */
	public Item removeFirst() {
		deleteCheck();
		Item itemToReturn = items[0];
		Item [] temp = (Item []) new Object[items.length];
		System.arraycopy(items, 1, temp, 0, size - 1);
		size -= 1;
		return itemToReturn;

	}

	/** Removes and returns the item at the back of the Deque. If no such item exists, returns null. */
	public Item removeLast() {
		deleteCheck();
		Item itemToReturn = items[size];
		items[size - 1] = null;
		size -= 1;
		return itemToReturn;
	}

	/** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null.  */
	public Item get(int index) {
		return items[index];
	}
}