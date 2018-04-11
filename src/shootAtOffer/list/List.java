package shootAtOffer.list;
/**
 * 剑指offer链表相关习题
 * @author wuzijian
 *
 */
public class List {
	//从头到尾打印链表
	public static void print(Node head) {
		Node p = head;
		System.out.print("[ ");
		while(p!=null) {
			System.out.print(p.value+" ");
			p = p.next;
		}
		System.out.print("]\n");
	}
	//从尾到头打印链表,利用函数栈来实现倒序打印
	public static void printReverseLy(Node head) {
		if(head == null) return;
		printReverseLy(head.next	);
		System.out.print(head.value + " ");
	}

	//尾插法
	public static void addToTail(Node head, int value) {
		Node node = new Node(value, null);
		if(head == null) {
			head = node;
		}
		else {
			Node p = head;
			while(p.next!=null) {
				p = p.next;
			}
			p.next = node;
		}
	}
	//删除指定结点	 时间复杂度为O(n)
	public static Node removeNode(Node head, int value) {
		if(head == null) return null;
		Node p = new Node();
		//若要删的结点是头结点
		if(head.value == value) {
			return head.next;
		} else {
			 p = head;
			while(p.next!=null && p.next.value != value) {
				p = p.next; 
			}
			//找到要删的结点或者链表中没有值是value的结点
			if(p.next !=null && p.next.value == value) {
				p.next = p.next.next;
			} 
			return head;
		}
	}
	//删除列表结点 要求时间复杂度为O(1)
	public static void deleteNode(Node head, Node node) {
		if(head == null || node == null) return;
		//要删除的结点不是尾结点
		if(node.next!=null) {
			Node pNext = node.next;
			node.value = pNext.value;
			node.next = pNext.next;
			pNext = null;
			
		}
		//如果链表中只有一个结点
		else if(head == node) {
			head = null;
		}
 		//如果是尾结点只能从头遍历
		else {
			Node p = head;
			Node s = null;
			while(p.next!=null) {
				s = p;
				p = p.next;
			}
			s.next = null;
		}
	}
	//删除链表中重复的结点
	public static void deleteDuplication(Node head) {
		
	}
	//返回链表中倒数第k个结点
	/**
	 * 普通思路
	 * 遍历链表，找到链表结点的总数n
	 * 倒数第k个结点就是正数n-k+1
	 * 优化思路
	 * 利用两个指针，且两个指针中间隔着k-1个结点
	 * 当第一个指针达到列表结尾时，另一个指针刚好达到倒数第k的结点
	 * 注意程序的鲁棒性
	 * @param head
	 * @param k
	 * @return
	 */
	public static Node findKthToTail(Node head, int k) {
		if(head == null || k <= 0) return null;
		Node preNode = head;
		Node suffNode = null;
		for(int i = 0; i < k-1; i++) {
			if(preNode.next==null) {
				return null;
			}
			preNode = preNode.next;
		}
		suffNode = head;
		while(preNode.next!=null) {
			preNode = preNode.next;
			suffNode = suffNode.next;
		}
		
		return suffNode;
	}
	//求链表中环的入口点\
	/**
	 * 思路
	 * 判断是否有环——使用两个指针，一个先遍历，一个后遍历，若先遍历的追上后遍历的，则有环，并返回两指针相遇的结点
	 * 若有环返回了相遇指针后，向后遍历环，并累加结点数，当再次访问到相遇结点时，计算完毕为m
	 * 再像求倒数第k个结点一样利用两个指针求出环入口，一个指针先遍历m-1个结点，在一起遍历，知道相遇，该相遇结点为入口
	 * 
	 */
	//判断是否有环，有环则返回相遇结点
	private static Node meetingNode(Node head) {
		if(head == null) return null;
		Node suff = head.next;
		if(suff == null) return null;
		Node pre = suff.next;
		while(pre.next!=null && suff.next!=null) {
			if(pre == suff) return pre;
			suff = suff.next;
			pre = pre.next;
			if(pre!=null)
				pre = pre.next;
		}
		return null;
	}
	public static Node entryNodeOfLoop(Node head) {
		Node node = meetingNode(head);
		if(node == null) return null;
		Node t = node;
		int sumOfCircus = 1;
		while(t.next != node) {
			t = t.next;
			++sumOfCircus;
		}
		Node p = head;
		Node s = head;
		for (int i = 0; i < sumOfCircus; i++) {
			p = p.next;
		}
		while(s!= p) {
			p = p.next;
			s = s.next;
		}
		return s;
	}
	//反转链表
	/**
	 * 思路
	 * 需要三个指针
	 * 一个指向当前结点，一个指向它的前缀结点，一个保存它的后续结点
	 * 还有一个指针指向反转之后的头结点
	 * @param head
	 * @return
	 */
	public static Node reverseList(Node head) {
		if(head == null) return null;
		Node reversedHead = null;
		Node pNode = head;
		Node preNode = null;
		while(pNode != null) {
			Node nextNode = pNode.next;
			if(nextNode == null) {
				reversedHead = pNode;
			}
			pNode.next = preNode;
			preNode = pNode;
			pNode = nextNode;
		}
		return reversedHead;
	}
	//合并两个排序的链表
	/**
	 * 思路
	 * 递归实现
	 * 每次比较头结点的值
	 * @param head1
	 * @param head2
	 * @return
	 */
	public static Node merge(Node head1, Node head2) {
		if(head1 == null) return head2;
		else if(head2==null) return head1;
		Node mergeHead = null;
		if(head1.value > head2.value) {
			head2.next = merge(head1, head2.next);
			mergeHead = head2;
		} else {
			head1.next = merge(head1.next, head2);
			mergeHead = head1;
		}
		return mergeHead;
	}
	

	
}
