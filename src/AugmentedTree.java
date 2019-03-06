
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;




	public class AugmentedTree <T>{ private final int RED = 0;
    private final int BLACK = 1;

    private class Node<T> {
    	private T id;private Date date;private int count,age;
        int key = -1, color = BLACK;
        Node left = nil, right = nil, parent = nil;
        Node(T id,Date date){
        	this.date=date;
        	this.id=id;
         	this.count=0;
         	this.age=2018-date.year;
         	this.key=(30*date.day)+(12*date.month)+(2018*date.year);
        }
        
        Node(int key) {
            this.key = key;
        }
        Node(Date date){
        	this.date=date;
        	this.key=(30*date.day)+(12*date.month)+(2018*date.year);
        	
        }
        
    }

    private final Node nil = new Node(-1); 
    Node root = nil;
	static int count=0;
	
    
    
    public void Reader(String file2) throws IOException  {
		BufferedReader bufferedReader = null;
		 String line;
		 File file=new File(file2);
		 FileReader fileReader =new FileReader(file);
		 bufferedReader=new BufferedReader(fileReader);				
		 
		 while ((line = bufferedReader.readLine()) != null) {//read stroy line by line
			 String [] splittedLine=line.split(",");
			 T id=(T)splittedLine[0];
			 String date3=splittedLine[1];
			 String[]date2=date3.split("/");
			 int day=Integer.parseInt(date2[0]);
			 int month=Integer.parseInt(date2[1]);
			 int year=Integer.parseInt(date2[2]);
			 Date date=new Date(day,month,year);
			 Node person=new Node(id,date);	 
				 
			System.out.print("|");
			//System.out.println(person.date.getDay()+" "+person.date.getMonth()+" "+person.date.getYear());
			 insert(person);//put function called
			 	 
								 
			 } 
		 System.out.println("Read Completed");
		 fileReader.close();
		 bufferedReader.close();
		 }

		 
		 
	
    public void getNumSmaller1(String string) {
    	count=0;
    	String[] date2=string.split("/");
    	int day=Integer.parseInt(date2[0]);
    	int month=Integer.parseInt(date2[1]);
    	int year=Integer.parseInt(date2[2]);
    	Date date=new Date(day,month,year);
    	Node node=new Node(date);
    	Node temp=root;
 
    	Node node1=calTree(temp,node);
    	if(node1!=nil) {
    		System.out.println("The result of getNumSmaller1 for the node with birthdate "+node1.date.day+"/"+node1.date.month+"/"+node1.date.year+" is "+node1.count);
    	}
    }
    public void getNumSmaller2(T id) {
    	travelTree(root,id);
    }
    public void travelAug(Node node) {
    	if(node==nil) {
    		return;
    	}
    	travelAug(node.left);
    	node.count++;
    	travelAug(node.right);
    }
    public void insertOnMain(String string) {
    	String[] string2=string.split(",");
    	String[]date2=string2[1].split("/");
    	T id =(T)string2[0];
    	int day=Integer.parseInt(date2[0]);int month=Integer.parseInt(date2[1]);int year=Integer.parseInt(date2[2]);
    	Date date =new Date(day,month,year);
    	Node node =new Node(id,date);
    	insert(node);
    }
    
    public void augMethod(Node node,Node node2) {
    	
    	while(node2.date!=node.date) {
    		
    		if(isBigger(node.parent, node)) {
    			node.parent.count++;
    			travelAug(node.parent.right);
    		}
    		node=node.parent;
    	}
    		
    	
    }
    public int size(Node root) {
    	if(root==nil) {
    		return 0;
    	}
    	return (size(root.left) + 1 + size(root.right));
    }
    public void getMax(Node root) {
    	if(root==nil) {
    		return;
    	}
    	getMax(root.right);
    	if(root.right==nil) {
    		System.out.println("The maximum age of all people is "+root.age+", id"+root.id+",birthdate :"+root.date.day+"/"+root.date.month+"/"+root.date.year);
    		return;
    	}
    }
    public void getMin(Node root) {
    	if(root==nil) {
    		return;
    	}
    	getMin(root.left);
    	if(root.left==nil) {
    		System.out.println("The minimum age of all people is "+root.age+", id: "+root.id+", bdate: "+root.date.day+"/"+root.date.month+"/"+root.date.year);
    		return;
    	}
    }
    
    
    
    
    public Node calTree(Node node1,Node node2) {		//getNumSmaller1
    		if(node1==nil) {return null;}
    		
            
            if (node1.key < node2.key) {
                if (node1.left != nil) {
                    return calTree(node1.left, node2);
                }
            } else if (node1.key > node2.key) {
                if (node1.right != nil) {
                    return calTree(node1.right, node2);
                }
            } else if (node1.key==node2.key) {
            	node2.id=node1.id;node2.count=node1.count;
                return node2;
            }
            return null;
        }
   			
     
    
    public void travelTree(Node root,T id) {  //getNumSmaller2
    	if (root==nil) {
    		return;
    	}
    	travelTree(root.left,id);
    	if(id.equals(root.id)) {
    		System.out.println("The result of getNumSmaller2 for the node with birthdate "+root.date.day+"/"+root.date.month+"/"+root.date.year+" id :"+root.id+" count : "+root.count);
    		return;
    	}
    	travelTree(root.right,id);
    
    }

    public void printTree(Node node) {
        if (node == nil) {
            return;
        }
        printTree(node.left);
        System.out.print(((node.color==RED)?"Color: Red ":"Color: Black ")+"Key: "+node.id+" Parent: "+node.parent.id+" bdate : "+node.date.day+"/"+node.date.month+"/"+node.date.year+"  Count: "+node.count+"\n");
        printTree(node.right);
    }

    private Node findNode(Node findNode, Node node) {
        if (root == nil) {
            return null;
        }
        
        if (findNode.key < node.key) {
            if (node.left != nil) {
                return findNode(findNode, node.left);
            }
        } else if (findNode.key > node.key) {
            if (node.right != nil) {
                return findNode(findNode, node.right);
            }
        } else if (findNode.key == node.key) {
        	node.id=findNode.id;
            return node;
        }
        return null;
    }

    private void insert(Node node) {
        Node temp = root;
        if (root == nil) {
            root = node;
            node.color = BLACK;
            node.parent = nil;
        } else {
            node.color = RED;
            while (true) {
            if(!isBigger(node,temp)) {    	
                    	if (temp.left == nil) {
                    		temp.left = node;
                    		node.parent = temp;
                    	 break;
                    } else {
                        temp = temp.left;
                    }
                }
            else{
                    if (temp.right == nil) {
                        temp.right = node;
                        node.parent = temp;
                        break;
                    } else {
                        temp = temp.right;
                    }
                }
            }

            
            
            augMethod(node,root);
            if(node==node.parent.left) {
            	node.count=node.parent.count-1;
            }
            else {
            	node.count=node.parent.count+1;
            }
            fixTree(node);
       }
        
	}
    
    public Boolean isBigger(Node node,Node node2) {//node istedigim node2 sordugum
    	if(node.date.year>node2.date.year) {return false;
    	}
    	
    	else if(node.date.year<node2.date.year) {
    		return true;
    	}
    	else {
    		if(node.date.month>node2.date.month) {
    			return false;
    		}
    		else if(node.date.month<node2.date.month) return true;
    		else {
    			if(node.date.day>node2.date.day) {
    				return false;
    			}
    			else if(node.date.day<node2.date.day)return true;
    			else return false;
    		}
    	}
    		
    	
    }

    //Takes as argument the newly inserted node
    private void fixTree(Node node) {
        while (node.parent.color == RED) {
            Node uncle = nil;
            if (node.parent == node.parent.parent.left) {
                uncle = node.parent.parent.right;

                if (uncle != nil && uncle.color == RED) {
                    node.parent.color = BLACK;
                    uncle.color = BLACK;
                    node.parent.parent.color = RED;
                    node = node.parent.parent;
                    continue;
                } 
                if (node == node.parent.right) {
                    //Double rotation needed
                    node = node.parent;
                    rotateLeft(node);
                } 
                node.parent.color = BLACK;
                node.parent.parent.color = RED;
                //if the "else if" code hasn't executed, this
                //is a case where we only need a single rotation 
                rotateRight(node.parent.parent);
            } else {
                uncle = node.parent.parent.left;
                 if (uncle != nil && uncle.color == RED) {
                    node.parent.color = BLACK;
                    uncle.color = BLACK;
                    node.parent.parent.color = RED;
                    node = node.parent.parent;
                    continue;
                }
                if (node == node.parent.left) {
                    //Double rotation needed
                    node = node.parent;
                    rotateRight(node);
                }
                node.parent.color = BLACK;
                node.parent.parent.color = RED;
                //if the "else if" code hasn't executed, this
                //is a case where we only need a single rotation
                rotateLeft(node.parent.parent);
            }
        }
        root.color = BLACK;
    }

    void rotateLeft(Node node) {
        if (node.parent != nil) {
            if (node == node.parent.left) {
                node.parent.left = node.right;
            } else {
                node.parent.right = node.right;
            }
            node.right.parent = node.parent;
            node.parent = node.right;
            if (node.right.left != nil) {
                node.right.left.parent = node;
            }
            node.right = node.right.left;
            node.parent.left = node;
        } else {//Need to rotate root
            Node right = root.right;
            root.right = right.left;
            right.left.parent = root;
            root.parent = right;
            right.left = root;
            right.parent = nil;
            root = right;
        }
    }

    void rotateRight(Node node) {
        if (node.parent != nil) {
            if (node == node.parent.left) {
                node.parent.left = node.left;
            } else {
                node.parent.right = node.left;
            }

            node.left.parent = node.parent;
            node.parent = node.left;
            if (node.left.right != nil) {
                node.left.right.parent = node;
            }
            node.left = node.left.right;
            node.parent.right = node;
        } else {//Need to rotate root
            Node left = root.left;
            root.left = root.left.right;
            left.right.parent = root;
            root.parent = left;
            left.right = root;
            left.parent = nil;
            root = left;
        }
    }

    
    
    
    	}

