public class Main {
    public static void main(String[] args) {
        TreeNode drinks=new TreeNode("Drinks");
        TreeNode hot=new TreeNode("Hot");
        TreeNode cold=new TreeNode("Cold");
        TreeNode tea=new TreeNode("tea");
        TreeNode coffee=new TreeNode("Coffee");
        TreeNode nonAlc=new TreeNode("Non-Alcoholic");
        TreeNode alc =new TreeNode("Alcoholic");
        drinks.addChild(hot);
        drinks.addChild(cold);
        hot.addChild(tea);
        hot.addChild(coffee);
        cold.addChild(nonAlc);
        cold.addChild(alc);
        System.out.println(drinks.print(0));

    }
}
