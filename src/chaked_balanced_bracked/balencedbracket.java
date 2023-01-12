package chaked_balanced_bracked;


class node{
	node next;
	char data;
	node(char d){
		data= d;
		next = null;
		
	}
}


class mystack{
	node head;
	int size ;
	
	mystack(){
		head= null;
		size = 0;
		
	}
	
	void push( char x,mystack list)
	{
		node temp = new node(x);
		temp.next = list.head;
		list.head = temp;
		size = size+1;
		
	}
	
	 char  pop(mystack list) {
		char res = ' ';
		if(list.head== null) {
			System.out.print("head is null");
			
		}
		// there is an error when we try to pop data when the stack is already null;
		// at that case res putting exception error  
		else {
			 res = list.head.data;
			
			node temp=  list.head;
			list.head= temp.next;
		
			
			
		}
		return res;
	}
	boolean isEmpty(mystack list) {
		return list.head==null;
		
	}

		
		
		static boolean areBracketsBalanced(String expr,mystack list) {
			
			 for (int i = 0; i < expr.length(); i++) {
				 char x = expr.charAt(i);
			 
			 if (x == '(' || x == '[' || x == '{') {
				 list.push(x,list);
				 continue;
			 }
			 
			 if (list.isEmpty(list))
					return false;
			 
			 char check;
				switch (x) {
				case ')':
					check = list.pop(list);
					if (check == '{' || check == '[')
						return false;
					break;

				case '}':
					check = list.pop(list);
					if (check == '(' || check == '[')
						return false;
					break;

				case ']':
					check = list.pop(list);
					if (check == '(' || check == '{')
						return false;
					break;
				}
			 }
			 return (list.isEmpty(list));
				 
	
	}
}
		
public class balencedbracket {
	public static void main(String args[] ){
		mystack list = new mystack();
		 String expr = "([{}]))";
		 if (list.areBracketsBalanced(expr,list )) {
			 System.out.println("Balanced ");
			 
		 }
				
			else {
				System.out.println("Not Balanced ");
				
			}
				
			
	}
		
		 
		
	}
	


