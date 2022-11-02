import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class P4 {


    public static void main(String[] args) {
        String symbols = "ACGT";
        Trie trie = new Trie(symbols);

        File file = new File("src/rosalind_ba9a.txt");
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()){
                String line=scanner.nextLine();
                trie.addString(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();


        }
        try {
            PrintWriter result=new PrintWriter("src/P4-result.txt");
            result.write(trie.description);
            result.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(trie.description);
    }

    static class Trie{

        Node root;
        String symbols;
        String description="";
        int maxId=0;
        public Trie(String symbols){
            this.symbols=symbols;
            root=new Node(maxId,symbols.length());
            maxId++;
        }

        public void addString(String str){
            Node currentNode=root;
            for (int i = 0; i <str.length() ; i++) {
                int index=symbols.indexOf(str.charAt(i)+"");
                if(currentNode.hasChild(index)){
                    currentNode=currentNode.getChild(index);
                }else{
                    description=description+currentNode.id+"->"+maxId+":"+str.charAt(i)+"\n";
                    Node node=new Node(maxId,symbols.length());
                    currentNode.setChild(node,index);
                    currentNode=node;
                    maxId++;
                }
            }
        }
    }

    static class Node {
        int id;
        Node[] children;

        public Node(int id, int childrenNumber) {
            this.id = id;
            this.children = new Node[childrenNumber];
        }

        public boolean hasChild(int index) {
            if (children[index] != null)
                return true;
            else
                return false;
        }

        public Node getChild(int index) {
            return children[index];
        }

        public void setChild(Node node, int index) {
            children[index] = node;
        }

    }
}

