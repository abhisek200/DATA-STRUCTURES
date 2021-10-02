import java.util.ArrayList;

public class SetOfStacks {
    ArrayList<Single_Stack_SOP.StackNode> stacks=new ArrayList<>();
    public int capacity;

    SetOfStacks(int capacity){
        this.capacity=capacity;
    }

    public Single_Stack_SOP.StackNode getLastStack(){
        if(stacks.size()==0)
            return null;
        return stacks.get(stacks.size()-1);
    }
}
