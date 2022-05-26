# interview -> https://www.youtube.com/watch?v=tMSdjPKFRD4
2D array to 1D = (x,y) = x * # of col + y </br>
1D to 2D = k =  (x = k / # of col, y = k % # of col)

Depth First Traversals: 
(a) Inorder (Left, Root, Right) : 4 2 5 1 3 
(b) Preorder (Root, Left, Right) : 1 2 4 5 3 
(c) Postorder (Left, Right, Root) : 4 5 2 3 1
Breadth-First or Level Order Traversal: 1 2 3 4 5 

you can use lambda expression since Java 8.

The following code will print 10, the larger.

// There is overflow problem when using simple lambda as comparator, as pointed out by Фима Гирин.
// PriorityQueue<Integer> maxPQ = new PriorityQueue<>((x, y) -> y - x);

PriorityQueue<Integer> maxPQ =new PriorityQueue<>((x, y) -> Integer.compare(y, x));
PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder()); 

pq.add(10);
pq.add(5);
System.out.println(pq.peek());

Sort ArrayList containing custom objects

Collections.sort(Database.arrayList, (o1, o2) -> o1.getStartDate().compareTo(o2.getStartDate()));
Database.arrayList.sort((o1, o2) -> o1.getStartDate().compareTo(o2.getStartDate()));
Database.arrayList.sort(Comparator.comparing(MyObject::getStartDate));
