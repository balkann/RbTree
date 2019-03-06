import java.io.IOException;
import java.util.Scanner;



public class Main {

	public static <T> void main(String[] args) throws IOException {
		RedBlackTree<Comparable> rbt=new RedBlackTree<Comparable>();
		AugmentedTree<Comparable> arbt=new AugmentedTree<Comparable>();
		
		System.out.println("----RB-Tree----");
		String file="people";
        rbt.Reader(file+".txt");
        System.out.println("All items were inserted");
		rbt.getNumSmaller1("7/6/1991");
		rbt.getNumSmaller2("9988");
		rbt.getMax(rbt.root);
		rbt.getMin(rbt.root);
		System.out.println("The number of all people is "+rbt.size(rbt.root));
		System.out.println("--------Augmented RB-Tree--------------");
		arbt.Reader(file+".txt");
        System.out.println("All items were inserted");
		arbt.getNumSmaller1("7/6/1991");
		arbt.getNumSmaller2("9988");
		arbt.getMax(arbt.root);
		arbt.getMin(arbt.root);
		System.out.println("The number of all people is "+arbt.size(arbt.root));
		
		
		Scanner scan = new Scanner(System.in);
        
        while (true) {
        	rbt.flag=false;
            System.out.println("\n1.- Add items\n"
                    + "2.- PrintTrees\n"
                    + "3.- GetNumSmaller1\n"
                    + "4.- getNumSmaller2\n"
                    + "5.- getMax\n"
                    +"6.- getMin\n"
                    +"7.- size");
            int choice = scan.nextInt();

            int item;Scanner scanner=new Scanner(System.in);
            String datas=" ";
             switch (choice) {
                case 1:
                	
                	while(true) {
                		datas=scanner.nextLine();
                        if(datas.equals("-999"))
                        	break;
                       	rbt.insertOnMain(datas);
                        arbt.insertOnMain(datas);
                	}
                	System.out.println("All items were inserted");
                    break;
                case 2:
                		System.out.println("----RB-Tree----");
                    	rbt.printTree(rbt.root);
                    	System.out.println("-----Augmented Tree------");
                    	arbt.printTree(arbt.root);
                    
                    break;
                case 3:
                	System.out.println("? Date : ");
                	String date=scanner.nextLine();
                	System.out.println("----RB-Tree----");
                	rbt.getNumSmaller1(date);
                	System.out.println("-----Augmented Tree------");
                	if(rbt.flag==false) {
                   		System.out.println("Cannot find this '"+date+"' date");
                   		break;
                   	}
                	arbt.getNumSmaller1(date);
                	
                    break;
                case 4:

               	System.out.println("? Id :");
              	T id=(T) scan.next();
              	System.out.println("----RB-Tree----");
               	rbt.getNumSmaller2((Comparable) id);
               	System.out.println("-----Augmented Tree------");
               	arbt.getNumSmaller2((Comparable) id);
               	if(rbt.flag==false) {
               		System.out.println("Cannot find this '"+id+"' id");
               	}
                break;
                case 5:
                	System.out.println("----RB-Tree----");
                	rbt.getMax(rbt.root);
                	System.out.println("-----Augmented Tree------");
                	arbt.getMax(arbt.root);
                    break;
                case 6:
                	System.out.println("----RB-Tree----");
                	rbt.getMin(rbt.root);
                	System.out.println("-----Augmented Tree------");
                	arbt.getMin(arbt.root);
                	break;
                case 7:
                	System.out.println("----RB-Tree----");
                	System.out.println("The number of all people is "+rbt.size(rbt.root));
                	System.out.println("-----Augmented Tree------");
                	System.out.println("The number of all people is "+arbt.size(arbt.root));
//            }
        
    }
	}
	}
	}	
        
    


