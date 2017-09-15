public class LinkedListDeque<Item> {

	private Node sentinel;
	private int size;

	public class Node {
		public Item item;
		public Node prev;
		public Node next;

		public Node(Item i, Node h, Node j) {
			item = i;
			prev = h;
			next = j;
		}
	}

	/** Creates an empty list */
	public LinkedListDeque() {
		size = 0;
		sentinel = new Node(null, null, null);
		sentinel.next = sentinel;
		sentinel.prev = sentinel;
	}

	public LinkedListDeque(Item x) {
		size = 1;
		sentinel = new Node(null, null, null);
		Node newNode = new Node(x, sentinel, sentinel);
		sentinel.prev = newNode;
		sentinel.next = newNode;
	}

	/** Adds an item to the front of the Deque */
	public void addFirst(Item x) {
		Node oldFrontNode = sentinel.next;
		Node newNode = new Node(x, sentinel, oldFrontNode);
		sentinel.next = newNode;
		oldFrontNode.prev = sentinel.next;
		size += 1;

	}

	/** Adds an item to the back of the Deque */
	public void addLast(Item x) {
		Node oldBackNode = sentinel.prev;
		Node newNode = new Node(x, oldBackNode, sentinel);
		sentinel.prev = newNode;
		oldBackNode.next = sentinel.prev;
		size += 1;

	}

	/** Returns true if deque is empty, false otherwise. */
	public boolean isEmpty() {
		if (sentinel.next == sentinel && sentinel.prev == sentinel) {
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
		Node displayNode = sentinel.next;

		for (int i = 0; i < size; i++) {
			System.out.print(displayNode.item + " ");
			displayNode = displayNode.next;
		}

		System.out.println();
	}

	/** Removes and returns the item at the front of the Deque. If no such item exists, returns null. */
	public Item removeFirst() {
		Node oldFirstNode = sentinel.next;
		Node oldSecNode = sentinel.next.next;
		sentinel.next = oldSecNode;
		oldSecNode.prev = sentinel;
		size -= 1;
		return oldFirstNode.item;
	}

	/** Removes and returns the item at the back of the Deque. If no such item exists, returns null. */
	public Item removeLast() {
		Node oldLastNode = sentinel.prev;
		Node oldSecLastNode = sentinel.prev.prev;
		sentinel.prev = oldSecLastNode;
		oldSecLastNode.next = sentinel;
		size -= 1;
		return oldLastNode.item;
	}

	/** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null.  */
	public Item get(int index) {
		Node getItem = sentinel.next;
		if (index >= size) {
			return null;
		}
		else {
			for (int i = 0; i < index; i++ ) {
			getItem = getItem.next;
		}
		return getItem.item;
		}
		
	}

	public Item getRecursive(int index) {
		Node getItem = sentinel.next;
		int i = 0;
		if (index >= size) {
			return null;
		}
		else if (index == 0) {
			return getItem.item;
		}
		else {
			while (index > 0) {
				getItem = getItem.next;
				getRecursive(index - 1);
			}
			return getItem.item;
		}
	}
}