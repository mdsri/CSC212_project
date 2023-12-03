
public class ContactBST {
	BSTNode<Contact> root, current, q;

	/** Creates a new instance of BST */
	public ContactBST() {
		root = current = null;
	}

	public boolean empty() {
		return root == null;
	}

	public boolean full() {
		return false;
	}

	public Contact retrieve () {
		return current.data;
	}

	public boolean findkey(String tkey) {	//logn
		BSTNode<Contact> p = root,q = root;
		
		if(empty())
			return false;

		while(p != null) {
			q = p;
			if(p.key.equalsIgnoreCase(tkey)) {
				current = p;
				return true;
			}
			else if(tkey.compareToIgnoreCase(p.key) < 0)
				p = p.left;
			else
				p = p.right;
		}

		current = q;
		return false;
	}

	public boolean insert(String k, Contact val) { // logn inside logn
		BSTNode<Contact> p, q = current;

		if(findkey(k)) {
			current = q;  
			return false; 
		}

		p = new BSTNode<Contact>(k, val);
		if (empty()) {
			root = current = p;
			return true;
		}
		else {
			if (k.compareToIgnoreCase(current.key) < 0)
				current.left = p;
			else
				current.right = p;
			current = p;
			return true;
		}
	}
	
	public boolean remove_key (String tkey){ //logn
		boolean removed =  false;
		BSTNode<Contact> p;
		p = remove_aux(tkey, root, removed);
		current = root = p;
		return removed;
	}


	private BSTNode<Contact> remove_aux(String key, BSTNode<Contact> p, boolean flag) { //logn
		BSTNode<Contact> q, child = null;
		if(p == null)
			return null;
		if(key.compareToIgnoreCase(p.key) < 0)
			p.left = remove_aux(key, p.left, flag); //go left
		else if(key.compareToIgnoreCase(p.key) > 0)
			p.right = remove_aux(key, p.right, flag); //go right
		else { // key is found
			flag = true;
			if (p.left != null && p.right != null){ //two children
				q = find_min(p.right);
				p.key = q.key;
				p.data = q.data;
				p.right = remove_aux(q.key, p.right, flag);
			}
			else {
				if (p.right == null) //one child
					child = p.left;
				else if (p.left == null) //one child
					child = p.right;
				return child;
			}
		}
		return p;
	}


	private BSTNode<Contact> find_min(BSTNode<Contact> p){ //mdry
		if(p == null)
			return null;

		while(p.left != null){
			p = p.left;
		}

		return p;
	}


	public boolean update(String key, Contact data){ //2 logn
		remove_key(current.key);
		return insert(key, data);
	}

	public boolean removeKey(String k) { //logn
		  String k1 = k;
		  BSTNode<Contact> p = root;
		  BSTNode<Contact> q = null; // Parent of p
		  while (p != null) {
		    if (k1.compareToIgnoreCase(p.key) < 0) {
		      q = p;
		      p = p.left;
		    } else if (k1.compareToIgnoreCase(p.key) > 0) {
		      q = p;
		      p = p.right;
		    } else { // Found the key, Check the three cases
		      if ((p.left != null) && (p.right != null)) { 
		      // Case 3: search for min in the right subtree
		        BSTNode<Contact> min = p.right;
		        q = p;
		        while (min.left != null) {
		          q = min;
		          min = min.left;
		        }
		        p.key = min.key;
		        p.data = min.data;
		        k1 = min.key;
		        p = min;
		      }// Now fall back to either case 1 or 2
		      // The subtree rooted at p will change here
		      if (p.left != null) // One child
		        p = p.left;
		      else // One or no children
		        p = p.right;
		      if (q == null)//No parent for p, root must change
		        root = p;
		      else 
		         if (k1.compareToIgnoreCase(q.key) < 0)
		           q.left = p;
		         else
		            q.right = p;
		      current = root;
		      return true;
		    } 
		  }
		  return false; // Not found
		}
	////////////////////////////////////////////////////////
	static boolean b = false;
	public boolean search(String s) { //n
		b = false;
		q = null;
		search2(root, s);
		return b;
	}
	
	private void search2(BSTNode<Contact> p, String s) { //n
		if(p == null)
			return;
		search2(p.left, s);
		if(p.data.getName().equalsIgnoreCase(s) ||
				p.data.getphNumber().equalsIgnoreCase(s) ||
				p.data.getBirthday().equalsIgnoreCase(s) ||
				p.data.getAddress().equalsIgnoreCase(s) ||
				p.data.getEmail().equalsIgnoreCase(s)) {
			q = p;
			b = true;
		}
		search2(p.right, s);
	}
	
	public boolean searchAndDisplay(String s) { //n
		b = false;
		q = null;
		searchAndDisplay2(root, s);
		return b;
	}
	
	private void searchAndDisplay2(BSTNode<Contact> p, String s) { //n
		if(p == null)
			return;
		searchAndDisplay2(p.left, s);
		if(p.data.getName().equalsIgnoreCase(s) ||
				p.data.getphNumber().equalsIgnoreCase(s) ||
				p.data.getBirthday().equalsIgnoreCase(s) ||
				p.data.getAddress().equalsIgnoreCase(s) ||
				p.data.getEmail().equalsIgnoreCase(s)) {
			System.out.println(p.data.toString());
			q = p;
			b = true;
		}
		searchAndDisplay2(p.right, s);
	}
	
	public Contact retrieveSearch () { //1
		return q.data;
	}
	///////////////////////////////////////
	
	public void printFirstName(String n) { //n
		BSTNode<Contact> p = root;
		printFirstN(p, n);
	}
	
	private void printFirstN(BSTNode<Contact> p, String n) { //n
		if(p == null)
			return;
		printFirstN(p.left, n);
        if(p.data.getName().length() >= n.length()
				&& p.data.getName().substring(0, n.length()).equalsIgnoreCase(n)) 
        	System.out.println(p.data.toString());
        printFirstN(p.right, n);
	}
	
	public void printAllContactsName() { //n
		BSTNode<Contact> p = root;
		printAllContactsName2(p);
	}
	
	private void printAllContactsName2(BSTNode<Contact> p) { //n
		if(p == null)
			return;
		printAllContactsName2(p.left); 
		System.out.print(p.data.getName()+" ");
		printAllContactsName2(p.right);
	}
	
	public void printAllContactsDetails() { //n
		BSTNode<Contact> p = root;
		printAllContactsDetails2(p);
	}
	
	private void printAllContactsDetails2(BSTNode<Contact> p) { //n
		if(p == null)
			return;
		printAllContactsDetails2(p.left); 
		System.out.println(p.data.toString());
		printAllContactsDetails2(p.right);
	}
	
}



