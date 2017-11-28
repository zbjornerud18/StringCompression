import sun.tools.tree.SuperExpression;

public class hTNode<Key extends Comparable<Key>, Value> extends Node implements Comparable {




    @Override
    public int compareTo(Object o) {
        return ((Node)o).getKey().compareTo(this.getKey());
    }

    /*
    public int compareTo(Comparable o){
       return ((Node)o).getKey().compareTo(this.getKey());

    }
     */
    public hTNode (Key key,Value value,int size){
        super(key, value, size);
    }

    public boolean isLeaf(){
        if (this.getLeft() == null && this.getRight() ==null){
            return true;

        }
        else{
            return false;
        }
    }



}
