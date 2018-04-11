package shootAtOffer.list;

public class TestList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(0, null);
		Node head2 = new Node(1, null);
		Node node = null;
		for (int i = 1; i < 5; i++) {
			List.addToTail(head, i*2);
		}
		for (int i = 2; i < 5; i++) {
			List.addToTail(head2, i*2-1);
		}
		List.print(head);
		List.print(head2);
//		head = List.removeNode(head, 6);
//		List.print(head);
//		List.printReverseLy(head);
//		System.out.println((node=List.findKthToTail(head, 5))!=null?node.value:null);
//		head = List.reverseList(head);
//		List.print(head);
		head = List.merge(head, head2);
		List.print(head);
	}

}
